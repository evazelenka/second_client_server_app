import Client.ClientGUI;
import Server.ServerWindow;
import Client.LogInWindow;

public class Main {
    public static void main(String[] args) {
        ServerWindow server = new ServerWindow();
//        LogInWindow lw1 = new LogInWindow(server);
//        LogInWindow lw2 = new LogInWindow(server);
//        new ServerWindow();
////        new ServerWindow();
        LogInWindow lw1 = new LogInWindow(server);
        LogInWindow lw2 = new LogInWindow(server);

        Thread t1 = new Thread(new TestTwoFrames(lw1));
        Thread t2 = new Thread(new TestTwoFrames(lw2));

        t1.start();
        t2.start();
    }
}
