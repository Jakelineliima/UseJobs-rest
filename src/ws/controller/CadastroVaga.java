package ws.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ws.model.Cadastrovaga;
import ws.repository.CadastroRepository;


@RestController
public class CadastroVaga {
	
	@Autowired
	private CadastroRepository cadastroRepository;
	
	@RequestMapping(value= "/cadastrovaga", method = RequestMethod.GET,
			produces = "application/json")
	public List<Cadastrovaga> Get(){
		return cadastroRepository.findAll();
	}
	@RequestMapping(value = "/cadastrovaga", method = RequestMethod.POST,
			consumes = "application/json", produces = "application/json")
		public Cadastrovaga POST(@Valid @RequestBody Cadastrovaga cadastrovaga) {
				return cadastroRepository.save(cadastrovaga);
			}
}
