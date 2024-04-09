package scenarioTest;

import personnages.Gaulois;
import produit.Poisson;
import produit.Produit;
import produit.Sanglier;
import village.IVillage;

import villagegauloisold.DepenseMarchand;
import villagegaulois.Etal;

public class Scenario {

	public static void main(String[] args) {

		// TODO Partie 4 : creer de la classe anonyme Village
		class Village <P extends Produit> implements IVillage{
			@Override
			public DepenseMarchand[] acheterProduit(String produit, int quantiteSouhaitee) {
				int sommeDepensee = 0;
				Gaulois vendeur = new Gaulois("Asterix", 0);
				DepenseMarchand[] dm = new DepenseMarchand[](vendeur,quantiteSouhaitee,produit, sommeDepensee);
				return dm;
			}

			@Override
			public <P extends Produit> boolean installerVendeur(Etal <P> etal, Gaulois vendeur, P[] produit, int prix) {
				if (etal != null) {
		            return false; // L'étal est déjà occupé
		        }

		        // L'étal est libre, on peut l'installer
		        etal.installerVendeur(vendeur, produit, produit.length);
		        return true;
			}
			
		}
		// fin

		Gaulois ordralfabetix = new Gaulois("Ordralfabétix", 9);
		Gaulois obelix = new Gaulois("Obélix", 20);
		Gaulois asterix = new Gaulois("Astérix", 6);

		Etal<Sanglier> etalSanglierObelix = new Etal<Sanglier>(obelix, new Sanglier[] { new Sanglier(2000, obelix), new Sanglier(1500, obelix) }, 8);
		Etal<Sanglier> etalSanglierAsterix = new Etal<Sanglier>(asterix, new Sanglier[] { new Sanglier(1000, asterix), new Sanglier(500, asterix) }, 10);
		Etal<Poisson> etalPoisson = new Etal<Poisson>(ordralfabetix, new Poisson[] { new Poisson("lundi") }, 5);

		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);

		Sanglier[] sangliersObelix = { sanglier1, sanglier2 };
		Sanglier[] sangliersAsterix = { sanglier3, sanglier4 };

		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = { poisson1 };

		IVillage village = new Village();
		village.installerVendeur(etalSanglierAsterix, asterix, sangliersAsterix, 10);
		village.installerVendeur(etalSanglierObelix, obelix, sangliersObelix, 8);
		village.installerVendeur(etalPoisson, ordralfabetix, poissons, 5);

		System.out.println(village);

		DepenseMarchand[] depense = village.acheterProduit("sanglier", 3);

		for (int i = 0; i < depense.length && depense[i] != null; i++) {
			System.out.println(depense[i]);
		}

		System.out.println(village);

	}

}