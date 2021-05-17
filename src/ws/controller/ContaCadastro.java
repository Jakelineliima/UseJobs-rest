package ws.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import ws.model.Usuario;
import ws.repository.UsuarioRepository;

@RestController
public class ContaCadastro {
	
	@Autowired
	private UsuarioRepository contaRepository;
	
	@RequestMapping(value = "criarconta", method = RequestMethod.GET,
			produces = "application/json")
	public List<Usuario> Get() {
		return contaRepository.findAll();
	}
	@RequestMapping(value = "/criarconta", method = RequestMethod.POST,
			consumes = "application/json", produces = "application/json")
	public Usuario post(@Valid @RequestBody Usuario conta) {
		return contaRepository.save(conta);
	}
	
	
	//Login
	
	
	
}
