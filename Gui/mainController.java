package Gui;

import java.io.IOException;

import Collections.LibraryCollection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class mainController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void borrowItemPressed(ActionEvent event)  throws IOException {
        changeTo(event, "checkoutform.fxml");
    }

    @FXML
    void checkOverduePressed(ActionEvent event)  throws IOException {
        changeTo(event, "CheckOverdue.fxml");
    }

    @FXML
    void editInfoPressed(ActionEvent event)  throws IOException {
        changeTo(event, "editinformationform.fxml");
    }

    @FXML
    void newCollectionPressed(ActionEvent event)  throws IOException {
        changeTo(event, "addmediaform.fxml");
    }

    @FXML
    void newEmployeePressed(ActionEvent event)  throws IOException {
        changeTo(event, "newemployeeform.fxml");
    }

    @FXML
    void newMemberPressed(ActionEvent event) throws IOException {
        changeTo(event, "newmemberform.fxml");
    }

    @FXML
    void quitPressed(ActionEvent event) {
        LibraryCollection.save();
        // Person.save();                   This needs to be implemented

        System.exit(0);
    }

    @FXML
    void removeItemPressed(ActionEvent event)  throws IOException {
        changeTo(event, "removeFromCollection.fxml");
    }

    @FXML
    void removeMemberPressed(ActionEvent event)  throws IOException {
        changeTo(event, "removemembership.fxml");
    }

    @FXML
    void returnItemPressed(ActionEvent event)  throws IOException {
        changeTo(event, "returnform.fxml");
    }

    private void changeTo(ActionEvent event, String fname) throws IOException {    
        root = FXMLLoader.load(getClass().getResource(fname));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
