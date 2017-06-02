package td.eco.Metier;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import td.eco.dao.CompteRepository;
import td.eco.dao.OperationRepository;
import td.eco.entities.Compte;
import td.eco.entities.CompteCourant;
import td.eco.entities.Operation;
import td.eco.entities.Retrait;
import td.eco.entities.Versement;

@Service @Transactional
public class BanqueMetier implements IBanqueMetier{
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;

	@Override
	public Compte ConsulterCompte(String code) {
		Compte cpt=compteRepository.findOne(code);
		if(cpt==null) throw new RuntimeException("Compte Introuvable");
		return cpt ;
	}

	@Override
	public void verser(String code, double montant) {
		Compte cpt=ConsulterCompte(code);
		Versement versement=new Versement(new Date(), montant, cpt);
		operationRepository.save(versement);
		cpt.setSolde(cpt.getSolde()+montant);
		compteRepository.save(cpt);
	}

	@Override
	public void retirer(String code, double montant) {
		Compte cpt=ConsulterCompte(code);
		double facilitesCaisse=0;
		if(cpt instanceof CompteCourant)
			facilitesCaisse=((CompteCourant) cpt).getDecouvert();
		if(cpt.getSolde()+facilitesCaisse<montant)
			throw new RuntimeException("Solde Insuffisant");
		Retrait retrait=new Retrait(new Date(), montant, cpt);
		operationRepository.save(retrait);
		cpt.setSolde(cpt.getSolde()-montant);
		compteRepository.save(cpt);
	}

	@Override
	public void virement(String code1, String code2, double montant) {
		retirer(code1, montant);
		verser(code2, montant);
		
	}

	@Override
	public Page<Operation> listeOperation(String code, int page, int size) {
		
		return operationRepository.listeOperation(code, new PageRequest(page, size));
	}
}
