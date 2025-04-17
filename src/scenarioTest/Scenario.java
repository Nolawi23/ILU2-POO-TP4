package scenarioTest;

import personnages.Gaulois;
import produit.Poisson;
import produit.Produit;
import produit.Sanglier;
import villagegaulois.Etal;
import villagegaulois.IEtal;
import villagegaulois.IVillage;

public class Scenario {

	public static void main(String[] args) {

		class Village implements IVillage{
			
			private IEtal[] marche = new Etal[4];
			private int nbEtal = 0;
			
			@Override
			public <P extends Produit> boolean installerVendeur(Etal<P> etal, Gaulois vendeur, P[] produit, int prix) {
				this.marche[nbEtal] = etal;
				nbEtal++;
				etal.installerVendeur(vendeur, produit, prix);
				return true;
			}
			
			@Override
			public void acheterProduit(String produit, int quantiteSouhaitee) {
				int quantiteAchetee = 0;
				int totalAchete = 0;
				for (int i = 0; i< nbEtal; i++) {
					quantiteAchetee = marche[i].contientProduit(produit, quantiteSouhaitee - quantiteAchetee);
					if (quantiteAchetee!= 0) {
						System.out.println("A l'etal n°" + (i+1) + " j'achete " + quantiteAchetee + " " + produit + " et je paye " + marche[i].acheterProduit(quantiteAchetee) + " sous.\n");
						totalAchete += quantiteAchetee;
					}
				}
				System.out.println("Je voulais " + quantiteSouhaitee + " " + produit + "(s), j'en ai acheté " + totalAchete + ".\n");

			}
			
			@Override
			public String toString() {
				StringBuilder texte = new StringBuilder();
				for (int i = 0; i < nbEtal; i++) {
					texte.append(marche[i].etatEtal());
				}
				return texte.toString();
			}

			
		}
		Village village = new Village();
		
		Gaulois ordralfabetix = new Gaulois("Ordralfabétix", 9);
		Gaulois obelix = new Gaulois("Obélix", 20);
		Gaulois asterix = new Gaulois("Astérix", 6);

		Etal<Sanglier> etalSanglierObelix = new Etal<>();
		Etal<Sanglier> etalSanglierAsterix = new Etal<>();
		Etal<Poisson> etalPoisson = new Etal<>();

		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);

		Sanglier[] sangliersObelix = { sanglier1, sanglier2 };
		Sanglier[] sangliersAsterix = { sanglier3, sanglier4 };

		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = { poisson1 };

		village.installerVendeur(etalSanglierAsterix, asterix, sangliersAsterix, 10);
		village.installerVendeur(etalSanglierObelix, obelix, sangliersObelix, 8);
		village.installerVendeur(etalPoisson, ordralfabetix, poissons, 5);

		System.out.println(village);

		village.acheterProduit("sanglier", 3);

		System.out.println(village);
	}

}
