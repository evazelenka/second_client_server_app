package ru.gb.jdk.two.online.circles;

import ru.gb.jdk.two.online.common.CanvasMouseListener;
import ru.gb.jdk.two.online.common.CanvasRepaintListener;
import ru.gb.jdk.two.online.common.Interactable;
import ru.gb.jdk.two.online.common.MainCanvas;
import ru.gb.jdk.two.online.exceptions.SpritesExceptional;
import ru.gb.jdk.two.online.exceptions.SpritesException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MainWindow extends JFrame implements CanvasRepaintListener, CanvasMouseListener {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    private final ArrayList<Interactable> sprites = new ArrayList<>();

    private MainWindow(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");
        sprites.add(new Background());
        fillSprites();

        SpritesExceptional be = new SpritesExceptional();
        MainCanvas canvas = new MainCanvas(this);
        canvas.addMouseListener(this);
        Thread.setDefaultUncaughtExceptionHandler(be);
        add(canvas);
        setVisible(true);
    }

    private void fillSprites(){
        for (int i = 1; i < 14; i++) {
            sprites.add(new Ball());
        }
    }

    @Override
    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime){
        update(canvas, deltaTime);
        render(canvas, g);
    }

    public void createBall(){
        if(checkSpritesSize()){
            sprites.add(new Ball());
        }else {
            throw new SpritesException("you cannot add more than 15 circles");
        }

    }

    private boolean checkSpritesSize(){
        return sprites.size() <= 15;
    }

    public void removeBall(){
        int r;
        if(sprites.size() > 1){
            r = (int) (Math.random() * (sprites.size() - 1) + 1);
            sprites.remove(sprites.get(r));
        }
    }

    private void update(MainCanvas canvas, float deltaTime){
        for (int i = 0; i < sprites.size(); i++) {
            sprites.get(i).update(canvas, deltaTime);
        }
    }
    private void render(MainCanvas canvas, Graphics g){
        for (int i = 0; i < sprites.size(); i++) {
            sprites.get(i).render(canvas,g);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
        });
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(SwingUtilities.isRightMouseButton(e)){
            removeBall();
        }else if(SwingUtilities.isLeftMouseButton(e)){
            createBall();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
