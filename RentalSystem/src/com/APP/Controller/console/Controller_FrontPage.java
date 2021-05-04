package com.APP.Controller.console;

import com.UI.ClientUI.UI_ClientFrontPage;
import com.UI.consoleUI.UI_FrontPage;
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
    public EventHandler<MouseEvent> gotoClientFrontPage(Stage stage){
        EventHandler<MouseEvent> gotoClientFrontPage = event -> UI_ClientFrontPage.clientFrontPage(stage);
        return gotoClientFrontPage;
    }

    public EventHandler<MouseEvent> gotoFrontPage(Stage stage){
        EventHandler<MouseEvent> gotoFrontPage = event -> UI_FrontPage.showFrontPage(stage);
        return gotoFrontPage;
    }


}
