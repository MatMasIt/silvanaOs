
import com.apptasticsoftware.rssreader.Item;
import com.apptasticsoftware.rssreader.RssReader;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class News extends FullScreenWindow implements KeyListener {
    private JLabel topBar;
    private JPanel centerPanel, actionPanel;

    private KeyPadKey lastKeyPadKey = null;

    private JList<Item> articles;

    private JScrollPane scroll;

    private JButton back, up, down, open;


    public News() throws IOException {
        topBar = new JLabel("Notizie");
        topBar.setIcon(IconFontSwing.buildIcon(FontAwesome.NEWSPAPER_O, 40));
        topBar.setFont(new Font("SansSerif", Font.BOLD, 40));
        centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        RssReader reader = new RssReader();
        DefaultListModel<Item> demoList = new DefaultListModel<>();
        reader.read("https://www.ansa.it/sito/ansait_rss.xml").forEach(demoList::addElement);

        articles = new JList<>(demoList);

        articles.setCellRenderer(new RSSCellTextRenderer((int) (1500)));


        articles.setFont(new Font("SansSerif", Font.BOLD, 40));
        articles.setSelectionBackground(Color.YELLOW);
        articles.setSelectionForeground(Color.BLACK);
        scroll = new JScrollPane(articles,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


        back = new JButton("Al Menù principale");
        back.setFont(new Font("SansSerif", Font.BOLD, 30));
        back.setIcon(IconFontSwing.buildIcon(FontAwesome.ARROW_LEFT, 40));
        back.setFocusable(false);

        up = new JButton("Notizia Precedente");
        up.setFont(new Font("SansSerif", Font.BOLD, 30));
        up.setIcon(IconFontSwing.buildIcon(FontAwesome.ARROW_UP, 40));
        up.setFocusable(false);

        down = new JButton("Notizia Successiva");
        down.setFont(new Font("SansSerif", Font.BOLD, 30));
        down.setIcon(IconFontSwing.buildIcon(FontAwesome.ARROW_DOWN, 40));
        down.setFocusable(false);

        open = new JButton("Vedi Notizia");
        open.setFont(new Font("SansSerif", Font.BOLD, 30));
        open.setIcon(IconFontSwing.buildIcon(FontAwesome.EYE, 40));
        open.setFocusable(false);

        actionPanel = new JPanel();
        actionPanel.setLayout(new GridLayout(0,3)); // three columns fixed

        actionPanel.add(back);
        actionPanel.add(up);
        actionPanel.add(down);
        actionPanel.add(open);

        centerPanel.add(actionPanel, BorderLayout.NORTH);
        centerPanel.add(scroll, BorderLayout.CENTER);
        setLayout(new BorderLayout());
        add(topBar, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        addKeyListener(this);
        articles.addKeyListener(this);
        articles.setSelectedIndex(0);
        GraphicsEnvironment graphics =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();
        device.setFullScreenWindow(this);
        
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        KeyPadKey keyPadKey = KeyPadConverter.fromKeyEvent(e);
        if(keyPadKey!= KeyPadKey.ENTER) lastKeyPadKey = keyPadKey;
        if(lastKeyPadKey != null && keyPadKey == KeyPadKey.ENTER){
            setButton(lastKeyPadKey, Color.GREEN);
            switch (lastKeyPadKey){
                case SEVEN:
                    dispose();
                    break;
                case EIGHT:
                    if(articles.getSelectedIndex() != 0){
                        articles.setSelectedIndex(articles.getSelectedIndex()-1);
                        articles.ensureIndexIsVisible(articles.getSelectedIndex()-1);
                    }
                    break;
                case NINE:
                    if(articles.getSelectedIndex() != articles.getModel().getSize()) {
                        articles.setSelectedIndex(articles.getSelectedIndex() + 1);
                        articles.ensureIndexIsVisible(articles.getSelectedIndex()+1);
                    }
                    break;
            }
        }
        else{
            setButton(keyPadKey, Color.YELLOW);
        }
    }

    private void setButton(KeyPadKey keyPadKey, Color color){
        back.setBackground(Color.WHITE);
        up.setBackground(Color.WHITE);
        down.setBackground(Color.WHITE);
        open.setBackground(Color.WHITE);
        switch (keyPadKey){
            case SEVEN:
                back.setBackground(color);
                break;
            case EIGHT:
                up.setBackground(color);
                break;
            case NINE:
                down.setBackground(color);
                break;
            case FOUR:
                open.setBackground(color);
                break;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
