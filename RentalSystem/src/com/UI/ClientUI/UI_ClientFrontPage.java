package com.UI.ClientUI;

import com.APP.Controller.Client.Controller_ClientRegister;
import com.APP.Controller.console.Controller_FrontPage;
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
    public static Stage clientFrontPage(Stage stage){
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

        Button goBack = new Button("Go back");
        goBack.setPrefHeight(50);
        goBack.setPrefWidth(200);
        goBack.setLayoutX(200);
        goBack.setLayoutY(500);

        goBack.addEventHandler(MouseEvent.MOUSE_CLICKED,new Controller_FrontPage().gotoFrontPage(stage));

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().setAll(label,userRegister,userLogIn,goBack);

        Pane pane = new Pane(anchorPane);
        Scene scene = new Scene(pane, 600, 800);
        stage.setScene(scene);
        return stage;
    }
}
