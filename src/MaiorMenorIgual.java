import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MaiorMenorIgual {
	
	private static class Mesa extends JPanel{
		private Image imgMesa, imgBarralho, imgCartaActual, ImgCarta;
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			try {
				imgMesa = ImageIO.read(new File("src/mesa.png"));
				imgBarralho = ImageIO.read(new File("src/barralho.png"));
				imgCartaActual = ImageIO.read(new File("src/Barralho/AE.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.drawImage(imgMesa, 0, 0, this);
			g.drawImage(imgBarralho, 20, 200, 150, 210, this);
			g.drawImage(imgCartaActual, 810, 200, 150, 230, this);
		}
	}
	
	public static Image imagem(String naipe, String valor) throws IOException {
		if (naipe == "ESPADA" && valor == "DOIS") {
			return ImageIO.read(new File("src/Barralho/2E.png"));
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		Image imagem;
		Mesa mesa = new Mesa();
		JFrame janela = new JFrame("Previsao");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setResizable(false);
		janela.setSize(1000, 630);
		janela.getContentPane().add(mesa);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		
		
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
			/*System.out.println("A carta actual e " + cartaActual.toString());

			System.out.println();*/
			
			try {
				imagem = imagem(cartaActual.getNaipeSting(),cartaActual.getValorString());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
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
