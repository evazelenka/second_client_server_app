package Client;

import Server.ServerWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientGUI extends JFrame {
    private static final int POS_X = 500;
    private static final int POS_Y = 550;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private static JTextField sendField = new JTextField(100);
    private static JButton sendBtn = new JButton("send");
    public static JTextArea log = new JTextArea();


    public ClientGUI(ServerWindow serverWindow, String nameOfUser){
        setBackground(Color.WHITE);
        setBounds(POS_X+400, POS_Y, WIDTH, HEIGHT);
        setTitle("Chat Client");

        sendBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                log.append(nameOfUser + ": " + sendField.getText() + "\n");
                sendField.setText("");
            }
        });

        sendField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                log.append(nameOfUser + ": " + sendField.getText() + "\n");
                sendField.setText("");
            }
        });


        setVisible(true);
    }
}
