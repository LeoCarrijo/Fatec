package fatecfranca.edu.lojapratica.service;

import fatecfranca.edu.lojapratica.model.dto.ClienteDTO;
import fatecfranca.edu.lojapratica.model.entity.ClienteEntity;
import fatecfranca.edu.lojapratica.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository injecao;
    public ClienteDTO insere(ClienteDTO clienteDTO) {
        ClienteEntity clienteEntity = converteParaEntity(clienteDTO);
        return converteParaDTO(injecao.save(clienteEntity));
    }

    public ClienteEntity converteParaEntity(ClienteDTO clienteDTO) {
        return new ClienteEntity(clienteDTO.getId(),
                clienteDTO.getNome(),
                clienteDTO.getNota(),
                clienteDTO.getIdade(),
                clienteDTO.isDevedor());
    }

    public ClienteDTO converteParaDTO(ClienteEntity clienteEntity) {
        return new ClienteDTO(clienteEntity.getId(),
                clienteEntity.getNome(),
                clienteEntity.getNota(),
                clienteEntity.getIdade(),
                clienteEntity.isDevedor());
    }

}
