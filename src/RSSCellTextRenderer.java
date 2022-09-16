import com.apptasticsoftware.rssreader.Item;

import javax.swing.*;
import java.awt.*;

public class RSSCellTextRenderer extends DefaultListCellRenderer {
    public static final String HTML_1 = "<html><body style='width: ";
    public static final String HTML_2 = "px'>";
    public static final String HTML_3 = "</html>";
    private int width;

    public  RSSCellTextRenderer(int width){
        this.width = width;
    }
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (renderer instanceof JLabel && value instanceof Item) {
            // Here value will be of the Type 'CD'
            Item i = (Item) value;
            JLabel rend = ((JLabel) renderer);
                    /*Dimension d = new Dimension();
                    d.setSize(Toolkit.getDefaultToolkit().getScreenSize().getWidth()-20, 20);
                    rend.setMaximumSize(d);*/
            if(!i.getTitle().isEmpty()){
                String text = HTML_1 + String.valueOf(width) + HTML_2 +i.getTitle().get()
                        + HTML_3;
                rend.setText(text);
            }
        }
        return renderer;
    }
}
