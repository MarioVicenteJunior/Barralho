import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawingPanel extends JPanel implements ActionListener {
    private Rectangle figura, figura2, figura3;
    
    public DrawingPanel() {
        setPreferredSize(new Dimension(1000, 750));
        
        figura = new Rectangle(400, 300, 120, 240);
        figura2 = new Rectangle(200, 300, 120, 240);

        
        JButton botaoEsquerda = new JButton("Esquerda");
        JButton botaoDireita = new JButton("Direita");
        
        botaoEsquerda.addActionListener(this);
        botaoDireita.addActionListener(this);
        
        add(botaoEsquerda);
        add(botaoDireita);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(Color.RED);
        g2d.fill(figura);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Esquerda")) {
            Rectangle figuraEsquerda = new Rectangle(100, 300, 120, 240);
            figura2 = figuraEsquerda;
        } else if (e.getActionCommand().equals("Direita")) {
            Rectangle figuraDireita = new Rectangle(600, 300, 120, 240);
            figura3 = figuraDireita;
        }
        
        repaint();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Drawing Panel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            DrawingPanel panel = new DrawingPanel();
            frame.add(panel);
            
            frame.pack();
            frame.setVisible(true);
        });
    }
}