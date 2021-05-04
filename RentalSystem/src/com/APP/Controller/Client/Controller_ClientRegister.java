package com.APP.Controller.Client;

import com.UI.ClientUI.UI_ClientRegister;
import javafx.event.Event;
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
    public EventHandler<MouseEvent> clientRegister(Stage stage){
        EventHandler<MouseEvent> mouseEventEventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                UI_ClientRegister ui_clientRegister = new UI_ClientRegister();
                ui_clientRegister.ClientRegisterPage(stage);
            }

        };
        return mouseEventEventHandler;
    }
}
