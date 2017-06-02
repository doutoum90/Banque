package td.eco.Metier;

import org.springframework.data.domain.Page;

import td.eco.entities.Compte;
import td.eco.entities.Operation;

public interface IBanqueMetier {

	public Compte ConsulterCompte(String code);
	public void verser(String code, double montant);
	public void retirer(String code, double montant);
	public void virement(String code1, String code2, double montant);
	public Page<Operation> listeOperation(String code, int page, int size); 
	
}
