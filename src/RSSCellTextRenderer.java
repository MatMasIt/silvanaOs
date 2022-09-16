import com.apptasticsoftware.rssreader.Item;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class RSSCellTextRenderer extends DefaultListCellRenderer {
    public static final String HTML_1 = "<html><body style='width: ";
    public static final String HTML_2 = "px'>";
    public static final String HTML_3 = "</html>";
    private int width;

    private DateFormat format;

    public  RSSCellTextRenderer(int width){
        this.width = width;
        format  = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");;
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
            if(i.getTitle().isPresent()){
                String add ="";
                System.out.println(i.getPubDate().get());
                if(i.getPubDate().isPresent()) add =" ["+i.getPubDate().get()+"] ";// save
                String text = HTML_1 + width + HTML_2 +add+i.getTitle().get()
                        + HTML_3;
                rend.setText(text);
            }
        }
        return renderer;
    }
}
