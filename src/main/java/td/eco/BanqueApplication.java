package td.eco;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import td.eco.Metier.IBanqueMetier;
import td.eco.dao.ClientRepository;
import td.eco.dao.CompteRepository;
import td.eco.dao.OperationRepository;
import td.eco.entities.Client;
import td.eco.entities.Compte;
import td.eco.entities.CompteCourant;
import td.eco.entities.CompteEpargne;
import td.eco.entities.Operation;
import td.eco.entities.Retrait;
import td.eco.entities.Versement;

@SpringBootApplication
public class BanqueApplication implements CommandLineRunner{
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private IBanqueMetier banqueMetier;
	public static void main(String[] args) {
		SpringApplication.run(BanqueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*Client c1=clientRepository.save(new Client("Mahamat", "annour@yahoo.com"));
		Client c2=clientRepository.save(new Client("Ali", "ali@yahoo.com"));
		
		Compte cpt1= compteRepository.save(new CompteEpargne("le courageux", new Date(), 100000, c2, 0.5));
		Compte cpt2= compteRepository.save(new CompteCourant("Doutoum", new Date(), 100000, c2, 500));
		
		Operation o1=operationRepository.save(new Versement(new Date(), 5000,cpt1));
		Operation o2=operationRepository.save(new Versement(new Date(), 5000,cpt1));
		Operation o3=operationRepository.save(new Retrait(new Date(), 5000,cpt1));
		Operation o4=operationRepository.save(new Versement(new Date(), 5000,cpt1));
		
		Operation o5=operationRepository.save(new Versement(new Date(), 5000,cpt1));
		Operation o6=operationRepository.save(new Versement(new Date(), 5000,cpt1));
		Operation o7=operationRepository.save(new Retrait(new Date(), 5000,cpt1));
		Operation o8=operationRepository.save(new Versement(new Date(), 5000,cpt1));
		
		banqueMetier.verser("Doutoum", 88888);*/
	}
}
