package fatecfranca.edu.saudacao.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MensagemController {
	@RequestMapping("/boanoite") // Avisa qual o endereço que vai ser utilizado para fazer o método
	public String boaNoite() {
		return "Tenha uma boa noite";
	}
	
	@RequestMapping("/bomdia/{nome}")
	public String bomDia(@PathVariable String nome) {
		return nome + ", tenha um bom dia! >w<";
	}
}
