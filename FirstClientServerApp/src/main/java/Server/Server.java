package Server;

import Client.ClientGUI;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Server {

    private static final String SERVER = "127.0.0.1";
    private static final String[] ports = {"80", "17", "84"};
    private static String[] busyPorts = {"0", "0", "0"};
    public static boolean isServerWorking;
    public static boolean isUpdated;

    public static List<ClientGUI> clientsOnline = new ArrayList<ClientGUI>();

    public static boolean checkServer(String server, String port, ClientGUI client){
        if(SERVER.equals(server) & Arrays.stream(ports).anyMatch(p -> Objects.equals(p, port)) & isServerWorking & isPortFree(port)){
            clientsOnline.add(client);
            ServerWindow.appendLog(client.getNickName() + " connected to server\n" + readInChat());
            return true;
        }
        return false;
    }

    public static void disconnect(ClientGUI client){
        clientsOnline.remove(client);
        for (int i = 0; i < busyPorts.length; i++) {
            if(client.getPort().equals(busyPorts[i])){
                busyPorts[i] = "0";
            }
        }
        if (client != null){
            client.disconnectFromServer();
        }
    }


    private static boolean isPortFree(String port){
        return Arrays.stream(busyPorts).noneMatch(p -> Objects.equals(p, port));
    }
    

    public static void reservePort(String port){
        for (int i = 0; i < busyPorts.length; i++) {
            if(busyPorts[i].equals("0")){
                busyPorts[i] = port;
                return;
            }
        }
    }

    public static void stopServer(){
        Arrays.fill(busyPorts, "0");
        while (!clientsOnline.isEmpty()){
            System.out.println("yes");
            disconnect(clientsOnline.get(clientsOnline.size()-1));
        }
    }



    public static void serverState(ServerWindow serverWindow){
        String state = ServerWindow.serverMessage;
        ServerWindow.appendLog(state);
    }

    public static void writeInChat(String msg){
        try(BufferedWriter fw =new BufferedWriter(new FileWriter("src/main/java/test.txt", true))){
            fw.write(msg);
            fw.newLine();
            fw.flush();
            answerAll(msg);
            ServerWindow.appendLog(msg);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void answerAll(String msg){
        for (ClientGUI client : clientsOnline) {
            client.answer(msg);
        }
    }

    public static StringBuilder readInChat(){
        StringBuilder sb = new StringBuilder();
        try( BufferedReader fr = new BufferedReader(new FileReader("src/main/java/test.txt"))){
            String line;
            while((line = fr.readLine()) != null){
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb;
    }
}
