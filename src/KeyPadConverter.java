import java.awt.event.KeyEvent;

public class KeyPadConverter {
    public static KeyPadKey fromKeyEvent(KeyEvent e){
        if(e.getKeyLocation() != 4) throw new IllegalStateException("Not in keypad");
        return switch (e.getExtendedKeyCode()) {
            case 103, 36 -> KeyPadKey.SEVEN;
            case 224, 104 -> KeyPadKey.EIGHT;
            case 105, 33 -> KeyPadKey.NINE;
            case 100, 226 -> KeyPadKey.FOUR;
            case 65368, 101 -> KeyPadKey.FIVE;
            case 227, 102 -> KeyPadKey.SIX;
            case 35, 97 -> KeyPadKey.ONE;
            case 98, 225 -> KeyPadKey.TWO;
            case 144, 34 -> KeyPadKey.THREE;
            case 111 -> KeyPadKey.DIVIDE;
            case 106 -> KeyPadKey.TIMES;
            case 109 -> KeyPadKey.MINUS;
            case 107  -> KeyPadKey.PLUS;
            case 10 -> KeyPadKey.ENTER;
            case 127 -> KeyPadKey.DOT;
            default -> throw new IllegalStateException("Unexpected value: " + e.getExtendedKeyCode());
        };
    }
}
