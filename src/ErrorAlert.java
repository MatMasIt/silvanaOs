import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class ErrorAlert extends JFrame implements KeyListener {
    private JLabel titleL, descriptionL;
    private JButton ok;

    private JFrame parent;

    public ErrorAlert(JFrame parent, String title, String description){
        this.parent = parent;
        setLayout(new BorderLayout());
        titleL = new JLabel(title);
        titleL.setFont(new Font("SansSerif", Font.BOLD, 40));
        titleL.setIcon(IconFontSwing.buildIcon(FontAwesome.EXCLAMATION_TRIANGLE, 40));
        descriptionL = new JLabel("<html>" + description.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
        descriptionL.setFont(new Font("SansSerif", Font.BOLD, 40));
        descriptionL.setIcon(IconFontSwing.buildIcon(FontAwesome.EXCLAMATION_TRIANGLE, 40));
        ok = new JButton("OK");
        ok.setFont(new Font("SansSerif", Font.BOLD, 40));
        ok.setIcon(IconFontSwing.buildIcon(FontAwesome.CHECK, 40));
        ok.setFocusable(false);
        add(titleL, BorderLayout.NORTH);
        add(descriptionL, BorderLayout.CENTER);
        add(ok, BorderLayout.SOUTH);
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

    @Override
    public void keyTyped(KeyEvent e) {
        dispose();
        parent.requestFocus();
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
