package produit;

public class Poisson extends Produit {
	private String date;
	
	public Poisson(String date) {
		super("poisson", Unite.PIECE);
		this.date = date;
	}

	@Override
	public String decrireProduit() {
		String description = getNom() + " pechés " + date;
		return description;
	}

}
