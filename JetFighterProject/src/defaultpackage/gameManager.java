package defaultpackage;





import javax.swing.*;

import java.awt.*;   
import java.awt.event.*;
import java.awt.Rectangle;
public class gameManager extends JPanel implements ActionListener
{
    private Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    private Timer timer; 
    private player p1;
    private player p2;
    private int p1HP = 5;
    private int p2HP = 5;
    private int p1Dmg = 1;
    private int p2Dmg = 1;
    JLabel label, background;
    myFrame game;
    Image space = new ImageIcon(this.getClass().getResource("/space.jpg")).getImage();
    Image newSpace = space.getScaledInstance((int)size.getWidth(), (int)size.getHeight(),Image.SCALE_DEFAULT);
    
      
    gameManager() 
    {
        p2 = new player(0,0,2);
        p1 = new player(1000,800,1);
        label = new JLabel("Player 2 HP: " + p2HP + "     ||      Player 1 HP: " + p1HP);
        
        this.setPreferredSize(new Dimension(600,600));
        // this.setBackground(Color.BLACK);  
        timer = new Timer(1 , this);
        timer.start();
        label.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        label.setForeground(Color.WHITE);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(label,BorderLayout.PAGE_START);
        addKeyListener(p1);
        addKeyListener(p2);
        setFocusable(true);
    }   
    public void paintComponent(Graphics g)
    {  
         super.paintComponent(g);
         Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(newSpace, 0, 0, null);
         p1.draw(g);
         p2.draw(g);
        Thread player1 = new Thread(p1);
        Thread player2 = new Thread(p2);
        player1.start();
        player2.start();
   
        checkCollision();
        if(p1HP <=0)
        {
            Winner(2);
        }
        else if(p2HP <=0)
        {
            Winner(1);
        }
    } 
     
    
    public void checkCollision()
    {
        Rectangle player1 = p1.getBounds();
        Rectangle player2 = p2.getBounds();
            for(int i = p2.getBullets().size() - 1; i >= 0; i--)
            {
                Rectangle Bullet = p2.getBullets().get(i).getBounds();
                if(player1.intersects(Bullet))
                {
                    p2.getBullets().remove(i);
                    p1HP -= p2Dmg;
                    label.setText("Player 2 HP: " + p2HP + "     ||      Player 1 HP: " + p1HP);
                }

            }
            for(int i = p1.getBullets().size() - 1; i >= 0; i--)
            {
                Rectangle Bullet = p1.getBullets().get(i).getBounds();
                if(player2.intersects(Bullet))
                {
                    p1.getBullets().remove(i);
                    p2HP -= p1Dmg;
                    label.setText("Player 2 HP: " + p2HP + "     ||      Player 1 HP: " + p1HP);

                }

            }
        
    }

    public void Winner(int winner)
    {
        label.setFont(new Font("Comic Sans MS", Font.BOLD, 54));
        label.setText("GAME OVER, PLAYER " + winner + " WINS" );
    }

    public JLabel getLabel()
    {
        return label;
    }
    
    public void restart()
    {

    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        repaint();
    } 


   
    
 
    
    
    

    
}


    
    

    

