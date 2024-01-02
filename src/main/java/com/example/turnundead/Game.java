package com.example.turnundead;

import ghost.Ghost;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import otherElement.Energy;
import otherElement.Pochita;
import weapon.Weapon;

import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *  <p>
 *      <code>Game</code>is used to save all data generated and recorded during the course of a game (a level).
 *  </p>
 */
public class Game {

    public static CopyOnWriteArrayList<Ghost> ghostList = new CopyOnWriteArrayList<>();
    /**
     * Record the time, with<code>gameElpasedTime</code>together to realize the ghost generation time calculation and control.
     */
    public static long gameRecordedTime = 0;

    public static long gameElapsedtime = 0;

    public static int currentGhost = 0;

    public static CopyOnWriteArrayList<Weapon> weaponList = new CopyOnWriteArrayList<>();

    public static HashSet<Integer> tileHasWeapon = new HashSet<>();

    public static CopyOnWriteArrayList<Energy> energyList = new CopyOnWriteArrayList<>();

    public static long GenerationRecordedTime = 0;

    public static long GenerationElapsedTime = 0;

    public static int energy = 200;

    public static CopyOnWriteArrayList<Weapon> weaponChosenList = new CopyOnWriteArrayList<>();
    /**
     * Records the currently selected weapons that are not yet used.
     */
    public static int weaponSelected = 0;

    public static boolean packetSelected = false;
    /**
     * After selecting a new weapon, the screen of the selected weapon changes as the mouse coordinates change.
     */
    public static Basic weaponChosen;

    /**
     * Save some other graphics used in the game rendering process, such as the background image grass.
     */
    public static CopyOnWriteArrayList<Basic> other = new CopyOnWriteArrayList<>();

    public static boolean gameIsPause = false;

    public static long gamePauseTime;

    public static AnimationTimer recordedAnimationTimer;

    public static CopyOnWriteArrayList<Pochita> pochitas = new CopyOnWriteArrayList<>();

    public static boolean gameIsWin() {
        return currentGhost == Level.level.length && ghostList.size() == 0;
    }

    public static void gameWin() {
        try{
            Main.getMediaPlayer().stop();
            Parent winSceneLayout = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("WinScene.fxml")));
            Main.setMainMenuScene(new Scene(winSceneLayout));
            Main.getMainWindow().setScene(Main.getMainMenuScene());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static boolean gameIsLose() {
        for (Ghost ghost : ghostList) {
            if (ghost.positionX < -40) {
                return true;
            }
        }
        return false;
    }

    public static void gameLose() {
        try{
            Main.getMediaPlayer().stop();
            Parent loseSceneLayout = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("LoseScene.fxml")));
            Main.setMainMenuScene(new Scene(loseSceneLayout));
            Main.getMainWindow().setScene(Main.getMainMenuScene());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void gamePause() {
        gameIsPause = true;
        recordedAnimationTimer.stop();
        Main.getMediaPlayer().pause();
        gamePauseTime = System.currentTimeMillis();
    }

    public static void gameContinue() {
        gameIsPause = false;
        long pauseTime = System.currentTimeMillis() - gamePauseTime;

        for (Ghost ghost : ghostList) {
            ghost.recordedTime += pauseTime;
        }
        for (Weapon weapon : weaponList) {
            weapon.recordedTime += pauseTime;
        }
        for (Weapon weapon : weaponChosenList) {
            weapon.recordedTime += pauseTime;
        }
        for (Energy energy : energyList) {
            energy.recordedTime += pauseTime;
        }
        gameRecordedTime += pauseTime;
        GenerationRecordedTime += pauseTime;
        Main.getMediaPlayer().play();
        recordedAnimationTimer.start();
    }



    public static void InitializeGame(){
        ghostList = new CopyOnWriteArrayList<>();
        gameRecordedTime = System.currentTimeMillis();
        gameElapsedtime = 0;
        currentGhost = 0;

        weaponList = new CopyOnWriteArrayList<>();
        tileHasWeapon = new HashSet<>();

        energyList = new CopyOnWriteArrayList<>();
        GenerationRecordedTime = 0;
        GenerationElapsedTime = 0;
        energy = 200;

        weaponChosenList = new CopyOnWriteArrayList<>();
        weaponSelected = 0;
        packetSelected = false;

        other = new CopyOnWriteArrayList<>();
        pochitas = Pochita.initialize();
    }
}