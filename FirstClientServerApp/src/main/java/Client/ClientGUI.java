package Client;

import DB.ClientDataBase;
import Server.Server;
import Server.ServerWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;


public class ClientGUI extends JFrame {
    private static final int POS_X = 500;
    private static final int POS_Y = 550;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;


    private final String SERVER_IS_DOWN = "connection failed\ntry again later\n";
    private final JTextField server = new JTextField(20);
    private JTextField port = new JTextField(20);
    private  JTextField nickName = new JTextField(20);
    private  JPasswordField passwd = new JPasswordField(20);
    private  JButton logInBtn = new JButton("login");
    private  JTextField sendField = new JTextField(100);
    private  JButton sendBtn = new JButton("send");
    public JTextArea log = new JTextArea();
    private  final String LOGIN_SUCCESS = "loged in successfully\n";

    private JPanel loginPanel;
    private boolean logged = false;




    public ClientGUI(ServerWindow serverWindow){
        setBackground(Color.WHITE);
        setBounds(POS_X+400, POS_Y, WIDTH, HEIGHT);
        setTitle("Chat Client");
        setVisible(true);

        createPanel();
    }

    private void connectToServer(){
        if(checkLogin(server.getText(), port.getText(), nickName.getText(), passwd.getPassword())){
            Server.reservePort(port.getText());
            ClientDataBase.getClientByNickName(nickName.getText()).setOnline();
            logged = true;
            loginPanel.setVisible(false);
            log.append(LOGIN_SUCCESS);
            log.setText(String.valueOf(Server.readInChat()));
        }else{
            log.append(SERVER_IS_DOWN);
        }
    }

    public void disconnectFromServer(){
        if(logged){
            logged = false;
            loginPanel.setVisible(true);
            Server.disconnect(this);
            log.setText("disconnect\n");
        }
    }

    public String getPort(){
        return port.getText();
    }

    private Component createHeader(){
        loginPanel = new JPanel(new GridLayout(2, 3));

        logInBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connectToServer();
            }
        });

        loginPanel.add(server);
        loginPanel.add(port);
        loginPanel.add(new JLabel());
        loginPanel.add(nickName);
        loginPanel.add(passwd);
        loginPanel.add(logInBtn);
        return loginPanel;
    }

    private Component createFooter(){
        sendBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                message();
            }
        });
        sendField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                message();
            }
        });
        JPanel sendPanel = new JPanel(new GridLayout(1, 2));
        sendPanel.add(sendField);
        sendPanel.add(sendBtn);
        return  sendPanel;

    }

    private void message(){
        if(logged){
            String text = sendField.getText();
            if(!text.equals("")){
                Server.writeInChat(nickName.getText() + ": " + text);
                sendField.setText("");
            }else log.append(SERVER_IS_DOWN);
        }
    }

    private void createPanel(){
        add(createHeader(), BorderLayout.NORTH);
        add(createLog());
        add(createFooter(), BorderLayout.SOUTH);
    }

    private Component createLog(){
        log = new JTextArea();
        log.setEditable(false);
        return new JScrollPane(log);
    }

    public void serverStopped(){
        if(this.isVisible()){
            this.setVisible(false);
        }
    }

    public void answer(String msg){
        log.append(msg + "\n");
    }

    public boolean checkLogin(String server, String port, String name, char[] passwd){
        return ClientDataBase.checkLogin(name, passwd) && Server.checkServer(server, port, this) && !ClientDataBase.getClientByNickName(name).isOnline();
    }

    public String getNickName(){
        return nickName.getText();
    }

    @Override
    protected void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING){
            disconnectFromServer();
        }
        super.processWindowEvent(e);
    }

}
