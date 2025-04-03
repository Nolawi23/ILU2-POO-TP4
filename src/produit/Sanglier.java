package produit;

import personnages.Gaulois;

public class Sanglier extends Produit {
	private int poids;
	private Gaulois chasseur;

	public Sanglier(int poids, Gaulois chasseur ) {
		super("sanglier", Unite.KILOGRAMME);
		this.poids = poids;
		this.chasseur = chasseur;
	}

	@Override
	public void decritProduit() {
		System.out.println(getNom() + " de " + poids + unite + " chassé par " + chasseur.getNom());
	}
}
