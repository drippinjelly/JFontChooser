import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class JFontChooser {
    
    private JFrame parent;
    private JButton button;
    private JLabel jlab;
    private JLabel jlab2;
    private JLabel jlab3;
    private JLabel jlab4;
    private Font font;
    private Color color;
    private JList jlst;
    private JList jlst2;
    private JList jlst3;
    private JScrollPane jscrlp;
    private JScrollPane jscrlp2;
    private JScrollPane jscrlp3;
    private String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    private String selectedFont;
    private int selectedStyle;
    private int selectedSize;
    private String[] sizes = {"8","9","10","11","12","14","16","18","20","22","24","26","28","36","48","72"};
    private String[] styles = {"PLAIN", "BOLD", "ITALIC"};
    
    public JFontChooser() {
        selectedFont = "Courier";
        selectedStyle = 0;
        selectedSize = 12;
    }
    
    public void setDefault(Font font) {
        this.font = font;
    }
    
    public boolean showDialog(JFrame parent) {
        
        JDialog dialog = new JDialog(parent);
        dialog.setSize(400,300);
        dialog.setLocationRelativeTo(parent);
        dialog.setVisible(true);
        
        parent = new JFrame("FontChooserDemo");
        parent.setLayout(new FlowLayout());
        parent.setSize(500,400);
        parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jlab = new JLabel("Font:", SwingConstants.LEFT);
        jlab2 = new JLabel("Font Style:", SwingConstants.CENTER);
        jlab3 = new JLabel("Size:", SwingConstants.RIGHT);
        jlab4 = new JLabel("Sample", SwingConstants.CENTER);
        jlst = new JList(fonts);
        jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jscrlp = new JScrollPane(jlst);
        jscrlp.setPreferredSize(new Dimension(50,50));
        jlst2 = new JList(styles);
        jlst2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jscrlp2 = new JScrollPane(jlst2);
        jscrlp2.setPreferredSize(new Dimension(50,50));
        jlst3 = new JList(sizes);
        jlst3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jscrlp3 = new JScrollPane(jlst3);
        jscrlp3.setPreferredSize(new Dimension(50,50));
        button = new JButton("ok");
        
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(1,3));
        p1.setPreferredSize(new Dimension(300, 25));
        p1.setOpaque(true);
        p1.add(jlab);
        p1.add(jlab2);
        p1.add(jlab3);
        
        
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(1,3));
        p2.setPreferredSize(new Dimension(400, 250));
        p2.setOpaque(true);
        p2.add(jscrlp);
        p2.add(jscrlp2);
        p2.add(jscrlp3);
        
        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(1,2));
        p3.setPreferredSize(new Dimension(400, 70));
        p3.setOpaque(true);
        p3.add(jlab4);
        p3.add(button);
        
        //JPanel main = new JPanel();
        //main.add(p1);
        //main.add(p2);
        //main.add(p3);
        
        parent.add(p1);
        parent.add(p2);
        parent.add(p3);
        //parent.add(main);
        
        //button.addActionListener(this);
        
        parent.setVisible(true);
        parent.setLocationRelativeTo(null);
        
        return true;
        
    }
    
    public void getFont() {
        
        jlst.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent le) {
                int idx = jlst.getSelectedIndex();
                selectedFont = fonts[idx];
                font = new Font(selectedFont, selectedStyle, selectedSize);
                jlab4.setFont(font); 
            }
        });
    }
    
    public void getStyle() {
        jlst2.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent le) {
                int idx = jlst2.getSelectedIndex();
                selectedStyle = idx;
                font = new Font(selectedFont, selectedStyle, selectedSize);
                jlab4.setFont(font); 
            }
        });
    }
    
    public void getSize() {
        jlst3.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent le) {
                int idx = jlst3.getSelectedIndex();
                selectedSize = Integer.parseInt(sizes[idx]);
                font = new Font(selectedFont, selectedStyle, selectedSize);
                jlab4.setFont(font);
            }
        });
    }
    
    public Color getColor() {
        return color;
    }
    
}


