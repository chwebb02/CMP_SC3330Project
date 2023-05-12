package Gui;

import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedList;

import People.Member;

import Collections.LibraryCollection;
import People.Person;
import Utils.CheckedOutMedia;
import Utils.Login;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class CheckOverdue {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextArea display;

    @FXML
    void update(ActionEvent event) {
        display.textProperty().addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
                display.setScrollTop(Double.MAX_VALUE);
            }
        });

        display.appendText("\n\nOVERDUE MEDIA:\n");
        LinkedList<CheckedOutMedia> overdueMedia = LibraryCollection.getOverdueList();
        if (overdueMedia.size() == 0) {
            display.appendText("NONE!");
        }

        for (CheckedOutMedia com : overdueMedia) {
            String id = new String(com.getCheckedOutMedia().getID());
            display.appendText(com.getOwner().getName() + "\n\tID: " + id + "\n");
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
 