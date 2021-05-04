package com.UI;/**
 * @ author Fei Gu
 * @ create 2021-05-04-22.07
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description
 * @ Version
 */

import com.UI.consoleUI.UI_FrontPage;
import javafx.application.Application;
import javafx.stage.Stage;

public class ApplicationMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        UI_FrontPage.showFrontPage(primaryStage).show();
    }
}
