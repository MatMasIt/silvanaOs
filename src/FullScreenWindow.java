import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class FullScreenWindow extends JFrame implements WindowFocusListener {
    public FullScreenWindow(){
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
        addWindowFocusListener(this);
    }


    @Override
    public void windowGainedFocus(WindowEvent e) {
        GraphicsEnvironment graphics =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();
        device.setFullScreenWindow(this);
    }

    @Override
    public void windowLostFocus(WindowEvent e) {

    }
}
