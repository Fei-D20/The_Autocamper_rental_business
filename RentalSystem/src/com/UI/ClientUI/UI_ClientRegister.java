package com.UI.ClientUI;

import com.APP.Controller.Client.Controller_ClientRegister;
import com.Module.Register.RegisterClient;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
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

        Label l_registerPageTitle = new Label("New Client Register");
        l_registerPageTitle.setStyle("-fx-font-size: 20");

        Label l_name = new Label("Your name : ");
        l_name.setFont(Font.font(16));

        TextField tf_name = new TextField();
        tf_name.setPromptText("Please input your full name");
        tf_name.setTooltip(new Tooltip("Please input your full name"));
        tf_name.setPrefSize(300.0,10.0);
        tf_name.textProperty().addListener(new Controller_ClientRegister().clientRegisterName());

        Label l_password = new Label("Your password :  ");
        l_password.setFont(Font.font(16));

        PasswordField pf_passwordField = new PasswordField();
        pf_passwordField.setPromptText("Please input password");
        pf_passwordField.setTooltip(new Tooltip("Please input password"));
        pf_passwordField.setPrefSize(300.0,10.0);
        pf_passwordField.textProperty().addListener(new Controller_ClientRegister().clientRegisterPassWord());



        Label l_address = new Label("Your address : ");
        l_address.setFont(Font.font(16));

        TextField tf_address = new TextField();
        tf_address.setPromptText("Street,number,zipcode,city,country..");
        tf_address.setTooltip(new Tooltip("Street,number,zipcode,city,country.."));
        tf_address.setPrefSize(300.0,10.0);
        tf_address.textProperty().addListener(new Controller_ClientRegister().clientRegisterAddress());

        Label l_email = new Label("Your email : ");
        l_email.setFont(Font.font(16));

        TextField tf_email = new TextField();
        tf_email.setPromptText("email@mail.com");
        tf_email.setTooltip(new Tooltip("email@mail.com"));
        tf_email.textProperty().addListener(new Controller_ClientRegister().clientRegisterEmail());


        Label l_phoneNo = new Label("Your phone number : ");
        l_phoneNo.setFont(Font.font(16));

        TextField tf_phoneNo = new TextField();

        tf_phoneNo.setPromptText("xxxx-xxxxxxxx");
        tf_phoneNo.setTooltip(new Tooltip("xxxx-xxxxxxxx"));
        tf_phoneNo.textProperty().addListener(new Controller_ClientRegister().clientRegisterPhoneNo());




        Button register = new Button("Register");
        register.addEventHandler(MouseEvent.MOUSE_CLICKED,new Controller_ClientRegister().ClientRegister(RegisterClient.getNewClient()));

        Button go_back = new Button("Go back");


        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-background-color: lightgray");

        gridPane.add(l_registerPageTitle,0,0);

        gridPane.add(l_name,0,1);
        gridPane.add(tf_name,1,1);

        gridPane.add(l_password,0,2);
        gridPane.add(pf_passwordField,1,2);

        gridPane.add(l_address,0,3);
        gridPane.add(tf_address,1,3);

        gridPane.add(l_email,0,4);
        gridPane.add(tf_email,1,4);

        gridPane.add(l_phoneNo,0,5);
        gridPane.add(tf_phoneNo,1,5);


        gridPane.add(register,0,10);
        gridPane.add(go_back,1,10);






        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(gridPane, 600, 800);
        stage.setScene(scene);
        return stage;
    }
}
