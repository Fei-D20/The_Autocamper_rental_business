package com.UI.ClientUI;

import com.APP.Controller.Client.Controller_ClientRegister;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**
 * @ author Fei Gu
 * @ create 2021-05-04-14.40
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description
 * @ Version
 */
public class UI_ClientRegister {

    public static Stage clientRegisterPage(Stage stage){

        Label new_client_register = new Label("New Client Register");
        new_client_register.setStyle("-fx-font-size: 20");

        Label name = new Label("Your name : ");
        name.setFont(Font.font(16));

        TextField userName = new TextField();
        userName.setPromptText("Please input your full name");
        userName.setTooltip(new Tooltip("Please input your full name"));
        userName.textProperty().addListener(new Controller_ClientRegister().clientRegisterText());
        userName.setPrefSize(300.0,10.0);

        Label address = new Label("Your address : ");
        address.setFont(Font.font(16));

        TextField userAddress = new TextField();
        userAddress.setPromptText("Street,number,zipcode,city,country..");
        userAddress.setTooltip(new Tooltip("Street,number,zipcode,city,country.."));
        userAddress.setPrefSize(300.0,10.0);

        Label email = new Label("Your email : ");
        email.setFont(Font.font(16));

        TextField userEmail = new TextField();
        userEmail.setPromptText("email@mail.com");
        userEmail.setTooltip(new Tooltip("email@mail.com"));

        Label phoneNo = new Label("Your phone number : ");
        phoneNo.setFont(Font.font(16));

        TextField userPhoneNo = new TextField();

        userPhoneNo.setPromptText("xxxx-xxxxxxxx");
        userPhoneNo.setTooltip(new Tooltip("xxxx-xxxxxxxx"));

        Label label = new Label("I am realy tired to make more.... sorry ~~");
        label.setFont(Font.font(18));


        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-background-color: lightgray");

        gridPane.add(new_client_register,0,0);
        gridPane.add(name,0,1);
        gridPane.add(userName,1,1);
        gridPane.add(address,0,2);
        gridPane.add(userAddress,1,2);

        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(gridPane, 600, 800);
        stage.setScene(scene);
        return stage;
    }
}
