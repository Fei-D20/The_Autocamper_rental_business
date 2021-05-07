package com.UI.consoleUI;
/**
 * @ author Andrej Simionenko, Raheela Tasneem, Fei Gu
 * @ create 2021-05-04-09.52
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description this is the front page about the application
 * @ Version
 */

import com.APP.Controller.console.Controller_FrontPage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;


public class UI_FrontPage {

    /**
     * this is show the front page
     * @param pane the root of Pane
     * @return new pane
     */
    public static Pane showFrontPage(Pane pane) {

        Label label = new Label("Please choose User Category : ");
        label.setLayoutX(200);
        label.setLayoutY(200);
        label.setPrefWidth(300);
        label.setPrefHeight(100);

        Button client = new Button(" Client ");
        client.setPrefHeight(50);
        client.setPrefWidth(200);
        client.setLayoutX(200);
        client.setLayoutY(300);

        client.addEventHandler(MouseEvent.MOUSE_CLICKED, new Controller_FrontPage().gotoClientFrontPage(pane));


        Button administrator = new Button(" Administrator ");
        administrator.setPrefHeight(50);
        administrator.setPrefWidth(200);
        administrator.setLayoutX(200);
        administrator.setLayoutY(400);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().setAll(label, client, administrator);


        return anchorPane;
    }
}
