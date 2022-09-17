import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Credits extends FullScreenWindow implements KeyListener {
    private JLabel topBar, credits;
    private JButton back;

    public Credits(){
        topBar = new JLabel("Riconoscimenti");
        topBar.setFont(new Font("SansSerif", Font.BOLD, 40));
        topBar.setIcon(IconFontSwing.buildIcon(FontAwesome.INFO_CIRCLE, 40));
        topBar.setFocusable(false);
        credits = new JLabel("<html><div style='text-align: center;'>SilvanaOs 1.0<br /><p>&copy; 2022 Mattia Mascarello, Alen Paripovic</p></div></html>", JLabel.CENTER);
        credits.setFont(new Font("SansSerif", Font.BOLD, 40));
        back = new JButton("Al Menù principale");
        back.setFont(new Font("SansSerif", Font.BOLD, 40));
        back.setIcon(IconFontSwing.buildIcon(FontAwesome.ARROW_LEFT, 40));
        back.setFocusable(false);
        setLayout(new BorderLayout());
        add(topBar, BorderLayout.NORTH);
        add(credits, BorderLayout.CENTER);
        add(back, BorderLayout.SOUTH);
        addKeyListener(this);
        setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        dispose();
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
