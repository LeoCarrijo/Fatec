package fatecfranca.edu.lojapratica.controller;

import fatecfranca.edu.lojapratica.model.dto.ClienteDTO;
import fatecfranca.edu.lojapratica.model.entity.ClienteEntity;
import fatecfranca.edu.lojapratica.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService injecao;
    @PostMapping
    public ClienteDTO insere(@RequestBody ClienteDTO clienteDTO) {
        return injecao.insere(clienteDTO);
    }

    @GetMapping
    public List<ClienteDTO> consultaTodos() {
        return injecao.consultaTodos();
    }

    @GetMapping("{id}")
    public ClienteDTO consultaPorId(@PathVariable Long id) {
        return injecao.consultaPorId(id);
    }

    @DeleteMapping("/{id}")
    public String excluirPorId(@PathVariable Long id) {
        return injecao.deletarCliente(id);
    }
}
