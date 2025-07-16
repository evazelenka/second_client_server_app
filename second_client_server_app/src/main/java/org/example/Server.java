package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    // region Fields
    private ServerSocket serverSocket;
    // endregion

    // region Constructors
    public Server(ServerSocket serverSocket){
        this.serverSocket = serverSocket;
    }
    // endregion

    // region Methods
    public void runServer() {
        try {
            while (!serverSocket.isClosed()){
                Socket socket = serverSocket.accept();
                System.out.println("new client connected");
                ClientManager clientManager = new ClientManager(socket);
                Thread thread = new Thread(clientManager);
                thread.start();
            }
        } catch (IOException e){
            closeSocket();
        }
    }

    private void closeSocket() {
        try {
            if (serverSocket != null) serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket1 = new ServerSocket(1300);
        Server server = new Server(serverSocket1);
        server.runServer();
    }
    // endregion
}
