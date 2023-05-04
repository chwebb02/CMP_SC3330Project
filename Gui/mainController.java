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
    private FXMLLoader load;

    @FXML
    void borrowItemPressed(ActionEvent event) {

    }

    @FXML
    void checkOverduePressed(ActionEvent event) {

    }

    @FXML
    void editInfoPressed(ActionEvent event) {

    }

    @FXML
    void newCollectionPressed(ActionEvent event) {
        try {
            load = new FXMLLoader();
            root = load.load(getClass().getResource("newcollectionform.fxml"));
            load.setClassLoader(getClass().getClassLoader());
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException error) {
            System.exit(0);
        }
    }

    @FXML
    void newEmployeePressed(ActionEvent event) {

    }

    @FXML
    void newMemberPressed(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("newmemberform.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException error) {
            System.exit(0);
        }
    }

    @FXML
    void quitPressed(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void removeItemPressed(ActionEvent event) {

    }

    @FXML
    void removeMemberPressed(ActionEvent event) {

    }

    @FXML
    void returnItemPressed(ActionEvent event) {

    }

}
