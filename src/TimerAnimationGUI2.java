import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TimerAnimationGUI2 {

	public static class ScreenPanel extends JPanel implements ActionListener{
		private ImageIcon i1, i2, i3, i4, i5, i6, i7, i8, i9, i10;
		private int cont;

		public ScreenPanel() {
			// TODO Auto-generated constructor stub
			cont=1;
			i1=new ImageIcon("img\\c1-removebg-preview.png");
			i2=new ImageIcon("img\\c2-removebg-preview.png");
			i3=new ImageIcon("img\\c3-removebg-preview.png");
			i4=new ImageIcon("img\\c4-removebg-preview.png");
			i5=new ImageIcon("img\\c5-removebg-preview.png");
			i6=new ImageIcon("img\\c6-removebg-preview.png");
			i7=new ImageIcon("img\\c7-removebg-preview.png");
			i8=new ImageIcon("img\\c8-removebg-preview.png");
			i9=new ImageIcon("img\\c9-removebg-preview.png");
			i10=new ImageIcon("img\\c10-removebg-preview.png");
			Timer t=new Timer(100, this);
			t.start();
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
		
			switch(cont){
			case 1:g.drawImage(i1.getImage(), (getWidth()/2)-100, (getHeight()/2)-100, 200, 200, null);break;
			case 2:g.drawImage(i2.getImage(), (getWidth()/2)-100, (getHeight()/2)-100, 200, 200, null);break;
			case 3:g.drawImage(i3.getImage(), (getWidth()/2)-100, (getHeight()/2)-100, 200, 200, null);break;
			case 4:g.drawImage(i4.getImage(), (getWidth()/2)-100, (getHeight()/2)-100, 200, 200, null);break;
			case 5:g.drawImage(i5.getImage(), (getWidth()/2)-100, (getHeight()/2)-100, 200, 200, null);break;
			case 6:g.drawImage(i6.getImage(), (getWidth()/2)-100, (getHeight()/2)-100, 200, 200, null);break;
			case 7:g.drawImage(i7.getImage(), (getWidth()/2)-100, (getHeight()/2)-100, 200, 200, null);break;
			case 8:g.drawImage(i8.getImage(), (getWidth()/2)-100, (getHeight()/2)-100, 200, 200, null);break;
			case 9:g.drawImage(i9.getImage(), (getWidth()/2)-100, (getHeight()/2)-100, 200, 200, null);break;
			case 10:g.drawImage(i10.getImage(), (getWidth()/2)-100, (getHeight()/2)-100, 200, 200, null);break;
			}
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(cont==10)
				cont=1;
			else
				cont++;
			
			repaint();
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScreenPanel painel=new ScreenPanel();
		
		JFrame frame=new JFrame("Animatuin GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(550, 550);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().add(painel);
		frame.setVisible(true);
		
	}

}
