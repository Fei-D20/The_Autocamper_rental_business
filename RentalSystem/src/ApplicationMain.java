/**
 * @ author Andrej Simionenko, Raheela Tasneem, Fei Gu
 * @ create 2021-05-04-22.07
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description This is the mean entry for the hole application.
 * @ Version
 */

import com.UI.consoleUI.UI_FrontPage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ApplicationMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Pane frontPage = UI_FrontPage.showFrontPage(pane);

        pane.getChildren().add(frontPage);
        Scene scene = new Scene(pane, 600, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Auto Camper Rent System ");
        primaryStage.show();
    }
}
