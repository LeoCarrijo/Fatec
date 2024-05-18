package fatecfranca.edu.lojapratica;

import fatecfranca.edu.lojapratica.model.entity.ClienteEntity;
import fatecfranca.edu.lojapratica.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository injecao;
    public ClienteEntity insere(ClienteEntity cliente) {
        return injecao.save(cliente);
    }
}
