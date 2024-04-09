package scenarioTest;

import personnages.Gaulois;
import produit.Poisson;
import produit.Produit;
import produit.Sanglier;
import villagegaulois.Etal;

public class ScenarioTest {
    public static void main(String[] args) {
    	Gaulois ordralfabetix = new Gaulois("Ordralfabétix",9);
    	Gaulois obelix = new Gaulois("Obélix",20);
    	Gaulois asterix = new Gaulois("Asterix", 6);
    	Sanglier sanglier1 = new Sanglier(2000, obelix);
    	Sanglier sanglier2 = new Sanglier(1500, obelix);
    	Sanglier sanglier3 = new Sanglier(1000, asterix);
    	Sanglier sanglier4 = new Sanglier(500, asterix);
    	Sanglier[] sangliersObelix = {sanglier1, sanglier2};
    	Sanglier[] sangliersAsterix = {sanglier3, sanglier4};
    	Poisson poisson1 = new Poisson("lundi");
    	Poisson[] poissons = {poisson1};
    	Etal<Sanglier> Esanglier1 = new Etal<Sanglier>(asterix, sangliersAsterix, 10);
    	Etal<Sanglier> Esanglier2 = new Etal<Sanglier>(obelix, sangliersObelix, 8);
    	Etal<Poisson> Epoisson = new Etal<Poisson>(ordralfabetix, poissons, 7);
    	Etal<? extends Produit>[] marche = new Etal[3];
    	marche[0] = Esanglier1;
    	marche[1] = Esanglier2;
    	marche[2] = Epoisson;
    	
    	System.out.println("ETAT MARCHE\n");
    	for (int i = 0; i < marche.length; i++) {
    	    Etal<? extends Produit> etal = marche[i];
    	    System.out.println(etal.etatEtal());
    	}
    	int nbEtal = 0;
    	for (int i = 0; i < marche.length &&  nbEtal < 3; i++) {
    	    Etal<? extends Produit> etal = marche[i];
    	    
    	    int quantiteSouhaitee = 3 - nbEtal;
    	    int quantiteDisponible = etal.contientProduit("sanglier", quantiteSouhaitee);
    	    double prixPaye = etal.acheterProduit(quantiteDisponible);

    	    if (quantiteDisponible > 0) {
    	        System.out.println("A l'étal " + nbEtal + " je paye " + prixPaye + " sous.");
				nbEtal += 1;
    	    }
    	}
    	// Afficher les étals du marché après l'achat
    	System.out.println("ETAT MARCHE");
    	for (int i = 0; i < marche.length; i++) {
    	    Etal<? extends Produit> etal = marche[i];
    	    System.out.println(etal.etatEtal());
    	}

    }
}


