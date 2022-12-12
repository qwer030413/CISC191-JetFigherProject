package defaultpackage;
import javax.swing.*;
import java.awt.*;  
public class Bullet {

    private double x;
    private double y;
    private double velX = 5;
    private double velY = 5;
    private double Deg =0;
    
    Image bullet = new ImageIcon(this.getClass().getResource("/bullet.jpg")).getImage();

    

    public Bullet(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g)
    {
        g.drawImage(bullet,(int) x, (int)y, null);
    }

    public void goingTheSameWay()
    {
        x += velX* Math.cos(Math.toRadians(Deg));
        y += velY * Math.sin(Math.toRadians(Deg));

    }


    
    public double getX()
    {
        return x;
    }
    public double getY()
    {
        return y;
    }
    public Image getImage()
    {
        return bullet;
    }
    public double getDeg()
    {
        return Deg;
    }
    public void setDeg(double d)
    {
        Deg = d;
    }
}
