package fatecfranca.edu.lojapratica.controller;

import fatecfranca.edu.lojapratica.model.entity.ClienteEntity;
import fatecfranca.edu.lojapratica.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService injecao;
    @PostMapping
    public ClienteEntity insere(@RequestBody ClienteEntity cliente) {
        return injecao.insere(cliente);
    }
}
