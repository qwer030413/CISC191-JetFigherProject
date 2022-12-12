package defaultpackage;

 


import javax.swing.*;
import java.awt.*;  
import java.awt.event.*;
import java.util.ArrayList;




public class player implements Runnable ,KeyListener
{
    private double x,y; 
    private int id;
    private double Deg = 0;
    private double DegVel1;
    private double DegVel2;
    private double velX = 2;
    private double velY = 2;
    int index = 0;
    int key;
    int i = 0;
    boolean left ,right, D, A, G, shift ;
    static ArrayList<Bullet> bullet;



    JLabel label;
    Image plane = new ImageIcon(this.getClass().getResource("/plane.jpg")).getImage();

    


    public player(double x, double y, int id)
    {
        this.x = x;
        this.y = y;
        this.id = id;
        bullet = new ArrayList<Bullet>();

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
    g2D.rotate(Math.toRadians(Deg),(plane.getWidth(label) / 2) + x ,(plane.getHeight(label) / 2) + y);
    g2D.drawImage(plane,(int)x,(int)y,null); 
    g2D.rotate(-Math.toRadians(Deg),(plane.getWidth(label) / 2) + x ,(plane.getHeight(label) / 2) + y);

    for(i = 0; i < bullet.size(); i++)
        {
            Bullet b = bullet.get(i);  
            b.goingTheSameWay();
            g2D.rotate(Math.toRadians(b.getDeg()),(b.getImage().getWidth(label) / 2) + b.getX() ,(b.getImage().getHeight(label) / 2) + b.getY());
            g2D.drawImage(b.getImage(), (int)((plane.getWidth(label) / 2) + b.getX()),(int)((plane.getHeight(label) / 2) + b.getY()),null);
            g2D.rotate(Math.toRadians(b.getDeg()),(b.getImage().getWidth(label) / 2) + b.getX() ,(b.getImage().getHeight(label) / 2) + b.getY());
        }
   }

    
 
    public void goingTheSameWay()
    {
        x += velX * Math.cos(Math.toRadians(Deg));
        y += velY * Math.sin(Math.toRadians(Deg));

    }

    public void shoot()
    {
        bullet.add(new Bullet(x, y));
    }

    public static ArrayList<Bullet> getBullets()
    {
        return bullet;
    }    
    public void keyPressed(KeyEvent e) 
    {
        key = e.getKeyCode();
        if(key == KeyEvent.VK_LEFT) left = true;
        if(key == KeyEvent.VK_RIGHT) right = true;
        if(key == KeyEvent.VK_D) D = true;
        if(key == KeyEvent.VK_A) A = true;
        if(key == KeyEvent.VK_G) G = true;
        if(key == KeyEvent.VK_SHIFT) shift = true;
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
        }
        if(key == KeyEvent.VK_A) 
        {
            A = false;
            DegVel2= 0;
        }
        if(key == KeyEvent.VK_G) 
        {
            G = false;
           
        }
        if(key == KeyEvent.VK_SHIFT) 
        {
            shift = false;
         
        }

        
    }
    @Override
    public void run() {  
        
        
        if(id == 1)
        {
            if(right)
            {
                Deg += DegVel1;
                bullet.get(i).setDeg(Deg);
                
            }
            if(left)
            {
                Deg -= DegVel1;
                bullet.get(i).setDeg(Deg);
            }
            if(shift)
            {
                shoot();
            }
        }
        if(id == 2)
        {
            if(D)
            {
                Deg += DegVel2;
                bullet.get(i).setDeg(Deg);
            }
            if(A)
            {
                Deg -= DegVel2;
                bullet.get(i).setDeg(Deg);
            }
            if(G)
            {
                shoot();
            }
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {
        
    } 
}
    