package com.example.turnundead;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import static com.example.turnundead.Constant.currentStage;

/**
 * <p>
 * <code>Level</code>create levels that specify how many ghosts will appear in each level and when they will appear.
 * </p>
 */
public class Level {

    public static double[][] level;

    public static void setLevel1() {
        level = new double[][]{
                {10, Constant.NORMAL_GHOST}, {20, Constant.NORMAL_GHOST}, {30, Constant.NORMAL_GHOST}, {35, Constant.NORMAL_GHOST},
                {40, Constant.NORMAL_GHOST}, {45, Constant.NORMAL_GHOST}, {50, Constant.NORMAL_GHOST}, {55, Constant.NORMAL_GHOST}

        };

    }

    public static void setLevel2() {
        level = new double[][]{
                {2, Constant.NORMAL_GHOST}, {3, Constant.NORMAL_GHOST}, {4, Constant.NORMAL_GHOST}, {5, Constant.NORMAL_GHOST},
                {9, Constant.NORMAL_GHOST}, {10, Constant.NORMAL_GHOST}, {11, Constant.NORMAL_GHOST}, {12, Constant.NORMAL_GHOST},
                {20, Constant.NORMAL_GHOST}, {30, Constant.NORMAL_GHOST}, {35, Constant.NORMAL_GHOST}, {40, Constant.NORMAL_GHOST},
                {60, Constant.NORMAL_GHOST}, {61, Constant.NORMAL_GHOST}, {70, Constant.NORMAL_GHOST}, {71, Constant.NORMAL_GHOST}
        };
    }

    public static void setPrompt(GraphicsContext context){
        if (currentStage == 1){
            String s ="This is a level for beginners to get used to.";
            context.setFont(new Font(20));
            context.setFill(Color.WHITE);
            context.fillText(s, 140, 580, 500);

        }

    }


}
