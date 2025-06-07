package Server;

import Client.LogInWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class ServerWindow extends JFrame {
    private static final int POS_X = 500;
    private static final int POS_Y = 550;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private static final String SERVER = "127.0.0.1";
    private static final String[] ports = {"80", "17", "84"};
    private static String[] busyPorts = {"0", "0", "0"};

    private final JButton btnStart = new JButton("Start");
    private final JButton btnStop = new JButton("Stop");
    private final JTextArea log = new JTextArea();
    public static boolean isServerWorking;
    private LogInWindow logInWindow = new LogInWindow(this);

    public ServerWindow(){
        isServerWorking = false;
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isServerWorking){
                    System.out.println("Server is not running");
//                    LogInWindow.log.append("Server is not running" + "\n");
                    log.append("Server is not running" + "\n");
                }else{
                    isServerWorking = false;
                    stopServer();
                    System.out.println("Server stopped " + false + "\n");
                    logInWindow.log.append("Server stopped " + false + "\n");
                    log.append("Server stopped " + false + "\n");
                }
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isServerWorking){
                    System.out.println("Server is already running");
//                    LogInWindow.log.append("Server is already running" + "\n");
                    log.append("Server is already running" + "\n");
                }else{
                    isServerWorking = true;
                    System.out.println("Server started " + true + "\n");
                    logInWindow.log.append("Server started " + true + "\n");
                    log.append("Server started " + true + "\n");
                }

            }
        });

//        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setBackground(Color.WHITE);
        setAlwaysOnTop(true);

        JPanel serverBtns = new JPanel(new GridLayout(1, 2));
        serverBtns.add(btnStart);
        serverBtns.add(btnStop);

        add(serverBtns, BorderLayout.SOUTH);
        add(log);

        setVisible(true);
    }

    public static boolean checkServer(String server, String port){
        System.out.println(isServerWorking & SERVER.equals(server) & isPortFree(port));
        return isServerWorking & SERVER.equals(server) & isPortFree(port);
    }

    private static boolean isPortFree(String port){
        for (int i = 0; i < busyPorts.length; i++) {
            if(port.equals(busyPorts[i])){
                return false;
            }
        }
        return true;
    }

    public static void reservePort(String port){
        for (int i = 0; i < busyPorts.length; i++) {
            if(busyPorts[i].equals("0")){
                busyPorts[i] = port;
                return;
            }
        }
    }

    private static void stopServer(){
        Arrays.fill(busyPorts, "0");
    }

}
