package defaultpackage;

 
import javax.swing.*;
import java.awt.*;  
import java.awt.event.*; 



public class player implements KeyListener, Runnable{
    private double x,y; 
    private int id;
    private double Deg = 0;
    private double DegVel = 3;
    private double velX = 2;
    private double velY = 2;
    JLabel label;
    Image image = new ImageIcon(this.getClass().getResource("/plane.jpg")).getImage();
    


    public player(double x, double y, int id)
    {
        this.x = x;
        this.y = y;
        this.id = id;

    }   
    
    
    public void setX(double x)
    {
        this.x = x; 
    }
    public void setY(double y)
    {
        this.y = y;
    }
    public void setID(int id)
    {
        this.id = id;
    }

    public double getX() 
    {  
        return x;
    }
    public double getY()
    {
        return y;
    }
    public int getID()
    {
        return id;
    }
    public double getDeg()
    {
        return Deg;
    }
    public double getVelY()
    {
        return velY;
    } 
    public double getVelX()
    {
        return velX;
    }
   

   public void draw(Graphics g)
   {
    
    Graphics2D g2D = (Graphics2D) g;
    goingTheSameWay();
    g2D.rotate(Math.toRadians(Deg),(image.getWidth(label) / 2) + x ,(image.getHeight(label) / 2) + y);
    g2D.drawImage(image,(int)x,(int)y,null); 
    g2D.rotate(-Math.toRadians(Deg),(image.getWidth(label) / 2) + x ,(image.getHeight(label) / 2) + y);

   }

    @Override
    public void run() {  

        
        
        // draw(gameManager.g);
        // Graphics2D g2D = (Graphics2D) g;
        // goingTheSameWay();
        // g2D.rotate(Math.toRadians(Deg),(image.getWidth(label) / 2) + x ,(image.getHeight(label) / 2) + y);
        // g2D.drawImage(image,(int)x,(int)y,null); 
        // try{
        //     while(true) 
        //     {
        //         goingTheSameWay();
                
        //         Thread.sleep(7);
        //     }
             
        // } 
        // catch(Exception e) {
        //     System.err.println(e.getMessage());
        // }
    }
 
 public void goingTheSameWay()
    {
        x += velX * Math.cos(Math.toRadians(Deg));
        y += velY * Math.sin(Math.toRadians(Deg));

    }


    @Override
    public void keyPressed(KeyEvent e) 
    {
        int key = e.getKeyCode();  
        
      
        if(id == 1)
        {
            if(key == KeyEvent.VK_RIGHT)
            {
                Deg += DegVel;             
           
 
            }
            if(key == KeyEvent.VK_LEFT)
            {
                Deg -= DegVel;

            
            }

        }
        

        else if(id == 2)
        {

            if(key == KeyEvent.VK_D)
            {
                Deg += DegVel;
            
           
 
            }
            if(key == KeyEvent.VK_A)
            {
                Deg -= DegVel;
            
            }
        }
        
        
    }

    
    @Override
    public void keyReleased(KeyEvent e) 
    {
        
    }
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    
}

    

