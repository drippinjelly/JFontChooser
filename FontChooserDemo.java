
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Font;

public class FontChooserDemo{
   
    private JFrame parent;
    private Font font = new Font("Courier", Font.PLAIN, 12);
    
    public FontChooserDemo() {
        
        JFontChooser jfontc = new JFontChooser(); 
        jfontc.setDefault(font);
        if (jfontc.showDialog(parent)) {
            jfontc.getFont();
            jfontc.getStyle();
            jfontc.getSize();
        }
        
    }
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FontChooserDemo();
            }
        });
    }
}
