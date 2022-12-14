package defaultpackage;





import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class myFrame extends JFrame implements ActionListener{
    JButton resetButton;
    gameManager gm;
    myFrame()
    { 
        gm = new gameManager();
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(gm);
        
        this.pack();
        this.setLocationRelativeTo(null);
        resetButton = new JButton();
        resetButton.setText("Play Again!");
        resetButton.setSize(100,50);
        resetButton.addActionListener(this);
        resetButton.setFocusable(false);
        gm.add(resetButton);
        
        
        this.setVisible(true);
    }
  
    public static void main(String[] args)
    { 
        new myFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == resetButton)
        {
            this.remove(gm);
            gm = new gameManager();
            this.add(gm);
            gm.setFocusable(true);
            gm.add(resetButton);
            
        }
    }
   

    
    
}

