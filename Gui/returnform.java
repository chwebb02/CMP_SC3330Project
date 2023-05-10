package Gui;

import java.io.IOException;
import People.Member;

import Collections.LibraryCollection;
import People.Person;
import Utils.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class returnform {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField mediaID;

    @FXML
    private Label displayLabel;

    @FXML
    void exitPressedCheckout(ActionEvent event) {
        goHome(event);
    }

    @FXML
    void returnToCollection(ActionEvent event) {
        if (mediaID.getText().length() != 6) {
            displayLabel.setText("Please enter a 6 digit ISBN or ISSN");
            return;
        }

        LibraryCollection query = LibraryCollection.getMedia(mediaID.getText());

        if (query == null) {
            displayLabel.setText("Media is not owned by library!");
            return;
        }

        if (!query.isCheckedOut()) {
            displayLabel.setText("Media was not checked out!");
        } else {
            query.returnToCollection();
            displayLabel.setText("Media was successfully returned!");
        }
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
