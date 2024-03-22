package pk.calendar;


import org.pmw.tinylog.Configurator;
import org.pmw.tinylog.Level;
import org.pmw.tinylog.writers.FileWriter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pk.calendar.controllers.CallendarController;
import pk.calendar.models.data.Settings;

/**
 * Calendar apllication using JavaFX.
 *
 * @author Lukasz Golebiewski 203882 github.com/glbwsk
 * @author Jakub Mielczarek 203943
 */
public class CalendarApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/fxml/MainView.fxml"));
        BorderPane root = loader.load();

        Scene scene = new Scene(root, Settings.getData().winWidth,
                Settings.getData().winHeigth);

        stage.setScene(scene);
        stage.setTitle("Calendar");
        stage.getIcons().add(new Image("/assets/calendar-icon.png"));

        CallendarController cc = loader.getController();
        cc.initStageActions(stage);

        stage.show();

        Configurator.defaultConfig().writer(new FileWriter("log.txt")).level(Level.TRACE).activate();
    }
}
