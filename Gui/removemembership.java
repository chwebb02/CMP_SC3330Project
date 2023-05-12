package Gui;

import java.io.IOException;

import Collections.LibraryCollection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import People.Person;


public class removemembership {

    @FXML
    private TextField nameBox;
    @FXML
    private PasswordField passwordBox;
    @FXML
    private TextField emailBox;

    @FXML
    private void cancelPressed(ActionEvent event) {
        goHome(event);
    }    

    @FXML
    private void removePressed(ActionEvent event) {
        boolean removed = Person.removePerson(nameBox.getText());
        if (removed)
            System.out.println(nameBox.getText() + " was deleted");
        else
            System.out.println(nameBox.getText() + " wasn't a User");
    }


    private Stage stage;
    private Scene scene;
    private Parent root;
    
    //Function changes scene to menu
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
