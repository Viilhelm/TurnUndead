package com.example.turnundead;

import otherElement.Other;
import weapon.Eye;
import weapon.Hand;
import weapon.Tree;
import weapon.Weapon;

import java.util.Collections;

import static com.example.turnundead.Game.other;
import static com.example.turnundead.Game.weaponChosenList;

/**
 * <p>
 *     <code>Initialize</code>used to record the process of some game initialization, the method is related to the game initialization.
 * </p>
 */
public class Initialize {

    public static void initializeChosenList() {
        Hand hand = new Hand(46, 70, 70);

        Eye eye = new Eye(47, 70, 70);
        Tree tree = new Tree(48, 60, 60);

        Collections.addAll(weaponChosenList, hand, eye, tree);
        for (Weapon weapon : weaponChosenList) {
            if (weapon.firstPurchaseNoCooldown) {
                weapon.recordedTime = 0;
            }
        }
    }


    public static void initializeOtherList() {
        other.add(new Other("/Pictures/background.png"));
        other.add(new Other("/Pictures/plantChosenList.png"));
        Basic pauseButton = new Other("/Pictures/pauseButton.png");
        pauseButton.setPosition(681, 0);
        other.add(pauseButton);
    }


    public static void initializeLevel() {
        switch (Constant.currentStage) {
            case 1 -> Level.setLevel1();
            case 2 -> Level.setLevel2();

        }
    }
}