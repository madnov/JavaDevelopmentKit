import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ClientGUI extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    private static final String LOG_FILE_PATH = "HomeWork1/src/main/java/chat_log.txt";

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

    private static List<ClientGUI> clients = new ArrayList<ClientGUI>();
    private boolean loggedIn = false;
    ServerWindow serverWindow = new ServerWindow();


    ClientGUI() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        setTitle("Chat Client");

        btnSend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (serverWindow.isServerWorking()) {
                    String message = tfMessage.getText();
                    log.append("You: " + message + "\n");
                } else {
                    log.append("Server is not running. Cannot send message.\n");
                }
            }
        });

        tfMessage.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessage();
                }
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loggedIn = true;
                log.append("Successfully logged in\n");
                tfIPAddress.setVisible(false);
                tfLogin.setVisible(false);
                tfPort.setVisible(false);
                tfPassword.setVisible(false);
                btnLogin.setVisible(false);


                log.setVisible(true);
                tfMessage.setVisible(true);
                btnSend.setVisible(true);

            }
        });

        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);

        add(panelTop, BorderLayout.NORTH);

        panelBottom.add(tfMessage, BorderLayout.CENTER);
        panelBottom.add(btnSend, BorderLayout.EAST);

        add(panelBottom, BorderLayout.SOUTH);

        log.setEditable(false);
        JScrollPane scrollLog = new JScrollPane(log);
        add(scrollLog, BorderLayout.CENTER);

        loadChatHistory();

        setVisible(true);
        clients.add(this);
    }


    private void sendMessage() {
        if (!loggedIn) {
            log.append("Please login first\n");
            return;
        }
        String message = tfMessage.getText();

        for (ClientGUI client : clients) {
            client.log.append("You: " + message + "\n");
        }

        writeMessageToFile(message);

        tfMessage.setText("");

    }

    private void loadChatHistory() {
        try (BufferedReader reader = new BufferedReader(new FileReader(LOG_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                log.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeMessageToFile(String message) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE_PATH, true))) {
            writer.println("You: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

