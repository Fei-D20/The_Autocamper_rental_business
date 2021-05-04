package com.UI.ClientUI;

import com.APP.Controller.Client.Controller_ClientRegister;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @ author Fei Gu
 * @ create 2021-05-04-11.08
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description
 * @ Version
 */
public class UI_ClientFrontPage {
    public Stage clientFrontPage(Stage stage){
        Label label = new Label("Are you a new friend ? ");
        label.setLayoutX(200);
        label.setLayoutY(200);
        label.setPrefWidth(300);
        label.setPrefHeight(100);

        Button userRegister = new Button(" New coming ");
        userRegister.setPrefHeight(50);
        userRegister.setPrefWidth(200);
        userRegister.setLayoutX(200);
        userRegister.setLayoutY(300);

        userRegister.addEventHandler(MouseEvent.MOUSE_CLICKED, new Controller_ClientRegister().clientRegister(stage));

        Button userLogIn = new Button(" Log in ");
        userLogIn.setPrefHeight(50);
        userLogIn.setPrefWidth(200);
        userLogIn.setLayoutX(200);
        userLogIn.setLayoutY(400);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().setAll(label,userRegister,userLogIn);

        Pane pane = new Pane(anchorPane);
        Scene scene = new Scene(pane, 600, 800);
        stage.setScene(scene);
        return stage;
    }
}
