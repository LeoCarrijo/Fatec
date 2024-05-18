package fatecfranca.edu.loja.service;

import fatecfranca.edu.loja.model.dto.ClienteDTO;
import fatecfranca.edu.loja.model.entity.ClienteEntity;
import fatecfranca.edu.loja.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    // Recupera um cliente a partir de um id
    public ClienteDTO consultaPorId(Long id) {
        Optional<ClienteEntity> cliente = injecao.findById(id);
        // verificar se tem cliente na resposta
        if (cliente.isPresent()) {
            return converteEntity(cliente.get()); // retorna o cliente entity encontrado
        }
        return null; // informa que não encontrou
    }

    // Consulta e trazer uma lista de clientes cadastrados no banco de dados
    public List<ClienteDTO> consultaTodos(){
        // Precisamos converter uma lista de clienteEntity em outra lista
        // de clienteDTO
        return converteEntities(injecao.findAll());
    }

    // Deleta um usuário do BD
    public String deletarCliente(Long id) {
        if(injecao.existsById(id)){
            injecao.deleteById(id);
            return "Remoção concluída com sucesso";
        }else{
            return "Cliente não encontrado para remoção";
        }

    }

    // Converte uma lista de ClienteEntity em outra lista de ClienteDTO
    public List<ClienteDTO> converteEntities(List<ClienteEntity> listaEntities) {
        // Cria uma lista que vai guardar os ClienteDTOs
        List<ClienteDTO> listaDTOs = new ArrayList<ClienteDTO>();
        // Percorre a lista de ClienteEntity
        for(ClienteEntity objEntity : listaEntities){
            listaDTOs.add(converteEntity(objEntity));
        }
        return listaDTOs;
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
