package ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Service;

import ws.model.Cadastrovaga;

@Service
public interface CadastroRepository extends JpaRepository<Cadastrovaga, Long> {
	
}
