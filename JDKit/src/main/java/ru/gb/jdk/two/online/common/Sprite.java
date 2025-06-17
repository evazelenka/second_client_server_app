package ru.gb.jdk.two.online.common;

import java.awt.*;

public abstract class Sprite implements Interactable{
    protected float x, y, halfWidth, halfHeight;

    protected float getLeft(){return x - halfWidth;}
    protected void setLeft(float left){x = left + halfWidth;}
    protected float getRight(){return x + halfWidth;}
    protected void setRight(float right){x = right - halfWidth;}
    protected float getTop(){return y - halfHeight;}
    protected void setTop(float top){y = top + halfWidth;}
    protected float getBottom(){return y + halfWidth;}
    protected void setBottom(float bottom){y = bottom - halfWidth;}

    protected float getWidth(){return 2f * halfWidth;}
    protected float getHeight(){return 2f * halfHeight;}

    @Override
    public abstract void update(MainCanvas canvas, float deltaTime);

    @Override
    public abstract void render(MainCanvas canvas, Graphics g);

    public void setXY(float x, float y){
        this.x = x;
        this.y = y;

    }


}
