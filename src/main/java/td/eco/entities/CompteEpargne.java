package td.eco.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte implements Serializable{
	private double taux;

	public CompteEpargne(String numCompte, Date dateCreation, double solde, Client client, double taux) {
		super(numCompte, dateCreation, solde, client);
		this.taux = taux;
	}

	public CompteEpargne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}
}
