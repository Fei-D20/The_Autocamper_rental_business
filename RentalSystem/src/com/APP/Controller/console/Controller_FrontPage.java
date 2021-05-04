package com.APP.Controller.console;

import com.UI.ClientUI.UI_ClientFrontPage;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * @ author Fei Gu
 * @ create 2021-05-04-10.41
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description
 * @ Version
 */
public class Controller_FrontPage {

    /**
     * this is the event by front page user button
     * @param stage the p
     * @return
     */
    public EventHandler<MouseEvent> ClientButton(Stage stage){
        EventHandler<MouseEvent> clientBank = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                UI_ClientFrontPage ui_clientFrontPage = new UI_ClientFrontPage();
                ui_clientFrontPage.clientFrontPage(stage);
            }
        };
        return clientBank;
    }


}
