package produit;

public abstract class Produit implements IProduit {
	String nom;
	int unite;
	@Override
	public String getNom() {
		return nom;
	}
	@Override
	public abstract String description();
	
	@Override
	public int calculerPrix(int Prix) {
		return Prix;
	}
}
