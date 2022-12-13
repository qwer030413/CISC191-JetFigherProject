package defaultpackage;

 

 








import javax.swing.*;
import java.awt.*;   
import java.awt.event.*;
import java.awt.Rectangle;
public class gameManager extends JPanel implements ActionListener//, KeyListener
{
    Image image;
    Timer timer; 
    player p1 = new player(0,0,1);
    player p2 = new player(400,600,2);
    double d;

    int hit= 0;
    JLabel label = new JLabel("hits: " + hit);
    JLabel distance = new JLabel("distance: " + d);
      
    gameManager() 
    {

        this.setPreferredSize(new Dimension(600,600));
        this.setBackground(Color.BLACK);  
        timer = new Timer(1 , this);
        timer.start();
        label.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        label.setForeground(Color.WHITE);
        this.add(label);


        
        // if(p2.getBullets().get(0) != null){
        //     d = Math.sqrt(Math.pow(p2.getMidX() - p2.getBullets().get(0).getMidX() , 2) + Math.pow(p2.getMidY() - p2.getBullets().get(0).getMidY(), 2));
        // }
        // distance.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        // distance.setForeground(Color.WHITE);
        // this.add(distance);
        
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
   
        
            // checkCollision();
        
        
        
            
        
        
   
  

    } 
     
    
    public void checkCollision()
    {
        // Rectangle player1 = p1.getBounds();
        // Rectangle player2 = p2.getBounds();
        //     for(int i = p1.getBullets().size() - 1; i >= 0; i--)
        //     {
        //         Rectangle Bullet = p2.getBullets().get(i).getBounds();
        //         if(player1.intersects(Bullet))
        //         {
        //             // p2.getBullets().remove(i);
        //             hit++;
        //             label.setText("hits: " + hit);
        //         }

        //     }
        //     for(int i = p2.getBullets().size() - 1; i >= 0; i--)
        //     {
        //         Rectangle Bullet = p1.getBullets().get(i).getBounds();
        //         if(player2.intersects(Bullet))
        //         {
        //             // p1.getBullets().remove(i);
        //             hit++;
        //             label.setText("hits: " + hit);
        //         }

        //     }
        

 


        if(p1.getBullets().size() > 1){
            for(int i = p1.getBullets().size() - 1; i >= 0; i--)
            {
                if(Math.sqrt(Math.pow(p1.getMidX() - p2.getBullets().get(i).getMidX() , 2) + Math.pow(p1.getMidY() - p2.getBullets().get(i).getMidY(), 2)) < 100.0)
                {
                    // p2.getBullets().remove(i);
                    hit++;
                    label.setText("hits: " + hit);
                    
                }
            }
    }
        if(p2.getBullets().size() > 1){
            for(int i = p2.getBullets().size() - 1; i >= 0; i--)
            {
                if(Math.sqrt(Math.pow(p2.getMidX() - p1.getBullets().get(i).getMidX() , 2) + Math.pow(p2.getMidY() - p1.getBullets().get(i).getMidY(), 2)) < 100.0)
                {
                    // p1.getBullets().remove(i);
                    hit++;
                    label.setText("hits: " + hit);
                }
            }
        }
        
    }

     
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        // checkCollision();
        repaint();
    } 


   
    
 
    
    
    

    
}


    
    

    

