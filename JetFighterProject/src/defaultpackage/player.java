package defaultpackage;

import javax.swing.*;
import java.awt.*;  
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Rectangle;
 


 

public class player implements Runnable ,KeyListener
{
    private double x,y; 
    private int id;
    private double Deg = 0;
    private double DegVel1;
    private double DegVel2;
    private double velX = 2;
    private double velY = 2;
    private double playerWidth = 100;
    private double playerHeight = 100;

    int index = 0;
    int key;
    int i = 0;
    boolean left ,right, D, A, G, shift ;
    ArrayList<Bullet> bullet;
    Bullet b;
    long lastAttack = 0;
    long cooldown = 500;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    






    JLabel label;
    Image plane;
    Image newImage;

    


    public player(double x, double y, int id)
    {
        this.x = x;
        this.y = y;
        this.id = id;
        bullet = new ArrayList<Bullet>();
        if(id == 1)
        {
            plane = new ImageIcon(this.getClass().getResource("/plane1.jpg")).getImage();
            newImage = plane.getScaledInstance((int)playerWidth, (int)playerHeight, Image.SCALE_DEFAULT);
        }
        if(id == 2)
        {
            plane = new ImageIcon(this.getClass().getResource("/plane2.jpg")).getImage();
            newImage = plane.getScaledInstance((int)playerWidth, (int)playerHeight, Image.SCALE_DEFAULT);
        }
        

    }   
    
    public double getMidX()
    {
        return (newImage.getWidth(label) / 2) + x;
    }
    public double getMidY()
    {
        return (newImage.getHeight(label) / 2) + y;
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
    public Image getImage()
    {
        return plane;
    }
    public Rectangle getBounds()
    {
        return new Rectangle((int)x,(int)y,(int)playerWidth,(int) playerHeight);
    }

    
   public void draw(Graphics g)
   {
    
    Graphics2D g2D = (Graphics2D) g;
    goingTheSameWay();
    g2D.rotate(Math.toRadians(Deg),(newImage.getWidth(label) / 2) + x ,(newImage.getHeight(label) / 2) + y);
    g2D.drawImage(newImage,(int)x,(int)y,null); 
    g2D.rotate(-Math.toRadians(Deg),(newImage.getWidth(label) / 2) + x ,(newImage.getHeight(label) / 2) + y);

 
    for(i = 0; i < bullet.size(); i++)
        {
            b = bullet.get(i);  
            b.goingTheSameWay();
            g2D.rotate(Math.toRadians(b.getDeg()),(newImage.getWidth(label) / 2) + b.getX() ,(newImage.getHeight(label) / 2) + b.getY());
            g2D.drawImage(b.getImage(), (int)((newImage.getWidth(label) / 2) + b.getX()),(int)((newImage.getHeight(label) / 2) + b.getY()),null);
            g2D.rotate(-Math.toRadians(b.getDeg()),(newImage.getWidth(label) / 2) + b.getX() ,(newImage.getHeight(label) / 2) + b.getY());
        }
   }

    
 
    public void goingTheSameWay()
    {
        x += velX * Math.cos(Math.toRadians(Deg));
        y += velY * Math.sin(Math.toRadians(Deg));

    }

   

    public void shoot()
    {
        bullet.add(new Bullet(x, y, Deg));
    }

    public ArrayList<Bullet> getBullets()
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
        DegVel1 = 2;
        DegVel2 = 2;
        

        
         
        
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
                
            }
            if(left)
            {
                Deg -= DegVel1; 
            }
            if(shift)
            {
                long time = System.currentTimeMillis();
                if(time > (lastAttack + cooldown))
                {
                    shoot();
                    lastAttack = time;
                    
                }
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
            if(G)
            {
                long time = System.currentTimeMillis();
                if(time > (lastAttack + cooldown))
                {
                    shoot();
                    lastAttack = time;
                    
                }
                
            }
        }
        //y = 900, x = 1800
        if(x <= 0) x = 0;
        if(x >= 1800) x = 1800;
        if(y <= 0) y = 0;
        if(y >= 900) y = 900;
    }


    @Override
    public void keyTyped(KeyEvent e) {
        
    } 
}
    