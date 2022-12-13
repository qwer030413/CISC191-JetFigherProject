package defaultpackage;




import javax.swing.*;

import java.awt.*;   
import java.awt.event.*;
import java.awt.Rectangle;
public class gameManager extends JPanel implements ActionListener
{
    Image image;
    Timer timer; 
    player p1 = new player(0,0,1);
    player p2 = new player(400,600,2);
    double d;
    int p1HP = 5;
    int p2HP = 5;
    int p1Dmg = 1;
    int p2Dmg = 1;
    int gap = 5;
    int hit= 0;
    JLabel label = new JLabel("Player 1 HP: " + p1HP + "     ||      Player 2 HP: " + p2HP,SwingConstants.CENTER);
    JLabel over = new JLabel("GAME OVER",SwingConstants.CENTER);
    JButton restart = new JButton("Play Again!");
    myFrame game;


    
      
    gameManager() 
    {

        this.setPreferredSize(new Dimension(600,600));
        this.setBackground(Color.BLACK);  
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
         p1.draw(g);
         p2.draw(g);
        Thread player1 = new Thread(p1);
        Thread player2 = new Thread(p2);
        player1.start();
        player2.start();
   
        checkCollision();

        if(p1HP == 0 || p2HP == 0)
        {
            gameOver();
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
                    label.setText("Player 1 HP: " + p1HP + "     ||      Player 2 HP: " + p2HP );
                }

            }
            for(int i = p1.getBullets().size() - 1; i >= 0; i--)
            {
                Rectangle Bullet = p1.getBullets().get(i).getBounds();
                if(player2.intersects(Bullet))
                {
                    p1.getBullets().remove(i);
                    p2HP -= p1Dmg;
                    label.setText("Player 1 HP: " + p1HP + "     ||      Player 2 HP: " + p2HP );

                }

            }
        
    }

    public void gameOver()
    {
        this.removeAll();
        
        
        over.setFont(new Font("Comic Sans MS", Font.BOLD, 54));
        over.setForeground(Color.WHITE);
        over.setLocation(780,450);
        restart.setSize(100, 50);
        restart.setLocation(895,550);
        this.add(over);
        this.add(restart);
        revalidate();
        repaint();
    }
    public void restart()
    {

    }

     
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == restart)
        {
            game = new myFrame();
            game.add(this);
        }
        repaint();
    } 


   
    
 
    
    
    

    
}


    
    

    

