import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerWindow extends JFrame {
    private static final int POS_X = 500;
    private static final int POS_Y = 550;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private final JButton btnStart = new JButton("Start Server");
    private final JButton btnStop = new JButton("Stop Server");
    private final JTextArea log = new JTextArea();
    private final JLabel statusLabel = new JLabel("Server is stopped");
    private boolean isServerWorking;




    ServerWindow() {
        isServerWorking = false;
        btnStop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isServerWorking = false;
                statusLabel.setText("Server is stopped");
                System.out.println("Server stopped " + isServerWorking + "\n");
            }
        });

        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isServerWorking = true;
                statusLabel.setText("Server is started");
                System.out.println("Server started " + isServerWorking + "\n");

            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setAlwaysOnTop(true);
        setLayout(new GridLayout(1,3));


        add(btnStart);
        add(btnStop);
        add(statusLabel);

        setVisible(true);

    }
    public boolean isServerWorking(){
        return isServerWorking;
    }
}
