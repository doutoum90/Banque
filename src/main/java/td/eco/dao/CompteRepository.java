package td.eco.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import td.eco.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, String> {

}
