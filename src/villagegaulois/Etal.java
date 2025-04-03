package villagegaulois;

import personnages.Gaulois;
import produit.IProduit;
import produit.Produit;

public class Etal<P extends IProduit> implements IEtal {
	private Gaulois vendeur;
	private P[] produits;
	private int nbProduit = 0;
	private int quantiteDebutMarche;
	private int quantite;
	private boolean etalOccupe = false;
	private int prix;
	
	public void installerVendeur(Gaulois vendeur, P[] produit, int prix) {
		this.vendeur = vendeur;
		this.produits = produit;
		this.prix = prix;
	}

	@Override
	public boolean isEtalOccupe() {
		return etalOccupe;
	}

	@Override
	public Gaulois getVendeur() {
		return vendeur;
	}

	@Override
	public int getQuantite() {
		return quantite;
	}

	@Override
	public int contientProduit(String produit, int quantiteSouhaitee) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int acheterProduit(int quantiteSouhaitee) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String etatEtal() {
		// TODO Auto-generated method stub
		return null;
	}

}
