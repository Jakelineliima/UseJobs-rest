package ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ws.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

}
