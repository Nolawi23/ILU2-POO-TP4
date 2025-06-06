package produit;

public abstract class Produit implements IProduit {
	private String nom;
	protected Unite unite;

	protected Produit(String nom, Unite unite) {
		this.nom = nom;
		this.unite = unite;
	}

	@Override
	public String getNom() {
		return nom;
	}
	
	@Override
	public int calculerPrix(int prix) {
		return prix;
	}
}
