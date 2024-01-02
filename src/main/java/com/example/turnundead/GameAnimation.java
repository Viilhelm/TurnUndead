package com.example.turnundead;

import ghost.Ghost;
import javafx.animation.AnimationTimer;
import otherElement.Energy;
import otherElement.GhostCounter;
import otherElement.Pochita;
import weapon.Weapon;

import static com.example.turnundead.Game.*;

/**
 * <p>
 *     <code>AnimationTimer</code>is responsible for the main loop of the game.<code>handle</code>method is called every 1/60 of a second
 *     So，this class renders each frame of the animation by calling the <code>handle</code>method to achieve the animation effect.
 * </p>
 */
public class GameAnimation extends AnimationTimer {

    private boolean isStart = false;

    private long startTime = 0;

    /**
     * <p>
     *     handle method that handles the program that should be implemented for each loop in the main loop.
     *     This method is called every 1/60 of a second in the main loop of the game body.
     * </p>
     * <p>
     *     Check that ghost movement implementation and bullet movement are written inside the <code>handle</code>, and the game screen refresh is also implemented by <code>handle</code>.
     *     The result of the game is also determined within the <code>handle</code>.
     * </p>
     *
     */
    @Override
    public void handle(long l) {
        if(isStart){
            //l The time each time this method is run
            startTime = l;
            isStart = false;
        }
        long time = (long)((l - startTime )/(1e8));
        for (Basic basic : other) {
            basic.render(Main.getContext());
        }

        Ghost.generateGhost();
        Energy.generateEnergy();
        Energy.updateCurrentEnergy(Main.getContext());
        GhostCounter.updateCounter(Main.getContext());
        Level.setPrompt(Main.getContext());


        for(Pochita pochita : pochitas){
            pochita.update(time,Main.getContext());
        }

        for (Weapon weapon : weaponChosenList) {
            weapon.updateChosen(Main.getContext());
        }

        for (Weapon weapon : weaponList) {
            weapon.update(time, Main.getContext());
        }

        for (Ghost ghost : ghostList) {
            ghost.update(time, Main.getContext());
        }

        for (Energy energy : energyList) {
            energy.update(time, Main.getContext());
        }

        if (weaponChosen != null) {
            weaponChosen.render(Main.getContext());
        }

        if (gameIsWin()) {
            stop();
            gameWin();
        }
        if (gameIsLose()) {
            stop();
            gameLose();
        }
    }

    /**
     * start method starts the main loop of the main game body.
     */
    @Override
    public void start() {
        super.start();
        isStart = true;
    }
}