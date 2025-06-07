import javax.swing.*;

public class TestTwoFrames implements  Runnable{

    JFrame theFrame;

    public TestTwoFrames(JFrame f) {
        this.theFrame = f;
    }

    @Override
    public void run() {
        theFrame.setSize(400, 300);
        theFrame.setVisible(true);

        // Attention: This closes the app, and therefore both frames!
//        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
