package com.UI.ClientUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;


/**
 * @ author Fei Gu
 * @ create 2021-05-04-14.40
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description
 * @ Version
 */
public class UI_ClientRegister {
    public Stage ClientRegisterPage(Stage stage){
        Label new_client_register = new Label("New Client Register");
        new_client_register.setStyle("-fx-font-size: 20");
        new_client_register.setAlignment(Pos.TOP_CENTER);

        HBox hBox = new HBox();
        hBox.setPrefWidth(600);
        hBox.setPrefHeight(800);
        hBox.setPadding(new Insets(10)); // 调整四边的边距
        hBox.setSpacing(10); // 调整间距
        hBox.setAlignment(Pos.CENTER);
        hBox.setStyle("-fx-background-color: lightgreen");

        Label box1 = new Label("box1");
        VBox vBox1 = new VBox(box1);
        vBox1.setStyle("-fx-background-color: green");

        Label box2 = new Label("box2");
        VBox vBox2 = new VBox(box2);

        hBox.getChildren().setAll(vBox1,vBox2);


        BorderPane borderPane = new BorderPane();
        borderPane.setTop(new_client_register);
        borderPane.setCenter(hBox);
        Pane pane = new Pane(borderPane);
        Scene scene = new Scene(pane, 600, 800);
        stage.setScene(scene);
        return stage;
    }
}
