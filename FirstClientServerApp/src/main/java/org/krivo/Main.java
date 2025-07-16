package org.krivo;

import org.krivo.Client.ClientGUI;
import org.krivo.Server.ServerWindow;


public class Main {
    public static void main(String[] args) {
        ServerWindow server = new ServerWindow();
        new ClientGUI(server);
        new ClientGUI(server);
    }
}
 