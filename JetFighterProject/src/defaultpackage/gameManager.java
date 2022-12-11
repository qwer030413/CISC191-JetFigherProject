package defaultpackage;

 

 




import javax.swing.*;
import java.awt.*;   
import java.awt.event.*; 
 
public class gameManager extends JPanel implements ActionListener//, KeyListener
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
        timer = new Timer(1 , this);
        timer.start();
        
      
        addKeyListener(p1);
        addKeyListener(p2);
        setFocusable(true);
          
         
      

  
    }   
      
 
    public void paintComponent(Graphics g)
    {  
   
         super.paintComponent(g);
         p1.draw(g);
         p2.draw(g);
        Thread a = new Thread(p1);
        Thread b = new Thread(p2);
        a.start();
        b.start();
   
   
  

    } 
     

     
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
       
        repaint();
    } 


   
    
 
    
    
    

    
}


    
    

    


