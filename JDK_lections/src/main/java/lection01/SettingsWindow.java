package lection01;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
    public static final int WINDOW_HEIGHT = 230;
    public static final int WINDOW_WIDTH = 350;
    public static final String SELECTED_SIZE_OF_FIELD = "Выбранный размер поля: ";
    public static final String SELECTED_SIZE_WIN = "Установленная длина: ";
    public JSlider sizeW = new JSlider(3,10);
    public JSlider sizeF = new JSlider(3,10);
    JRadioButton btn1 = new JRadioButton("Человек против компьютера");
    JRadioButton btn2 = new JRadioButton("Человек против человека");
    GameWindow gameWindow;

    JButton btnStart = new JButton("Start new game");
    SettingsWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setLocationRelativeTo(gameWindow);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);


        JPanel settings = new JPanel(new GridLayout(3, 1));

        JPanel typeGame = new JPanel(new GridLayout(3, 1));
        typeGame.add(new JLabel("Выберите режим игры"));
        ButtonGroup group1 = new ButtonGroup();
        btn1.setSelected(true);
        group1.add(btn1);
        group1.add(btn2);
        typeGame.add(btn1);
        typeGame.add(btn2);


        JPanel sizeWin = new JPanel(new GridLayout(3,1));
        sizeWin.add(new JLabel("Выберите длину для победы"));
        JLabel labelSizeWin = new JLabel(SELECTED_SIZE_WIN);
        sizeWin.add(labelSizeWin);
        sizeW.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int sizeWin = sizeW.getValue();
                labelSizeWin.setText(SELECTED_SIZE_WIN + sizeWin);
            }
        });

        sizeWin.add(sizeW);

        JPanel sizeField = new JPanel(new GridLayout(3,1));
        sizeField.add(new JLabel("Выберите размеры поля"));
        JLabel labelCurrentSize = new JLabel(SELECTED_SIZE_OF_FIELD);
        sizeField.add(labelCurrentSize);
        sizeF.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int size = sizeF.getValue();
                labelCurrentSize.setText(SELECTED_SIZE_OF_FIELD + size);
                sizeW.setMaximum(size);
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startNewGame();
            }
        });

        add(btnStart, BorderLayout.SOUTH);

        sizeField.add(sizeF);

        settings.add(typeGame);
        settings.add(sizeField);
        settings.add(sizeWin);

        add(settings);
    }

    private void startNewGame(){
        int mode = 0;
        if(btn1.isSelected()){
            mode = 1;
        } else if(btn2.isSelected()) {
            mode = 2;
        }
        int sizeField = sizeF.getValue();
        int sizeWin = sizeW.getValue();
        gameWindow.startNewGame(mode, sizeField, sizeField, sizeWin);
        setVisible(false);
    }

}
