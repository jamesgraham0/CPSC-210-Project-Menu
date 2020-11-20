package ui.model;

import java.awt.*;

// abstract class of sprites, might use in phase 4
public abstract class Sprite {

    private java.awt.Image image;
    private boolean dead;

    protected int xcoord;
    protected int ycoord;
    protected int dx;
    protected int dy;

    public abstract void move();

    // Constructor
    public Sprite() {
        this.dead = false;
    }

    public void die() {
        this.dead = true;
    }

    public Image getImage() {
        return this.image;
    }

    public void setImage(java.awt.Image image) {
        this.image = image;
    }

    public int getXcoord() {
        return this.xcoord;
    }

    public int getYcoord() {
        return this.ycoord;
    }

    public void setXcoord(int xcoord) {
        this.xcoord = xcoord;
    }

    public void setYcoord(int ycoord) {
        this.ycoord = ycoord;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public boolean isDead() {
        return this.dead;
    }

}
