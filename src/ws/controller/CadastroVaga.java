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

import ws.model.Cadastrovaga;
import ws.repository.CadastroRepository;


@RestController
public class CadastroVaga {
	
	@Autowired
	private CadastroRepository cadastroRepository;
	
	@RequestMapping(value= "/vagas", method = RequestMethod.GET,
			produces = "application/json")
	public List<Cadastrovaga> Get() {
		return cadastroRepository.findAll();
	}
	@RequestMapping(value = "/cadastrarvaga", method = RequestMethod.POST,
			consumes = "application/json", produces = "application/json")
		public Cadastrovaga post(@Valid @RequestBody Cadastrovaga cadastrovaga) {
				return cadastroRepository.save(cadastrovaga);
			}
	
	
	@RequestMapping(value = "vagas/{id}", method = RequestMethod.GET,
			produces = "application/json")
	public ResponseEntity<Cadastrovaga> getPorCodigo(@PathVariable(value = "id") long id){
		Optional<Cadastrovaga> cadastrovaga = cadastroRepository.findById(id);
		if(cadastrovaga.isPresent()) {
			return new ResponseEntity<Cadastrovaga>(cadastrovaga.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/vagas{id}", method = RequestMethod.PUT,
			consumes = "application/json", produces = "application/json")
	public ResponseEntity<Cadastrovaga> put(@PathVariable(value = "id")long id,
			@Valid @RequestBody Cadastrovaga editVaga){
		Optional<Cadastrovaga> antigaVaga = cadastroRepository.findById(id);
		if(antigaVaga.isPresent()) {
			Cadastrovaga cadastrovaga = antigaVaga.get();
			cadastrovaga.setNome(editVaga.getNome());
			cadastrovaga.setTelefone(editVaga.getTelefone());
			cadastrovaga.setCargo(editVaga.getCargo());
			cadastrovaga.setEndereco(editVaga.getEndereco());
			cadastrovaga.setEscolaridade(editVaga.getEscolaridade());
			cadastrovaga.setExperiencia(editVaga.getEscolaridade());
			cadastroRepository.save(cadastrovaga);
			return new ResponseEntity<Cadastrovaga>(cadastrovaga, HttpStatus.OK);
			} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
	}
	
}
