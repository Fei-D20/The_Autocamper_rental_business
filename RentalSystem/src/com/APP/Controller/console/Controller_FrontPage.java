package com.APP.Controller.console;

import com.UI.ClientUI.UI_ClientFrontPage;
import com.UI.consoleUI.UI_FrontPage;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * @ author Andrej Simionenko, Raheela Tasneem, Fei Gu
 * @ create 2021-05-04-10.41
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description this is the controller for from front page to next page and go back
 * @ Version
 */
public class Controller_FrontPage {

    /**
     * this is the event by front page user button
     *
     * @return
     */
    public EventHandler<MouseEvent> gotoClientFrontPage(Pane pane) {
        EventHandler<MouseEvent> gotoClientFrontPage = event -> {
            pane.getChildren().setAll(UI_ClientFrontPage.clientFrontPage(pane));
        };
        return gotoClientFrontPage;
    }

    public EventHandler<MouseEvent> gotoFrontPage(Pane pane) {
        EventHandler<MouseEvent> gotoFrontPage = event -> pane.getChildren().setAll(UI_FrontPage.showFrontPage(pane));
        return gotoFrontPage;
    }


}
