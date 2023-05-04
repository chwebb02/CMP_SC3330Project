package Gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import People.Member;
import People.Student;
import People.Professor;
import People.External;
import Utils.Login;
import Utils.SSN;
import Utils.Email;

public class newmemberform {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField addressBox;

    @FXML
    private DatePicker dobBox;

    @FXML
    private TextField emailBox;

    @FXML
    private ToggleGroup member;

    @FXML
    private TextField nameBox;

    @FXML
    private TextField ssnBox;

    @FXML
    private TextField passwordBox;

    @FXML
    void exitPressed(ActionEvent event) {
        goHome(event);
    }

    // Handles the form
    @FXML
    void savePressed(ActionEvent event) {
        RadioButton selectedRadioButton = (RadioButton) member.getSelectedToggle();
        String value = selectedRadioButton.getText();
        Login login = new Login(nameBox.getText(), passwordBox.getText());
        SSN ssn = new SSN(ssnBox.getText());
        Email email = new Email(emailBox.getText());

        Member mem;
        switch (value) {
            case ("Student"):
                mem = (Member) new Student(nameBox.getText(), addressBox.getText(), email, login, dobBox.getValue(), ssn);
                break;
            case ("Professor"):
                mem = (Member) new Professor(nameBox.getText(), addressBox.getText(), email, login, dobBox.getValue(), ssn);
                break;
            case ("External"):
                mem = (Member) new External(nameBox.getText(), addressBox.getText(), email, login, dobBox.getValue(), ssn);
                break;
            default:
                return;
        }

        System.out.println(mem.toString());
        goHome(event);
    }

    // Function to change scene to menu
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