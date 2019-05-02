import java.util.Random;

public class Cell {

	private int etat;// alive or dead
	Random random = new Random();

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	public Cell() {
		super();

		this.etat = generateCel();
	}
	
	
	
	public int generateCel() {
		return random.nextInt(2);

	}

}
