package ws.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ws.model.Curriculo;
import ws.repository.CurriculoRepository;

@RestController
public class CurriculoCadastro {
	
	@Autowired
	private CurriculoRepository curriculoRepository;
	
	@RequestMapping(value = "/interessado", method = RequestMethod.GET,
			produces="application/json")
	public List<Curriculo> Get() {
		return curriculoRepository.findAll();
	}
	@RequestMapping(value = "/interessado", method = RequestMethod.POST,
			consumes = "application/json", produces = "application/json")
	public Curriculo post(@Valid @RequestBody Curriculo curriculo) {
		return curriculoRepository.save(curriculo);
	}
	
	
}
