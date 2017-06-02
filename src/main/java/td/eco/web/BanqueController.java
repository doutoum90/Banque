package td.eco.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import td.eco.Metier.IBanqueMetier;
import td.eco.entities.Compte;
import td.eco.entities.Operation;

@Controller
public class BanqueController {
	@Autowired
	private IBanqueMetier banqueMetier;
	
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/consulterCompte")
	public String consulterCompte(Model model, String numCompte, 
			@RequestParam(name="page", defaultValue="0")int page, 
			@RequestParam(name="size", defaultValue="5")int size){
		model.addAttribute("numCompte", numCompte);
		try {
			Compte cpt=banqueMetier.ConsulterCompte(numCompte);
			Page<Operation> listeOperation=banqueMetier.listeOperation(numCompte, page, size);
			model.addAttribute("listeOperation", listeOperation.getContent());
			int[] pages= new int[listeOperation.getTotalPages()];
			model.addAttribute("pages", pages);
			model.addAttribute("compte", cpt);
		} catch (Exception e) {
			model.addAttribute("exception", e);
		}
		
		return "comptes";
	}
	@RequestMapping(value="/saveOperation", method=RequestMethod.POST)
	public String saveOperation(Model model, String typeOperation, String numCompte,double montant, String numCompte2){
		try {
			if(typeOperation.equals("vers")){
				banqueMetier.verser(numCompte, montant);
			}else if(typeOperation.equals("retr")){
				banqueMetier.retirer(numCompte, montant);
			}else{
				banqueMetier.virement(numCompte, numCompte2, montant);
			}
		} catch (Exception e) {
			//model.addAttribute("error", e);
			return "redirect:/consulterCompte?numCompte="+numCompte+"&error="+e.getMessage();
		}
		return "redirect:/consulterCompte?numCompte="+numCompte;
	}
	@RequestMapping("/comptes")
	public String comptes(){
		return "comptes";
	}
	
	@RequestMapping("/operations")
	public String operations(){
		return "operations";
	}
	@RequestMapping("/clients")
	public String clients(){
		return "clients";
	}
	
}
