package Gui;

import java.io.IOException;

import Collections.LibraryCollection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class removeFromCollection {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label displayLabel;

    @FXML
    private Button removeButton;

    @FXML
    private TextField mediaID;

    @FXML
    void removePressed(ActionEvent event) {
        if (mediaID.getText().length() != 6) {
            displayLabel.setText("Please enter a 6-digit ISBN or ISSN");
            return;
        }

        if (LibraryCollection.removeFromCollection(mediaID.getText())) {
            displayLabel.setText("Successfully removed!");
        } else {
            displayLabel.setText("That item does not exist in collection!");
        }
    }

    @FXML
    void exitPressed(ActionEvent event) {
        goHome(event);
    }

    private void goHome(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("main.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException error) {
            System.exit(0);
        }
    }

}
