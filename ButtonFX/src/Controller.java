import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public Button clickMeButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clickMeButton.setOnAction(event -> System.out.println("You clicked me!"));
    }
}
