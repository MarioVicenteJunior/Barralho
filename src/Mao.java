

/*
 * Classe Mao
 */
public class Mao {

	private final int NUMEROCARTAS; // constante que vai guardar o numero de
									// cartas que a m�o ter�
	private Carta[] cartas; // array para armazenar as cartas da m�o
	private int cartasMao; // vari�vel que indica o numero de cartas actualmente
							// existentes na m�o

	public Mao(int numerCartas) { // construtor que recebe por par�metro o
									// n�mero de cartas na m�o
		NUMEROCARTAS = numerCartas; // Inicializa��o da constante NUMEROCARTAS
									// com o n�mero de cartas da m�o recebido
									// por par�metro
		cartas = new Carta[NUMEROCARTAS]; // Cria��o do array para armazenar as
											// cartas da m�o
		cartasMao = 0; // inicializa��o do contador de cartas actuais na m�o

	}

	/*
	 * M�todo que descarta todas as cartas da m�o
	 */
	public void descartarMao() {
		cartasMao = 0;
		for (int i = 0; i < cartas.length; i++) {
			cartas[i] = null;
		}
	}

	/*
	 * M�todo que adiciona uma carta a m�o
	 */
	public void addCarta(Carta c) {
		cartas[cartasMao] = c;
		cartasMao++;
	}

	/*
	 * M�todo que recebe uma carta e remove a carta correspondente da m�o
	 */

	public void removeCarta(Carta c) {
		for (int i = 0; i < cartasMao; i++) {
			if (c == cartas[i]) {
				if (i != cartasMao - 1) {
					cartas[i] = cartas[cartasMao - 1];
					cartas[cartasMao - 1] = null;
				}
				cartasMao--;
				break;
			}
		}
	}

	/*
	 * M�todo que recebe um �ndice e remove a carta correspondente da m�o
	 */
	public void removeCarta(int idx) {
		idx--;
		if (idx < 0 || idx > cartasMao-1) {
			throw new IllegalArgumentException("�ndice inv�lido!!");
		} else {
			if (idx != cartasMao - 1) {
				cartas[idx] = cartas[cartasMao - 1];
				cartas[cartasMao - 1] = null;
			}
			cartasMao--;
		}
	}
	
	/*
	 * M�todo que retorna o n�mero de cartas actuais na m�o
	 */

	public int gerCartasMao(){
		return cartasMao;
	}
	
	/*
	 * M�todo que retorna uma  carta da m�o na posi��o recebida por par�metro
	 */
	public Carta getCarta(int idx){
		idx--;
		if (idx < 0 || idx > cartasMao-1) {
			throw new IllegalArgumentException("�ndice inv�lido!!");
		} else {
			return cartas[idx];
		}
	}
	

	/*
	 * M�todo que modela o m�todo toString
	 */
	public String toString() {
		String str = "";
		for (int i = 0; i < cartasMao; i++) {
			str += cartas[i].toString() + "\n";
		}
		return str;
	}

}
