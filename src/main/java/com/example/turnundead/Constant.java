package com.example.turnundead;

import otherElement.Other;
import weapon.Eye;
import weapon.Hand;
import weapon.Tree;
import weapon.Weapon;

import static com.example.turnundead.Game.*;

/**
 * <p>
 *     <code>Constant</code>Constants used in the game
 * </p>
 */
public class Constant {
    /**
     * The coordinate data of each grid in the meadow were recorded, including the coordinates of the upper left corner and the lower right corner of the grid, as well as the coordinates of the weapon selection area in the upper weapon selection list and the coordinates of the packet.
     */
    public static final int[][] tiles = {
            {0, 0, 0, 0}, // 0 useless

            {36, 78, 112, 174}, // 1
            {112, 78, 192, 174}, // 2
            {192, 78, 274, 174}, // 3
            {274, 78, 351, 174}, // 4
            {351, 78, 440, 174}, // 5
            {440, 78, 519, 174}, // 6
            {519, 78, 594, 174}, // 7
            {594, 78, 672, 174}, // 8
            {672, 78, 761, 174}, // 9

            {36, 174, 112, 272}, // 10
            {112, 174, 192, 272}, // 11
            {192, 174, 274, 272}, // 12
            {274, 174, 351, 272}, // 13
            {351, 174, 440, 272}, // 14
            {440, 174, 519, 272}, // 15
            {519, 174, 594, 272}, // 16
            {594, 174, 672, 272}, // 17
            {672, 174, 761, 272}, // 18

            {36, 272, 112, 380}, // 19
            {112, 272, 192, 380}, // 20
            {192, 272, 274, 380}, // 21
            {274, 272, 351, 380}, // 22
            {351, 272, 440, 380}, // 23
            {440, 272, 519, 380}, // 24
            {519, 272, 594, 380}, // 25
            {594, 272, 672, 380}, // 26
            {672, 272, 761, 380}, // 27

            {36, 380, 112, 470}, // 28
            {112, 380, 192, 470}, // 29
            {192, 380, 274, 470}, // 30
            {274, 380, 351, 470}, // 31
            {351, 380, 440, 470}, // 32
            {440, 380, 519, 470}, // 33
            {519, 380, 594, 470}, // 34
            {594, 380, 672, 470}, // 35
            {672, 380, 761, 470}, // 36

            {36, 470, 112, 570}, // 37
            {112, 470, 192, 570}, // 38
            {192, 470, 274, 570}, // 39
            {274, 470, 351, 570}, // 40
            {351, 470, 440, 570}, // 41
            {440, 470, 519, 570}, // 42
            {519, 470, 594, 570}, // 43
            {594, 470, 672, 570}, // 44
            {672, 470, 761, 570}, // 45

            {97, 5, 166, 80}, // 46 Hand selected
            {170, 5, 240, 80}, // 47 Eye selected
            {248, 5, 305, 80}, // 48 Tree selected


            {580, 11, 632, 65}, // 49 Packet selected(for removing plant)
            {681, 0, 794, 31}, // 50 Pause Button

    };

    /**
     * Holds the coordinates of the locations where newly put weapons appear, and the value of this variable is used when creating new weapons.
     */
    public static final int[][] newWeaponPosition = {
            {0, 0}, // 0 useless

            {44, 90}, // 1
            {122, 90}, // 2
            {201, 90}, // 3
            {283, 90}, // 4
            {363, 90}, // 5
            {446, 90}, // 6
            {526, 90}, // 7
            {601, 90}, // 8
            {683, 90}, // 9

            {44, 188}, // 10
            {122, 188}, // 11
            {201, 188}, // 12
            {283, 188}, // 13
            {363, 188}, // 14
            {446, 188}, // 15
            {526, 188}, // 16
            {601, 188}, // 17
            {683, 188}, // 18

            {44, 288}, // 19
            {122, 288}, // 20
            {201, 288}, // 21
            {283, 288}, // 22
            {363, 288}, // 23
            {446, 288}, // 24
            {526, 288}, // 25
            {601, 288}, // 26
            {683, 288}, // 27

            {44, 392}, // 28
            {122, 392}, // 29
            {201, 392}, // 30
            {283, 392}, // 31
            {363, 392}, // 32
            {446, 392}, // 33
            {526, 392}, // 34
            {601, 392}, // 35
            {683, 392}, // 36

            {44, 484}, // 37
            {122, 484}, // 38
            {201, 484}, // 39
            {283, 484}, // 40
            {363, 484}, // 41
            {446, 484}, // 42
            {526, 484}, // 43
            {601, 484}, // 44
            {683, 484}, // 45

            {97, 5}, // 46 Hand selected
            {170, 5}, // 47 Eye selected
            {248, 5}, // 48 Tree selected

            {580, 11}, // 49 Packet location
            {681, 0}, // 50 Pause Button location

    };


    public static final double DROP_SPEED = 30;

    public static final int NORMAL_GHOST = 11;

    public static final double NORMAL_GHOST_DAMAGE = 1;

    public static final double NORMAL_GHOST_HEALTH = 10;

    public static final double NORMAL_GHOST_ATTACK_SPEED = 1;

    public static final double NORMAL_GHOST_MOVEMENT_SPEED = -16.67;


    public static final int HAND = 1;

    public static final int HAND_COST = 100;

    public static final double HAND_DAMAGE = 1;

    public static final double HAND_HEALTH = 6;

    public static final double HAND_ATTACK_SPEED = 1.5;

    public static final double HAND_COOLDOWN_TIME = 7.5;


    public static final int EYE = 2;

    public static final int EYE_COST = 200;

    public static final double EYE_DAMAGE = 90;

    public static final double EYE_HEALTH = 9999;

    public static final double EYE_ATTACK_SPEED = 1;

    public static final double EYE_COOLDOWN_TIME = 30;


    public static final int TREE = 3;

    public static final int TREE_COST = 50;

    public static final double TREE_DAMAGE = 0;

    public static final double TREE_HEALTH = 72;

    public static final double TREE_ATTACK_SPEED = 0;

    public static final double TREE_COOLDOWN_TIME = 15;


    public static int currentStage = 1;


    public static int getTile(double x, double y) {
        for (int i = 0; i < tiles.length; i++) {
            if (x >= tiles[i][0] && x <= tiles[i][2] && y >= tiles[i][1] && y <= tiles[i][3]) {
                return i;
            }
        }
        return 0;
    }


    public static void getWeaponPicture(int tileNumber, double x, double y) {
        if (tileNumber >= 46 && tileNumber <= 48 && energy >= weaponChosenList.get(tileNumber - 46).Cost) {
            Weapon weapon = weaponChosenList.get(tileNumber - 46);
            weapon.elapsedTime = System.currentTimeMillis() - weapon.recordedTime;

            if (weapon.elapsedTime > weapon.cooldownTime * 1000 || weapon.firstPurchaseNoCooldown) {
                switch (tileNumber) {
                    case 46 -> {
                        weaponSelected = 1;
                        weaponChosen = new Hand(0);
                    }

                    case 47 -> {
                        weaponSelected = 2;
                        weaponChosen = new Eye(0);
                    }
                    case 48 -> {
                        weaponSelected = 3;
                        weaponChosen = new Tree(0);
                    }

                }

                weaponChosen.setPosition(x - weaponChosen.width / 2, y - weaponChosen.height / 2);
            }
        } else if (tileNumber == 49) {
            packetSelected = true;
            weaponChosen = new Other("/Pictures/packet.png");
            weaponChosen.setPosition(x - 33, y - 33);
        } else {
            weaponSelected = 0;
            packetSelected = false;
        }
    }



}