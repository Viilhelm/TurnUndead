package com.example.turnundead;

import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.util.Objects;

/**
 * Control class for the main menu of the game
 */
public class MainMenuController {
    public Button StartButton;
    public Button QuitButton;

    /**
     * <p>
     *     Enter the level selection screen
     * </p>
     */
    public void startButtonClicked() throws IOException{
        Parent LevelSelectLayout = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("LevelSelect.fxml")));
        Main.setMainMenuScene(new Scene(LevelSelectLayout));
        Main.getMainWindow().setScene(Main.getMainMenuScene());

    }


    public void mouseOnButton(){
        Main.getMainMenuScene().setCursor(Cursor.HAND);
    }

    public void mouseLeaveButton(){
        Main.getMainMenuScene().setCursor(Cursor.DEFAULT);
    }


    public void quitButtonClicked() throws IOException {
        Parent confirmQuitLayout = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("MainMenuConfirmQuit.fxml")));
        Main.setMainMenuScene(new Scene(confirmQuitLayout));
        Main.getMainWindow().setScene(Main.getMainMenuScene());

    }

    public void confirmQuitButton(){
        System.exit(0);
    }


    public void cancelQuitButton() throws IOException{
        Parent cancelQuitLayout = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("MenuScreen.fxml")));
        Main.setMainMenuScene(new Scene(cancelQuitLayout));
        Main.getMainWindow().setScene(Main.getMainMenuScene());
    }


    public void level1Button(){
        Main.startMainGame(1);

    }

    public void level2Button(){
        Main.startMainGame(2);

    }

}