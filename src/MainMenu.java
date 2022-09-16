
import com.apptasticsoftware.rssreader.Item;
import com.apptasticsoftware.rssreader.RssReader;
import com.formdev.flatlaf.FlatLightLaf;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.stream.Stream;

public class MainMenu extends JFrame implements KeyListener {
    private JLabel topClock;
    private JPanel centerPanel;

    private KeyPadKey lastKeyPadKey = null;

    private JButton clock, weather, mail, calendar, word, encyclopedia, news, shutdown;
    public MainMenu() {
        IconFontSwing.register(FontAwesome.getIconFont());
        topClock = new JLabel();

        topClock.setFont(new Font("SansSerif", Font.BOLD, 40));
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3,3));
        clock = new JButton("Promemoria");
        clock.setFont(new Font("SansSerif", Font.BOLD, 40));
        clock.setIcon(IconFontSwing.buildIcon(FontAwesome.CLOCK_O, 40));
        clock.setFocusable(false);
        weather = new JButton("Meteo");
        weather.setFont(new Font("SansSerif", Font.BOLD, 40));
        weather.setIcon(IconFontSwing.buildIcon(FontAwesome.CLOUD, 40));
        weather.setFocusable(false);
        mail = new JButton("Posta Elettronica");
        mail.setFont(new Font("SansSerif", Font.BOLD, 40));
        mail.setIcon(IconFontSwing.buildIcon(FontAwesome.ENVELOPE, 40));
        mail.setFocusable(false);
        calendar = new JButton("Calendario");
        calendar.setFont(new Font("SansSerif", Font.BOLD, 40));
        calendar.setIcon(IconFontSwing.buildIcon(FontAwesome.CALENDAR, 40));
        calendar.setFocusable(false);
        word = new JButton("Quaderni");
        word.setFont(new Font("SansSerif", Font.BOLD, 40));
        word.setIcon(IconFontSwing.buildIcon(FontAwesome.PENCIL, 40));
        word.setFocusable(false);
        encyclopedia = new JButton("Enciclopedia");
        encyclopedia.setFont(new Font("SansSerif", Font.BOLD, 40));
        encyclopedia.setIcon(IconFontSwing.buildIcon(FontAwesome.BOOK, 40));
        encyclopedia.setFocusable(false);
        news = new JButton("Notizie");
        news.setFont(new Font("SansSerif", Font.BOLD, 40));
        news.setIcon(IconFontSwing.buildIcon(FontAwesome.NEWSPAPER_O, 40));
        news.setFocusable(false);
        shutdown = new JButton("Spegni");
        shutdown.setFont(new Font("SansSerif", Font.BOLD, 40));
        shutdown.setIcon(IconFontSwing.buildIcon(FontAwesome.POWER_OFF, 40));
        shutdown.setFocusable(false);
        centerPanel.add(clock);
        centerPanel.add(weather);
        centerPanel.add(mail);
        centerPanel.add(calendar);
        centerPanel.add(word);
        centerPanel.add(encyclopedia);
        centerPanel.add(news);
        centerPanel.add(shutdown);


        Runnable r = new ClockTicker(topClock);
        new Thread(r).start();

        setLayout(new BorderLayout());
        add(topClock, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addKeyListener(this);
        GraphicsEnvironment graphics =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();
        device.setFullScreenWindow(this);
    }
    public static void main(String[] args) throws IOException {
        FlatLightLaf.setup();
        MainMenu mainMenu = new MainMenu();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        clock.setBackground(Color.WHITE);
        weather.setBackground(Color.WHITE);
        mail.setBackground(Color.WHITE);
        calendar.setBackground(Color.WHITE);
        word.setBackground(Color.WHITE);
        encyclopedia.setBackground(Color.WHITE);
        news.setBackground(Color.WHITE);
        shutdown.setBackground(Color.WHITE);
        KeyPadKey keyPadKey = KeyPadConverter.fromKeyEvent(e);
        if(keyPadKey!= KeyPadKey.ENTER) lastKeyPadKey = keyPadKey;
        if(keyPadKey == KeyPadKey.ENTER){
            setButton(lastKeyPadKey, Color.GREEN);
            open(lastKeyPadKey);
        }
       else{
           setButton(keyPadKey, Color.YELLOW);
        }

    }

    private void open(KeyPadKey keyPadKey){
        switch (keyPadKey){
            case ONE:
                try {
                    new News();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }
    private void setButton(KeyPadKey keyPadKey, Color color){
        switch (keyPadKey) {
            case SEVEN:
                clock.setBackground(color);
                break;
            case EIGHT:
                weather.setBackground(color);
                break;
            case NINE:
                mail.setBackground(color);
                break;
            case FOUR:
                calendar.setBackground(color);
                break;
            case FIVE:
                word.setBackground(color);
                break;
            case SIX:
                encyclopedia.setBackground(color);
                break;
            case ONE:
                news.setBackground(color);
                break;
            case TWO:
                shutdown.setBackground(color);
                break;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
