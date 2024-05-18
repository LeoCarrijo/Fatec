package fatecfranca.edu.lojapratica.service;

import fatecfranca.edu.lojapratica.model.dto.ClienteDTO;
import fatecfranca.edu.lojapratica.model.entity.ClienteEntity;
import fatecfranca.edu.lojapratica.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository injecao;
    public ClienteDTO insere(ClienteDTO clienteDTO) {
        ClienteEntity clienteEntity = converteParaEntity(clienteDTO);
        return converteParaDTO(injecao.save(clienteEntity));
    }

    public List<ClienteDTO> consultaTodos() {
        return converteEntitiesParaDTOs(injecao.findAll());
    }

    public String deletarCliente(Long id) {
        if(injecao.existsById(id)) {
            injecao.deleteById(id);
            return "Cliente deletado com sucesso!";
        }
        return "Cliente não encontrado para remoção";
    }

    public List<ClienteDTO> converteEntitiesParaDTOs(List<ClienteEntity> clienteEntities) {
        List<ClienteDTO> clienteDTOs = new ArrayList<ClienteDTO>();
        for(ClienteEntity clienteEntity : clienteEntities){
            clienteDTOs.add(converteParaDTO(clienteEntity));
        }
        return clienteDTOs;
    }

    public ClienteDTO consultaPorId(Long id) {
        Optional<ClienteEntity> cliente = injecao.findById(id);
        if(cliente.isPresent()) {
            return converteParaDTO(cliente.get());
        }
        return null;
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
