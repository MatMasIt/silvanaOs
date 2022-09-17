
import com.apptasticsoftware.rssreader.Item;
import com.apptasticsoftware.rssreader.RssReader;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.stream.Stream;

public class MainMenu extends FullScreenWindow implements KeyListener {
    private JLabel topClock;
    private JPanel centerPanel;

    private KeyPadKey lastKeyPadKey = null;

    private JButton calculator, weather, mail, calendar, word, encyclopedia, news, pinacoteca, cinema,  shutdown, music;
    private JButton riconoscimenti;
    private JPanel riconoscimentiSpace;


    public MainMenu() {
        IconFontSwing.register(FontAwesome.getIconFont());
        topClock = new JLabel();

        topClock.setFont(new Font("SansSerif", Font.BOLD, 40));
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(0,3)); // three columns fixedc
        mail = new JButton("Posta Elettronica");
        mail.setFont(new Font("SansSerif", Font.BOLD, 40));
        mail.setIcon(IconFontSwing.buildIcon(FontAwesome.ENVELOPE, 40));
        mail.setFocusable(false);
        weather = new JButton("Meteo");
        weather.setFont(new Font("SansSerif", Font.BOLD, 40));
        weather.setIcon(IconFontSwing.buildIcon(FontAwesome.CLOUD, 40));
        weather.setFocusable(false);
        word = new JButton("Quaderni");
        word.setFont(new Font("SansSerif", Font.BOLD, 40));
        word.setIcon(IconFontSwing.buildIcon(FontAwesome.PENCIL, 40));
        word.setFocusable(false);
        calendar = new JButton("Calendario");
        calendar.setFont(new Font("SansSerif", Font.BOLD, 40));
        calendar.setIcon(IconFontSwing.buildIcon(FontAwesome.CALENDAR, 40));
        calendar.setFocusable(false);
        encyclopedia = new JButton("Enciclopedia");
        encyclopedia.setFont(new Font("SansSerif", Font.BOLD, 40));
        encyclopedia.setIcon(IconFontSwing.buildIcon(FontAwesome.BOOK, 40));
        encyclopedia.setFocusable(false);
        news = new JButton("Notizie");
        news.setFont(new Font("SansSerif", Font.BOLD, 40));
        news.setIcon(IconFontSwing.buildIcon(FontAwesome.NEWSPAPER_O, 40));
        news.setFocusable(false);
        pinacoteca = new JButton("Pinacoteca");
        pinacoteca.setFont(new Font("SansSerif", Font.BOLD, 40));
        pinacoteca.setIcon(IconFontSwing.buildIcon(FontAwesome.PICTURE_O, 40));
        pinacoteca.setFocusable(false);


        cinema = new JButton("Cinema");
        cinema.setFont(new Font("SansSerif", Font.BOLD, 40));
        cinema.setIcon(IconFontSwing.buildIcon(FontAwesome.FILM, 40));
        cinema.setFocusable(false);

        calculator = new JButton("Calcolatrice");
        calculator.setFont(new Font("SansSerif", Font.BOLD, 40));
        calculator.setIcon(IconFontSwing.buildIcon(FontAwesome.CALCULATOR, 40));
        calculator.setFocusable(false);

        music = new JButton("Giradischi");
        music.setFont(new Font("SansSerif", Font.BOLD, 40));
        music.setIcon(IconFontSwing.buildIcon(FontAwesome.MUSIC, 40));
        music.setFocusable(false);

        shutdown = new JButton("Spegni");
        shutdown.setFont(new Font("SansSerif", Font.BOLD, 40));
        shutdown.setIcon(IconFontSwing.buildIcon(FontAwesome.POWER_OFF, 40));
        shutdown.setFocusable(false);

        centerPanel.add(mail);
        centerPanel.add(weather);
        centerPanel.add(word);
        centerPanel.add(calendar);
        centerPanel.add(encyclopedia);
        centerPanel.add(news);
        centerPanel.add(pinacoteca);
        centerPanel.add(cinema);
        centerPanel.add(calculator);
        centerPanel.add(music);
        centerPanel.add(shutdown);
        riconoscimentiSpace = new JPanel();
        riconoscimentiSpace.setLayout(new BorderLayout());
        JLabel credits = new JLabel("<html><div style='text-align: center;'>SilvanaOs 1.0<br />2022, Mattia Mascarello, Alen Paripovic</div></html>");
        credits.setFont(new Font("SansSerif", Font.BOLD, 40));
        riconoscimentiSpace.add(credits, BorderLayout.CENTER);
        riconoscimenti = new JButton("Apri Riconoscimenti (D)");
        riconoscimenti.setFont(new Font("SansSerif", Font.BOLD, 30));
        riconoscimenti.setIcon(IconFontSwing.buildIcon(FontAwesome.INFO_CIRCLE, 40));
        riconoscimenti.setFocusable(false);
        riconoscimentiSpace.add(riconoscimenti, BorderLayout.SOUTH);
        centerPanel.add(riconoscimentiSpace);


        Runnable r = new ClockTicker(topClock);
        new Thread(r).start();

        setLayout(new BorderLayout());
        add(topClock, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
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
        mail.setBackground(Color.WHITE);
        weather.setBackground(Color.WHITE);
        word.setBackground(Color.WHITE);
        calendar.setBackground(Color.WHITE);
        encyclopedia.setBackground(Color.WHITE);
        news.setBackground(Color.WHITE);
        pinacoteca.setBackground(Color.WHITE);
        cinema.setBackground(Color.WHITE);
        calculator.setBackground(Color.WHITE);
        music.setBackground(Color.WHITE);
        shutdown.setBackground(Color.WHITE);
        riconoscimenti.setBackground(Color.WHITE);
        KeyPadKey keyPadKey;
        if(e.getExtendedKeyCode() == 68) keyPadKey = KeyPadKey.CREDITS;
        else keyPadKey  = KeyPadConverter.fromKeyEvent(e);
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
            case SIX:
                try {
                    new News();
                } catch (IOException e) {
                    new ErrorAlert(this, "Errore", "Impossibile ottenere le notizie\nLa connessione INTERNET potrebbe essere assente");
                }
                break;
            case CREDITS:
                new Credits();
                break;
        }
    }
    private void setButton(KeyPadKey keyPadKey, Color color){
        switch (keyPadKey) {
            case SEVEN:
                mail.setBackground(color);
                break;
            case EIGHT:
                weather.setBackground(color);
                break;
            case NINE:
                word.setBackground(color);
                break;
            case FOUR:
                calendar.setBackground(color);
                break;
            case FIVE:
                encyclopedia.setBackground(color);
                break;
            case SIX:
                news.setBackground(color);
                break;
            case ONE:
                pinacoteca.setBackground(color);
                break;
            case TWO:
                cinema.setBackground(color);
                break;
            case THREE:
                calculator.setBackground(color);
                break;
            case ZERO:
                music.setBackground(color);
                break;
            case DOT:
                shutdown.setBackground(color);
                break;
            case CREDITS:
                riconoscimenti.setBackground(color);
                break;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
