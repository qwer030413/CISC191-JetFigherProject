package defaultpackage;

 

import javax.swing.*;
import java.awt.*;  
import java.awt.event.*;




public class player implements Runnable ,KeyListener
{
    private double x,y; 
    private int id;
    private double Deg = 0;
    private double DegVel1;
    private double DegVel2;
    private double velX = 3;
    private double velY = 3;
    int index = 0;
    int key;
    boolean left ,right, D, A;



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

    
 
 public void goingTheSameWay()
    {
        x += velX * Math.cos(Math.toRadians(Deg));
        y += velY * Math.sin(Math.toRadians(Deg));

    }

    
    
    public void keyPressed(KeyEvent e) 
    {
        key = e.getKeyCode();
        if(key == KeyEvent.VK_LEFT) left = true;
        if(key == KeyEvent.VK_RIGHT) right = true;
        if(key == KeyEvent.VK_D) D = true;
        if(key == KeyEvent.VK_A) A = true;
        DegVel1 = 1;
        DegVel2 = 1;
        

        
        
        
    }
    

    
    public void keyReleased(KeyEvent e) 
    {
        key = e.getKeyCode();
        if(key == KeyEvent.VK_LEFT)
        {
            left = false;
            DegVel1 = 0;
        } 
        if(key == KeyEvent.VK_RIGHT) 
        {
            right = false;
            DegVel1 = 0;
        }
        if(key == KeyEvent.VK_D) 
        {
            D = false;
            DegVel2 = 0;
        }if(key == KeyEvent.VK_A) 
        {
            A = false;
            DegVel2= 0;
        }
        
    }
    @Override
    public void run() {  
        
        
        if(id == 1)
        {
            if(right)
            {
                Deg += DegVel1;
            }
            if(left)
            {
                Deg -= DegVel1;
            }
        }
        if(id == 2)
        {
            if(D)
            {
                Deg += DegVel2;
            }
            if(A)
            {
                Deg -= DegVel2;
            }
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {
        
    } 
}
    