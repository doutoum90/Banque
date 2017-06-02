package td.eco.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import td.eco.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
