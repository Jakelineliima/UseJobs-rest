package ws.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
	@RequestMapping(value = "/usuarioint", method = RequestMethod.POST,
			consumes = "application/json", produces = "application/json")
	public Curriculo post(@Valid @RequestBody Curriculo curriculo) {
		return curriculoRepository.save(curriculo);
	}
	
	@RequestMapping(value = "usuarioint/{id}", method = RequestMethod.GET,
			produces = "application/json")
	public ResponseEntity<Curriculo> getPorCodigo(@PathVariable(value = "id")long id){
		Optional<Curriculo> curriculo = curriculoRepository.findById(id);
		if(curriculo.isPresent()) {
			return new ResponseEntity<Curriculo>(curriculo.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "usuarioint/{id}", method = RequestMethod.PUT,
			consumes = "application/json", produces = "application/json")
	public ResponseEntity<Curriculo> put(@PathVariable(value = "id") long id,
			@Valid @RequestBody Curriculo editCurriculo){
		Optional<Curriculo> antigoCurriculo = curriculoRepository.findById(id);
		if(antigoCurriculo.isPresent()) {
			Curriculo curriculo = antigoCurriculo.get();
			curriculo.setNome(editCurriculo.getNome());
			curriculo.setTelefone(editCurriculo.getTelefone());
			curriculo.setEndereco(editCurriculo.getEndereco());
			curriculo.setEscolaridade(editCurriculo.getEscolaridade());
			curriculo.setExperiencia(editCurriculo.getExperiencia());
			curriculoRepository.save(curriculo);
			return new ResponseEntity<Curriculo>(curriculo, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "usuarioint/{id}", method = RequestMethod.DELETE,
			produces = "application/json")
	public ResponseEntity<Object> delete(@PathVariable(value = "id") long id){
		Optional<Curriculo> curriculo = curriculoRepository.findById(id);
		if(curriculo.isPresent()) {
			curriculoRepository.delete(curriculo.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
}
