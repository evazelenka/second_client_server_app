package Client;

import Server.Server;
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
    private  JTextField sendField = new JTextField(100);
    private  JButton sendBtn = new JButton("send");
    public JTextArea log = new JTextArea();
    private  final String LOGIN_SUCCESS = "loged in successfully\n";
    private static StringBuilder chat = new StringBuilder();



    public ClientGUI(ServerWindow serverWindow){
        setBackground(Color.WHITE);
        setBounds(POS_X+400, POS_Y, WIDTH, HEIGHT);
        setTitle("Chat Client");
        log.append(LOGIN_SUCCESS);
//        serverWindow.update(nameOfUser);
        LogInWindow logInWindow = new LogInWindow(serverWindow);
//        serverWindow.getLog().append(logInWindow.getNickName() + " connected to the server\n");
        setVisible(true);



        sendBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Server.writeInChat(logInWindow.getNickName().getText() + ": " + sendField.getText());
                log.setText(chat.toString());
                sendField.setText("");
            }
        });

        sendField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              Server.writeInChat(logInWindow.getNickName().getText() + ": " + sendField.getText());
                log.setText(Server.readInChat().toString());
                sendField.setText("");
            }
        });


        updateChat();
        log.setText(chat.toString());

        JScrollPane scrollLog = new JScrollPane(log);
        add(scrollLog);
        JPanel sendPanel = new JPanel(new GridLayout(1, 2));
        sendPanel.add(sendField);
        sendPanel.add(sendBtn);

        add(log);
        add(sendPanel, BorderLayout.SOUTH);
    }

    public void serverStopped(){
        if(this.isVisible()){
            this.setVisible(false);
        }
    }

    public static StringBuilder updateChat(){
        System.out.println(Server.isUpdated);
       if(Server.isUpdated){
            System.out.println("update");
            chat = Server.readInChat();
        }
        return chat;
    }

}
