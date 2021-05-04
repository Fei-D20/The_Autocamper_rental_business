package com.APP.Controller.Client;

import com.Domain.User.Client;
import com.UI.ClientUI.UI_ClientRegister;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * @ author Fei Gu
 * @ create 2021-05-04-14.34
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description
 * @ Version
 */
public class Controller_ClientRegister {
    Client newRegisterClient;

    public EventHandler<MouseEvent> clientRegister(Stage stage){
        EventHandler<MouseEvent> mouseEventEventHandler = event -> UI_ClientRegister.clientRegisterPage(stage);
        newRegisterClient = new Client();

        return mouseEventEventHandler;
    }

    public ChangeListener<String> clientRegisterText(){
        ChangeListener<String> changeListener = (observable, oldValue, newValue) -> {
            System.out.println(newValue);
        };
        return changeListener;
    }
}
