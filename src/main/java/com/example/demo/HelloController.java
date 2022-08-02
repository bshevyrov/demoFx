package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText(String.valueOf(WifiUtils.getWlanDevicesName()).toString());
//        welcomeText.setText("Welcome to JavaFX Application!");
    }
}