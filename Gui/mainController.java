package Gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class mainController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void borrowItemPressed(ActionEvent event)  throws IOException {
        changeTo(event, "newmemberform.fxml");
    }

    @FXML
    void checkOverduePressed(ActionEvent event)  throws IOException {
        changeTo(event, "newmemberform.fxml");
    }

    @FXML
    void editInfoPressed(ActionEvent event)  throws IOException {
        changeTo(event, "newmemberform.fxml");
    }

    @FXML
    void newCollectionPressed(ActionEvent event)  throws IOException {
        changeTo(event, "newmemberform.fxml");
    }

    @FXML
    void newEmployeePressed(ActionEvent event)  throws IOException {
        changeTo(event, "newmemberform.fxml");
    }

    @FXML
    void newMemberPressed(ActionEvent event) throws IOException {
        changeTo(event, "newmemberform.fxml");
    }

    @FXML
    void quitPressed(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void removeItemPressed(ActionEvent event)  throws IOException {
        changeTo(event, "newmemberform.fxml");
    }

    @FXML
    void removeMemberPressed(ActionEvent event)  throws IOException {
        changeTo(event, "newmemberform.fxml");
    }

    @FXML
    void returnItemPressed(ActionEvent event)  throws IOException {
        changeTo(event, "newmemberform.fxml");
    }

    private void changeTo(ActionEvent event, String fname) throws IOException {
        root = FXMLLoader.load(getClass().getResource(fname));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
