import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MaiorMenorIgual {

	public static void main(String[] args) {
		
		Barralho b = new Barralho();
		b.baralhar();
		Carta cartaActual, cartaSeguinte = null;
		int palpite;
		int cont;
		int pontosJogo = 0;
		boolean jogo=true;
		do {
			System.out.println("**********************************");
			if (cartaSeguinte == null) {
				do {
					cartaActual = b.darCarta();
				} while (cartaActual.toString().equalsIgnoreCase("Joker"));
			}else {
				cartaActual=cartaSeguinte;
			}
			System.out.println("A carta actual e " + cartaActual.toString());

			System.out.println();
			
			cont = 0;
			do {

				if (cont > 0)
					System.out.println("Opcao inserida invalida!!!");
				System.out.println(
						"Qual o seu palpite para a carta seguinte?\n\n[0]. Igual a actual\n[1]. Maior que a actual\n[2]. Menor que a actual");
				palpite = Ler.umInt();
				cont++;
			} while (palpite < 0 || palpite > 2);

			do {
				cartaSeguinte = b.darCarta();
			} while (cartaActual.toString().equalsIgnoreCase("Joker"));

			System.out.println("A carta seguinte e " + cartaSeguinte.toString());

			if (cartaActual.getValorInt() == cartaSeguinte.getValorInt() && palpite == 0
					|| cartaActual.getValorInt() < cartaSeguinte.getValorInt() && palpite == 1
					|| cartaActual.getValorInt() > cartaSeguinte.getValorInt() && palpite == 2) {
				System.out.println("O seu palpite esta correcto...");
				pontosJogo++;
				
			} else {
				System.out.println("O seu palpite esta errado... perdeu o jogo!!!");
				jogo=false;
			}

		} while (jogo);
	}

}
