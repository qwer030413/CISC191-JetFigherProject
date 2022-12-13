package defaultpackage;



import javax.swing.JFrame;

public class myFrame extends JFrame {
    static gameManager panel = new gameManager();
    myFrame()
    { 
        
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
