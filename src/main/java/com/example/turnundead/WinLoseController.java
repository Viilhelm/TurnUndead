package com.example.turnundead;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.Objects;

/**
 * The main game loop after the end of the winning and losing prompts interface control class.
 */
public class WinLoseController {

    public void clickToContinue() throws IOException {
        Parent mainMenuLayout = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("MenuScreen.fxml")));
        Main.setMainMenuScene(new Scene(mainMenuLayout));
        Main.getMainWindow().setScene(Main.getMainMenuScene());
    }
}