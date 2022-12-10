package defaultpackage;
import javax.swing.JFrame;

public class myFrame extends JFrame {
    gameManager panel;
    myFrame()
    {  
        panel = new gameManager();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
             
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
 
    public static void main(String[] args)
    { 
       new myFrame();
       
        


 
        
    }

}