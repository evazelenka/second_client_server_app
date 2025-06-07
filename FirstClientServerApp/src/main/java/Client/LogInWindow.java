package Client;

import DB.ClientDataBase;
import Server.ServerWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInWindow extends JFrame {
    private static final int POS_X = 500;
    private static final int POS_Y = 550;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private  final String LOGIN_SUCCESS = "loged in successfully\n";
    private final String SERVER_IS_DOWN = "server is not running\ntry again later\n";
    private final JTextField server = new JTextField(20);
    private JTextField port = new JTextField(20);
    private  JTextField nickName = new JTextField(20);
    private  JPasswordField passwd = new JPasswordField(20);
    private  JButton logInBtn = new JButton("login");
    private  JTextField sendField = new JTextField(100);
    private  JButton sendBtn = new JButton("send");
    public  JTextArea log = new JTextArea();
    private  JPanel loginPanel;
    private  JPanel sendPanel;


    public LogInWindow(ServerWindow serverWindow){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(Color.WHITE);
        setBounds(POS_X-400, POS_Y, WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Login Client");
        setAlwaysOnTop(true);

        logInBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkLogin(server.getText(), port.getText(), nickName.getText(), passwd.getPassword())){
                    ServerWindow.reservePort(port.getText());
                    ClientDataBase.getClientByNickName(nickName.getText()).setOnline();
                    new ClientGUI(serverWindow, nickName.getText());
                    setVisible(false);
                }else{
                    log.append(SERVER_IS_DOWN);
                }
            }
        });

        loginPanel = new JPanel(new GridLayout(2, 3));
        loginPanel.add(server);
        loginPanel.add(port);
        loginPanel.add(new JLabel());
        loginPanel.add(nickName);
        loginPanel.add(passwd);
        loginPanel.add(logInBtn);

        sendField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                log.append(sendField.getText());
                sendField.setText("");
            }
        });
        sendPanel = new JPanel(new GridLayout());
        sendPanel.add(sendField, BorderLayout.CENTER);
        sendPanel.add(sendBtn, BorderLayout.EAST);


        log.setEditable(false);


        add(loginPanel, BorderLayout.NORTH);
        add(log);
        add(sendPanel, BorderLayout.SOUTH);
//        setVisible(true);

    }

    public static boolean checkLogin(String server, String port, String name, char[] passwd){
        return ClientDataBase.checkLogin(name, passwd) && ServerWindow.checkServer(server,port) && !ClientDataBase.getClientByNickName(name).isOnline();
    }
}
