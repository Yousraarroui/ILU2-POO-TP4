package produit;

import personnages.Gaulois;

public class Sanglier extends Produit{
	
	Gaulois chasseur;
	int poids;
	public Sanglier(int unite,Gaulois chasseur) {
		nom = "sanglier";
		this.chasseur = chasseur;
		this.unite = unite;
	}
	@Override
	public String description() {
		return ( nom + " de " + unite + " kg chasse par " + chasseur.getNom());
		
	}
	@Override
	public int calculerPrix(int Prix) {
		return 0;
	}
}
