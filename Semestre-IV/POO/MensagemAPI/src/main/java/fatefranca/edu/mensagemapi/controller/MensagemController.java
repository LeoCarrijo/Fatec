package fatefranca.edu.mensagemapi.controller;

import org.springframework.web.bind.annotation.*;

@RestController // Classe que comtrola requisições Rest
@RequestMapping("/mensagem")
public class MensagemController {

    // Requisição com verbo http chamado GET
    @GetMapping("/boanoite")
    public String boaNoite(){
        return "Boa Noite, Bruno!" +
                "To on the line";
    }

    // Verbos HTTP:

    // Get -> consulta um recurso do servidor (select no BD)
    @GetMapping("/bomdia/{nome}")
    public String bomDia(@PathVariable String nome){
        return "Bom dia, " + nome + "!";
    }

    // Post -> insere um recurso no servidor (insert no BD)
    @GetMapping("/insere")
    public String insere(){
        return "Mensagem inserida com sucesso";
    }

    // Delete -> remove um recurso no servidor (delete no BD)
    @DeleteMapping("/remove")
    public String remove(){
        return "Mensagem removida com sucesso";
    }

    // Put -> atualiza vários recursos no servidor (update no BD)
    @PutMapping("/atualiza")
    public String atualiza(){
        return "Mensagens atualizadas com sucesso";
    }

    // Patch -> atualiza um recurso no servidor (update where no BD)
    @PatchMapping("/atualizaId/{id}")
    public String atualizaId(@PathVariable int id){
        return "Mensagem com id " + id + " atualizada com sucesso";
    }

    // Testador de APIs
    // INSOMNIA
    // POSTMAN
}
