package com.example.turnundead;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;

/**
 * <p>
 *     <code>Basic</code>is the parent class of each game element in the implementation of the game.
 * </p>
 */
public abstract class Basic {

    public double positionX;

    public double positionY;

    public double velocityX;

    public double velocityY;

    public double width;

    public double height;

    public int row;

    public Image image;

    public double health;



    public void setImage(String path) {
        this.image = new Image(Objects.requireNonNull(this.getClass().getResourceAsStream(path)));
        this.width = this.image.getWidth();
        this.height = this.image.getHeight();
    }


    public void setImage(Image image) {
        this.image = image;
        this.width = this.image.getWidth();
        this.height = this.image.getHeight();
    }


    public void setImage(String path, double width, double height) {
        this.image = new Image(Objects.requireNonNull(this.getClass().getResourceAsStream(path)), width, height, false, false);
        this.width = this.image.getWidth();
        this.height = this.image.getHeight();
    }


    public Image createImage(String path) {
        return new Image(Objects.requireNonNull(this.getClass().getResourceAsStream(path)));
    }


    public void setPosition(double x, double y) {
        this.positionX = x;
        this.positionY = y;
    }


    public void setVelocity(double x, double y) {
        this.velocityX = x;
        this.velocityY = y;
    }


    public boolean isOverlapped(Basic otherBasic) {
        if (this.row == otherBasic.row) {
            return !(this.positionX + this.width < otherBasic.positionX || otherBasic.positionX + otherBasic.width < this.positionX);
        }
        return false;
    }


    public abstract void update(long time, GraphicsContext context);


    public void render(GraphicsContext context) {
        context.save();
        context.translate(this.positionX, this.positionY);
        context.drawImage(this.image, 0, 0);
        context.restore();
    }

    public void updateHealthBar(GraphicsContext context, int type){
        double healthBarWidth=60;
        double healthBarHeight=6;
        double healthPercentage = 0;

        switch(type){
            case Constant.HAND -> healthPercentage = this.health/ Constant.HAND_HEALTH *healthBarWidth;
            case Constant.EYE -> healthPercentage = this.health/ Constant.EYE_HEALTH *healthBarWidth;
            case Constant.TREE -> healthPercentage = this.health/ Constant.TREE_HEALTH *healthBarWidth;
            case Constant.NORMAL_GHOST -> healthPercentage = this.health/ Constant.NORMAL_GHOST_HEALTH *healthBarWidth;
        }



        context.fillRoundRect(this.positionX,this.positionY-healthBarHeight-5,healthPercentage,healthBarHeight ,5,5);

    }
}