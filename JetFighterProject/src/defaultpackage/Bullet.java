package defaultpackage;
import javax.swing.*;
import java.awt.*;  
import java.awt.Rectangle;

public class Bullet{
 
    private double x;
    private double y;
    private double velX = 5;
    private double velY = 5;
    private double Deg =0;
    private double bulletWidth = 80;
    private double bulletHeight = 48;
    
    Image bullet = new ImageIcon(this.getClass().getResource("/Bullet.png")).getImage();
  


    Image newImage =bullet.getScaledInstance((int) bulletWidth, (int)bulletHeight, Image.SCALE_DEFAULT);
    
    JLabel label;
    public Bullet(double x, double y, double Deg)
    {
        this.x = x;
        this.y = y;
        this.Deg = Deg;
    }

    public void draw(Graphics g)
    {
        g.drawImage(newImage,(int) x, (int)y, null);
    }

    public void goingTheSameWay()
    {
        x += velX * Math.cos(Math.toRadians(Deg));
        y += velY * Math.sin(Math.toRadians(Deg));

    }
    public double getMidX()
    {
        return (newImage.getWidth(label) / 2) + x;
    }
    public double getMidY()
    {
        return (newImage.getHeight(label) / 2) + y;
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
        return newImage;  
    }
    public double getDeg()
    {
        return Deg;
    }
    public Rectangle getBounds()
    {
        return new Rectangle((int)x,(int)y,(int)bulletWidth,(int) bulletHeight);
    }
    
}
