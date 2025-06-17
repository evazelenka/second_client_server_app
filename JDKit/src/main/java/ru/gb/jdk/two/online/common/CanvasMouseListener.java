package ru.gb.jdk.two.online.common;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public interface CanvasMouseListener extends MouseListener {
    @Override
    void mouseClicked(MouseEvent e);
}
