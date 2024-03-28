
import java.awt.*;
import javax.swing.JPanel;

public class BlankPanel extends JPanel{
    public BlankPanel(int x, int y, Color cl){
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(cl);
    }
    public BlankPanel(Color cl){
        this.setBackground(cl);
    }
}
