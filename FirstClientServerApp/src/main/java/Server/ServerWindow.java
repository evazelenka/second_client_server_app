package Server;


import lombok.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import static Server.Server.isServerWorking;

@Data
public class ServerWindow extends JFrame {
    private static final int POS_X = 500;
    private static final int POS_Y = 550;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;


    private final JButton btnStart = new JButton("Start");
    private final JButton btnStop = new JButton("Stop");
    private static final JTextArea log = new JTextArea();

    public static String serverMessage = "";


    public ServerWindow(){
        isServerWorking = false;

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isServerWorking){
                    log.append("Server is not running" + "\n");
                } else {
                    isServerWorking = false;
                    serverMessage = "Server stopped " + false + "\n";
                    Server.stopServer();
                    Server.serverState(ServerWindow.this);
                }
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isServerWorking){
                    log.append("Server is already running" + "\n");
                }else{
                    isServerWorking = true;
                    serverMessage = "Server started " + true + "\n";
                    Server.serverState(ServerWindow.this);
                }

            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setBackground(Color.WHITE);
        setAlwaysOnTop(true);

        JPanel serverBtns = new JPanel(new GridLayout(1, 2));
        serverBtns.add(btnStart);
        serverBtns.add(btnStop);

        log.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(log);

        add(serverBtns, BorderLayout.SOUTH);
        add(scrollPane);

        setVisible(true);
    }

    public static void appendLog(String msg){
        log.append(msg);
    }
}
