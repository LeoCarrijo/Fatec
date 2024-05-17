package fatecfranca.edu.loja.service;

import fatecfranca.edu.loja.model.dto.ClienteDTO;
import fatecfranca.edu.loja.model.entity.ClienteEntity;
import fatecfranca.edu.loja.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    // injeção de dependência
    @Autowired
    ClienteRepository injecao;
    public ClienteDTO insere(ClienteDTO clienteDTO){
        ClienteEntity clienteEntity = converteDTO(clienteDTO);
        // o converteEntity retornado pelo método save foi convertido em DTO
        return converteEntity(injecao.save(clienteEntity));
    }

    // Converte ClienteDTO para ClienteEntity
    public ClienteEntity converteDTO(ClienteDTO clienteDTO) {
        return new ClienteEntity(clienteDTO.getId(),
                clienteDTO.getNome(),
                clienteDTO.getNota(),
                clienteDTO.getIdade(),
                clienteDTO.isDevedor());
    }

    // Converte ClienteEntity para ClienteDTO
    public ClienteDTO converteEntity(ClienteEntity clienteEntity) {
        ClienteDTO aux = new ClienteDTO();
        return new ClienteDTO(clienteEntity.getId(),
                clienteEntity.getNome(),
                clienteEntity.getNota(),
                clienteEntity.getIdade(),
                clienteEntity.isDevedor());
    }
}
