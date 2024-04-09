package produit;

public class Poisson extends Produit{
	
	String dateDePeche;
	public Poisson(String dateDePeche) {
		nom = "poisson";
		this.dateDePeche = dateDePeche;
		
	}

	@Override
	public String description() {
		return (nom + " peches " + dateDePeche);
	}
	@Override
	public int calculerPrix(int Prix) {
		return 0;
	}
}
