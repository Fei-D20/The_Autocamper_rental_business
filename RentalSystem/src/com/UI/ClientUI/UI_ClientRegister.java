package com.UI.ClientUI;

import com.APP.Controller.Client.Controller_ClientRegister;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
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
        tf_name.textProperty().addListener(new Controller_ClientRegister().clientRegisterText());
        tf_name.setPrefSize(300.0,10.0);

        Label l_address = new Label("Your address : ");
        l_address.setFont(Font.font(16));

        TextField tf_address = new TextField();
        tf_address.setPromptText("Street,number,zipcode,city,country..");
        tf_address.setTooltip(new Tooltip("Street,number,zipcode,city,country.."));
        tf_address.setPrefSize(300.0,10.0);

        Label l_email = new Label("Your email : ");
        l_email.setFont(Font.font(16));

        TextField tf_email = new TextField();
        tf_email.setPromptText("email@mail.com");
        tf_email.setTooltip(new Tooltip("email@mail.com"));

        Label l_phoneNo = new Label("Your phone number : ");
        l_phoneNo.setFont(Font.font(16));

        TextField tf_phoneNo = new TextField();

        tf_phoneNo.setPromptText("xxxx-xxxxxxxx");
        tf_phoneNo.setTooltip(new Tooltip("xxxx-xxxxxxxx"));

        Label l_driveLicenseNo = new Label("Drive License no. : ");
        l_driveLicenseNo.setFont(Font.font(16));

        TextField tf_driveLicenseNo = new TextField();

        Label l_driveFullDrivingLicenseStatue = new Label("Full driving license : ");
        l_driveFullDrivingLicenseStatue.setFont(Font.font(16));
        Text t_driveFullDrivingLicenseStatue = new Text();
        String s_fullDrivingLicenseExp = "Do you have been held the driving\n license in your country of domicile\n for at least 12 month?";
        t_driveFullDrivingLicenseStatue.setText(s_fullDrivingLicenseExp);

        TextField tf_driveFullDrivingLicenseStatue = new TextField();


        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-background-color: lightgray");

        gridPane.add(l_registerPageTitle,0,0);

        gridPane.add(l_name,0,1);
        gridPane.add(tf_name,1,1);

        gridPane.add(l_address,0,2);
        gridPane.add(tf_address,1,2);

        gridPane.add(l_email,0,3);
        gridPane.add(tf_email,1,3);

        gridPane.add(l_phoneNo,0,4);
        gridPane.add(tf_phoneNo,1,4);

        gridPane.add(l_driveLicenseNo,0,5);
        gridPane.add(tf_driveLicenseNo,1,5);

        gridPane.add(l_driveFullDrivingLicenseStatue,0,6);
        gridPane.add(tf_driveFullDrivingLicenseStatue,1,6);

        gridPane.add(t_driveFullDrivingLicenseStatue,1,7);






        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(gridPane, 600, 800);
        stage.setScene(scene);
        return stage;
    }
}
