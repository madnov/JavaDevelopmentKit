import javax.swing.*;
import java.awt.*;

public class ClientGUI extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    private final JTextArea log = new JTextArea();

    private final JPanel panelTop = new JPanel(new GridLayout(2, 3));
    private final JTextField tfIPAddress = new JTextField("127.0.0.1");
    private final JTextField tfPort = new JTextField("81.89");
    private final JTextField tfLogin = new JTextField("maks_novosyolov");
    private final JPasswordField tfPassword = new JPasswordField("123456");
    private final JButton btnLogin = new JButton("Login");

    private final JPanel panelBottom = new JPanel(new BorderLayout());
    private final JTextField tfMessage = new JTextField();
    private final JButton btnSend = new JButton("Send");

    ClientGUI() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        setTitle("Chat Client");

        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);

        panelBottom.add(tfMessage,BorderLayout.CENTER);
        panelBottom.add(btnSend,BorderLayout.EAST);
        add(panelBottom, BorderLayout.SOUTH);

        log.setEditable(false);
        JScrollPane scrollLog = new JScrollPane(log);
        add(scrollLog);

        setVisible(true);
    }
}
