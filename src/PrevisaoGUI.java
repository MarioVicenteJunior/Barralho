import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class PrevisaoGUI extends JPanel implements ActionListener{
	
	private static BufferedImage [][] imagens;
	static Barralho b;
	private static Image imgCartaActual;
	//private static Carta cartaActual = b.darCarta();
	
	private static class Mesa extends JPanel  {
		private Image imgMesa, imgBarralho, ImgCarta;
		
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			try {
				imgMesa = ImageIO.read(new File("src/mesa.png"));
				imgBarralho = ImageIO.read(new File("src/barralho.png"));
		//		imgCartaActual = ImageIO.read(new File("src/Baralho/12A.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}

			g.drawImage(imgMesa, 0, 0, this);
			g.drawImage(imgBarralho, 20, 150, 150, 210, this);
			g.drawImage(Baralhar(), 820, 125, 160, 258, this);
			g.drawImage(imgCartaActual, 180, 125, 160, 258, this);
			
		}

		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equalsIgnoreCase("MAIOR")) {
		//	imgCartaActual = Baralhar();
		//	shouldRedraw = true; // Define a variável de estado para tru
			System.out.println("clicou botao maior");
		}
		//repaint();
	}
	
	public static class GestorEventos extends JPanel implements ActionListener{
		
		private Mesa mesa;
		
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equalsIgnoreCase("MAIOR")) {
				
				imgCartaActual = Baralhar();
				
				//	shouldRedraw = true; // Define a variável de estado para tru
					System.out.println("clicou botao maior");
				repaint();
			}else if (e.getActionCommand().equalsIgnoreCase("MENOR")) {
			//	mesa.imgCartaActual = Baralhar();
				//	shouldRedraw = true; // Define a variável de estado para tru
					System.out.println("clicou botao menor");
				repaint();
			}
				repaint();
		}
	}
	
	public static class Botao extends JButton {
		private Font fonte;
		private GestorEventos gestorEventos;
		
		public Botao(String text, GestorEventos gestorEventos) {
			super(text);
			this.gestorEventos = gestorEventos;
			fonte = new Font(Font.SERIF, Font.BOLD, 18);
			setFont(fonte);
			addActionListener(gestorEventos);
			
		}
	}
	
	public static class Botoes extends JPanel{
		private GridBagConstraints gbc;
		private GestorEventos gestorEventos;
		private JButton Maior = new JButton();
		
		public Botoes(GestorEventos gestorEventos) {
			super();
			//Maior.setBounds(250, 500, 500, 100);
			this.gestorEventos = gestorEventos;
			setLayout(new GridBagLayout());
			setBounds(250, 500, 500, 100);
			gbc = new GridBagConstraints();
			setBackground(new Color(0,0,0,0));
			load();
		}
		private void load() {
			Maior.setBounds(250, 500, 500, 100);
			gbc.insets = new Insets(5, 5, 5, 5);
			gbc.fill = GridBagConstraints.BOTH;
			gbc.gridx = 0;
			add(new Botao("MENOR", gestorEventos), gbc);
			gbc.gridx = 1;
			add(new Botao("MAIOR", gestorEventos), gbc);
			gbc.gridx = 2;
			add(new Botao("SALTAR", gestorEventos), gbc);
			gbc.gridx = 3;
			add(new Botao("PARAR", gestorEventos), gbc);
		}
	}
	
	public static class Texto extends JTextField{
		private StringBuilder displayContent ;
		private String memory;
		private Font fonte = new Font(Font.SERIF, Font.BOLD, 28);
		public Texto(int cols) {
			super(cols);
			displayContent = new StringBuilder(getText());
			setBounds(400, 20, 200, 50);
			setFont(fonte);
			setBackground(new Color(255, 255, 255, 128));
			Border b = BorderFactory.createLineBorder(Color.WHITE, 4);
			setBorder(b);
			setEditable(false);
			updateDisplay();
		}
		
		private void updateDisplay() {
			setText("1000");
			setHorizontalAlignment(JTextField.CENTER);
		}
	}
	
	public static class Status extends JTextField{
		private StringBuilder displayContent ;
		private String memory;
		private Font fonte = new Font(Font.SERIF, Font.BOLD, 28);
		public Status(int cols) {
			super(cols);
			displayContent = new StringBuilder(getText());
			setBounds(400, 400, 200, 50);
			setFont(fonte);
			setBackground(new Color(255, 255, 255, 128));
			/*Border b = BorderFactory.createLineBorder(Color.WHITE, 4);
			setBorder(b);*/
			setEditable(false);
			updateDisplay();
		}
		public void acertou() {
			displayContent = new StringBuilder("ACERTOU");
			updateDisplay();
		}
		private void updateDisplay() {
			setText(displayContent.toString());
		}
	}
	public static Image Baralhar() {
        int linhas = imagens.length;
        int colunas = imagens[0].length;
        int linhaAleatoria=0,  colunaAleatoria=0 ;
        Random rand = new Random();

     /*   for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                 linhaAleatoria = rand.nextInt(linhas);
                 colunaAleatoria = rand.nextInt(colunas);

                Image temp = imagens[i][j];
                imagens[i][j] = imagens[linhaAleatoria][colunaAleatoria];
                imagens[linhaAleatoria][colunaAleatoria] = (BufferedImage) temp;
            }
        }*/
        
        linhaAleatoria = rand.nextInt(linhas);
        colunaAleatoria = rand.nextInt(colunas);
        
        return imagens[linhaAleatoria][colunaAleatoria];
	}
        
	public static Image actual() {	
		return imagens[0][1];
	}
	
	public static void inicializarImagens() {
		/*
		 * Valores dos Naipes:
		 * A = 0 = Arroz / Paus
		 * C = 1 = Coracao ou Copas
		 * E = 2 = Espada
		 * O = 3 = Ouro
		 * */
	    String naipe = "ACEO";
	    imagens = new BufferedImage[4][13];
	    try {
	      for (int i = 0; i <= 3; i++) {
	    	  for (int x = 1; x <= 13; x++) {
	    		  char ch = naipe.charAt(i);
	    		  String filepath  = String.format("%s/%02d%c.png", "src/Baralho", x, ch);  // e.g., "cardset-oxymoron/05c.gif"
	    		  imagens[i][x-1] = ImageIO.read(new File(filepath));
	    	  }
	      }
	    } catch (IOException e) {
	      System.out.println("IOException -- probably wrong path to card image");
	    }
	  }

	private static void jogar() {
	/*	Carta cartaActual, cartaSeguinte = null;
		if (cartaActual.getValorInt() == cartaSeguinte.getValorInt() && palpite == 0
				|| cartaActual.getValorInt() < cartaSeguinte.getValorInt() && palpite == 1
				|| cartaActual.getValorInt() > cartaSeguinte.getValorInt() && palpite == 2) {
			System.out.println("O seu palpite esta correcto...");
			pontosJogo++;
			
		}*/
	}

	
	
	
	public PrevisaoGUI() {
		b = new Barralho();
		b.baralhar();
		
	}
	
	public static void main(String[] args) {
		inicializarImagens();
		Mesa mesa = new Mesa();		
		JFrame janela = new JFrame("Previsao");
		GestorEventos gestorEventos = new GestorEventos();
		Botoes botoes = new Botoes(gestorEventos);
		Texto texto = new Texto(0);
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setResizable(false);
		janela.setSize(1000, 620);
		janela.getContentPane().add(botoes);
		janela.getContentPane().add(texto);
		
		janela.getContentPane().add(mesa);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		jogar();
	}
}