import java.util.Random;

public class Barralho {

	private Carta[] baralho;
	private int nCartas;

	public Barralho() {
		restituirBaralho();
	}
	
	public void baralhar() {
		Carta aux;
		int pos;
		Random r = new Random();
		for (int i = 0; i < baralho.length; i++) {
			pos = r.nextInt(nCartas);
			aux = baralho[pos];
			baralho[pos] = baralho[i];
			baralho[i] = aux;
		}
	}
	/*
	 * retira ujma carta do baralho.
	 */
	public Carta darCarta() {
		Carta c=baralho[nCartas-1];
		baralho[nCartas-1]=null;
		nCartas--;
		return c;
	}
	
	public void restituirBaralho() {
		baralho = new Carta[] {
				new Carta(),new Carta(),
				new Carta(1,1),new Carta(1,2),new Carta(1,3),new Carta(1,4),new Carta(1,5),new Carta(1,6),new Carta(1,7),new Carta(1,8),new Carta(1,9),new Carta(1,10),new Carta(1,11),new Carta(1,12),new Carta(1,13),
				new Carta(2,1),new Carta(2,2),new Carta(2,3),new Carta(2,4),new Carta(2,5),new Carta(2,6),new Carta(2,7),new Carta(2,8),new Carta(2,9),new Carta(2,10),new Carta(2,11),new Carta(2,12),new Carta(2,13),
				new Carta(3,1),new Carta(3,2),new Carta(3,3),new Carta(3,4),new Carta(3,5),new Carta(3,6),new Carta(3,7),new Carta(3,8),new Carta(3,9),new Carta(3,10),new Carta(3,11),new Carta(3,12),new Carta(3,13),
				new Carta(4,1),new Carta(4,2),new Carta(4,3),new Carta(4,4),new Carta(4,5),new Carta(4,6),new Carta(4,7),new Carta(4,8),new Carta(4,9),new Carta(4,10),new Carta(4,11),new Carta(4,12),new Carta(4,13)	
			};
			nCartas = baralho.length;
	}

}
