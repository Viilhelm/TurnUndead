package com.example.turnundead;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import otherElement.Energy;
import weapon.Eye;
import weapon.Hand;
import weapon.Tree;
import weapon.Weapon;

import java.util.Objects;

import static com.example.turnundead.Constant.currentStage;
import static com.example.turnundead.Game.*;

/**
 * <p>
 *     <code>Main</code> is the starting point and body of the program.
 * </p>
 */
public class Main extends Application {
    private static Stage mainWindow;

    private static GraphicsContext context;

    private static Scene mainMenuScene;

    private static MediaPlayer mediaPlayer;


    public static void main(String[] args) {
        launch(args);
    }

    /**
     * <p>
     *     The game's entry method, called by the main to get to the main page of the game.
     * </p>
     * <p>
     *     First, the game window for some initial Settings, such as title, game window size and so on. Then enter the game home page.
     * </p>
     *
     */
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Turn Undead");
        Image icon = new Image(String.valueOf(Main.class.getResource("/Pictures/energy.png")));
        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.setAlwaysOnTop(true);

        mainWindow = stage;

        Parent mainMenuLayout = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("MenuScreen.fxml")));
        mainMenuScene = new Scene(mainMenuLayout,800,456);

        stage.setScene(mainMenuScene);
        stage.show();
    }

    /**
     * <p>
     *     start method of the main game body
     * </p>
     * <p>
     *     After selecting the level on the main page, set up the level and initialize it.
     *     Then set up a listener on the game's page.
     * </p>
     *
     * @see MainMenuController
     */
    public static void startMainGame(int stage){
        currentStage = stage;

        Media media = new Media(Objects.requireNonNull(Main.class.getResource("/Music/game.mp3")).toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();

        Game.InitializeGame();
        Initialize.initializeOtherList();
        Initialize.initializeChosenList();
        Initialize.initializeLevel();

        BorderPane root = new BorderPane();

        Canvas canvas = new Canvas(800, 600);
        context = canvas.getGraphicsContext2D();
        root.setCenter(canvas);

        Scene scene = new Scene(root);

        mainWindow.setScene(scene);

        canvas.setOnMouseClicked(mouseEvent -> {
            double x = mouseEvent.getX();
            double y = mouseEvent.getY();
            int tileNumber = Constant.getTile(x, y);

            for (Energy energy : energyList) {
                if (x >= energy.positionX && x <= energy.positionX + energy.width && y >= energy.positionY && y <= energy.positionY + energy.height) {
                    Game.energy += 25;
                    energyList.remove(energy);
                    return;
                }
            }

            if (!gameIsPause){
                if (tileNumber == 50 ){
                    gamePause();
                    return;
                }
                if (packetSelected) {
                    if (tileNumber >= 1 && tileNumber <= 45 && tileHasWeapon.contains(tileNumber)) {
                        for (Weapon weapon : weaponList) {
                            if (weapon.tile == tileNumber){
                                weaponList.remove(weapon);
                                tileHasWeapon.remove(tileNumber);
                                break;
                            }
                        }
                    }
                    weaponChosen = null;
                    packetSelected = false;
                    return;
                }
                if (weaponSelected > 0){
                    Weapon weapon = weaponChosenList.get(weaponSelected - 1);
                    if (tileNumber >= 1 && tileNumber <= 45 && !tileHasWeapon.contains(tileNumber) && energy >= weapon.Cost){
                        switch (weaponSelected) {
                            case Constant.HAND -> weaponList.add(new Hand(tileNumber));
                            case Constant.EYE -> weaponList.add(new Eye(tileNumber));
                            case Constant.TREE -> weaponList.add(new Tree(tileNumber));
                        }
                        energy -= weapon.Cost;
                        weapon.firstPurchaseNoCooldown = false;
                        weapon.recordedTime = System.currentTimeMillis();
                    }
                    weaponChosen = null;
                    weaponSelected = 0;
                }else {
                    Constant.getWeaponPicture(tileNumber, x, y);
                }
            }else{
                if (tileNumber == 50){
                    gameContinue();
                }
            }





        });

        canvas.setOnMouseMoved(mouseEvent -> {
            if (weaponSelected > 0 || packetSelected) {
                weaponChosen.setPosition(mouseEvent.getX() - weaponChosen.width / 2, mouseEvent.getY() - weaponChosen.height / 2);
            }
        });


        GameAnimation animationTimer = new GameAnimation();
        animationTimer.start();
        recordedAnimationTimer = animationTimer;
    }


    public static Stage getMainWindow() {
        return mainWindow;
    }

    public static Scene getMainMenuScene() {
        return mainMenuScene;
    }

    public static void setMainMenuScene(Scene mainMenuScene) {
        Main.mainMenuScene = mainMenuScene;
    }

    public static GraphicsContext getContext() {
        return context;
    }

    public static MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

}