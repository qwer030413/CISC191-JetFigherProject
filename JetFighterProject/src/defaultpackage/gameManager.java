package defaultpackage;

 

 
import javax.swing.*;
import java.awt.*;   
import java.awt.event.*; 
 
public class gameManager extends JPanel implements ActionListener
{

    Image image;
    Timer timer; 
    player p1 = new player(0,0,1);
    player p2 = new player(400,600,2);
    JLabel label;
      
    gameManager() 
    {

        this.setPreferredSize(new Dimension(600,600));
        this.setBackground(Color.BLACK);  
        // image = new ImageIcon("plane.jpg").getImage();
        timer = new Timer(1 , this);
        timer.start();
        addKeyListener(p1);
        addKeyListener(p2);
        setFocusable(true);
         
  


    }   

    // gameManager(player player)
    // {
    //     this.player.setX(player.getx());
    //     this.player.setY(player.gety());
    //     this.player.setID(player.getID());
    // }
 
    public void paint(Graphics g)
    {  
   
        super.paint(g);
         p1.draw(g);
         p2.draw(g);
//        Thread a = new Thread(p1);
//        a.start();
   
 
 

    } 

 
    public void paintComponent(Graphics g)
    {  
   
        
    	super.paintComponent(g);
        
    	p1.draw(g);
    	p2.draw(g);

   
 
 

    } 
    


    
 
    // public void goingTheSameWay()
    // {
    //     p.setX(p.getX() + p.getVelX() * Math.cos(Math.toRadians(p.getDeg())));
    //     p.setY(p.getY() + p.getVelY() * Math.sin(Math.toRadians(p.getDeg())));

    // }
     
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
       
        repaint();
    }

    

    
    
}



    
    

    

