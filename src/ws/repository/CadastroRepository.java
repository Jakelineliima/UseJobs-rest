package ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import ws.model.Cadastrovaga;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastrovaga, Long> {
	
}
