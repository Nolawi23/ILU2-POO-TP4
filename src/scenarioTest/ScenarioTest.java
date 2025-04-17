package scenarioTest;

import personnages.Gaulois;
import produit.Poisson;
import produit.Sanglier;
import villagegaulois.Etal;
import villagegaulois.IEtal;

public class ScenarioTest {

//	public static void acheterProduit(Etal[] marche, String produit, int quantiteSouhaitee) {
//		int quantiteRestante = quantiteSouhaitee;
//		for (int i = 0; i < marche.length && quantiteRestante != 0; i++) {
//			Etal etal = marche[i];
//			int quantiteDisponible = etal.contientProduit(produit, quantiteRestante);
//			if (quantiteDisponible != 0) {
//				int prix = etal.acheterProduit(quantiteDisponible);
//				String chaineProduit = accorderNomProduit(produit, quantiteDisponible);
//				System.out.println("A l'étal n° " + (i + 1) + ", j'achete " + quantiteDisponible + " " + chaineProduit
//						+ " et je paye " + prix + " sous.");
//				quantiteRestante -= quantiteDisponible;
//			}
//		}
//		String chaineProduit = accorderNomProduit(produit, quantiteSouhaitee);
//		System.out.println("Je voulais " + quantiteSouhaitee + " " + chaineProduit + ", j'en ai acheté "
//				+ (quantiteSouhaitee - quantiteRestante) + ".");
//	}

	private static String accorderNomProduit(String produit, int quantiteSouhaitee) {
		String chaineProduit = produit;
		if (quantiteSouhaitee > 1) {
			chaineProduit = produit + "s";
		}
		return chaineProduit;
	}

	public static void main(String[] args) {
		Gaulois ordralfabetix = new Gaulois("Ordralfabétix", 9);
		Gaulois obelix = new Gaulois("Obélix", 20);
		Gaulois asterix = new Gaulois("Asterix", 6);

		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);
		Sanglier[] sangliersObelix = { sanglier1, sanglier2 };

		Sanglier[] sangliersAsterix = { sanglier3, sanglier4 };
		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = { poisson1 };

		IEtal[] marche = new Etal[3];
		Etal<Sanglier> etalSanglier1 = new Etal<>();
		marche[0] = etalSanglier1;
		Etal<Sanglier> etalSanglier2 = new Etal<>();
		marche[1] = etalSanglier2;
		Etal<Poisson> etalPoisson1 = new Etal<>();
		marche[2] = etalSanglier2;

		etalSanglier1.installerVendeur(asterix, sangliersAsterix, 10);
		etalSanglier2.installerVendeur(obelix, sangliersObelix, 8);
		etalPoisson1.installerVendeur(ordralfabetix, poissons, 7);

		System.out.println(etalSanglier1.etatEtal());
		System.out.println(etalSanglier2.etatEtal());
		System.out.println(etalPoisson1.etatEtal());

		System.out.println("A l'etal n°1 j'achete 2 sangliers et je paye " + etalSanglier1.acheterProduit(2) + " sous.");
		System.out.println("A l'etal n°2 j'achete 1 sangliers et je paye " + etalSanglier2.acheterProduit(1) + " sous.\n");
		
		System.out.println(etalSanglier1.etatEtal());
		System.out.println(etalSanglier2.etatEtal());
		System.out.println(etalPoisson1.etatEtal());

	}
}
