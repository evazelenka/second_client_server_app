package Server;

import Client.ClientGUI;
import Client.LogInWindow;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;

public class Server {

    private static final String SERVER = "127.0.0.1";
    private static final String[] ports = {"80", "17", "84"};
    private static String[] busyPorts = {"0", "0", "0"};
    public static boolean isServerWorking;
    public static boolean isUpdated;

    public static boolean checkServer(String server, String port){

        return SERVER.equals(server) & Arrays.stream(ports).anyMatch(p -> Objects.equals(p, port)) & isServerWorking & isPortFree(port);
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

    public void stopServer(){
        Arrays.fill(busyPorts, "0");
//        logInWindow.serverStopped();
    }


//    public String updateChat(String msg)  {
//        String chat = "";
//        StringBuilder c = new StringBuilder("");
//        try(BufferedWriter fw =new BufferedWriter(new FileWriter("C:\\Users\\evaze\\OneDrive\\Desktop\\zelenka\\chat.txt", true)); BufferedReader fr = new BufferedReader(new FileReader("C:\\Users\\evaze\\OneDrive\\Desktop\\zelenka\\chat.txt"))){
//            fw.write(msg);
//            fw.flush();
//            chat = fr.lines().toString();
//            Object [] lines = fr.lines().toArray();
//            for (int i = 0; i < lines.length; i++) {
//                if(lines.length > 0){
//                    c.append(lines[lines.length -1 ].toString()).append("\n");
//                }
//                c.append(lines[0].toString()).append("\n");
//            }
//
////            chat = fr.readLine();
//        } catch (IOException e) {
//            System.out.println("file not found");
//        }
//
//        return msg;
//    }

    public static void serverState(ServerWindow serverWindow){
        String state = ServerWindow.serverMessage;
        serverWindow.getLog().append(state);
    }

    public static void writeInChat(String msg){
        try(BufferedWriter fw =new BufferedWriter(new FileWriter("src/main/java/test.txt", true))){
            fw.write(msg);
            fw.newLine();
            fw.flush();
            isUpdated = true;
            ClientGUI.updateChat();

        } catch (IOException e) {
            throw new RuntimeException(e);
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
