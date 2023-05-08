package Gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import People.Person;
import Utils.Email;
import Utils.Login;
import Utils.SSN;

public class editinformationform {
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
    private TextField nameBox;

    @FXML
    private TextField nameBox1;

    @FXML
    private PasswordField passwordBox;

    @FXML
    private PasswordField passwordBox1;

    @FXML
    private TextField ssnBox;

    @FXML
    private void exitPressed(ActionEvent event) {
        goHome(event);
    }

    // Confirm button
    @FXML
    private void savePressed(ActionEvent event) {
        Login attempt = new Login(nameBox1.toString(), passwordBox1.toString());
        boolean canDo = Person.login(attempt);

        if (!canDo) {
            return;
        } else {
            Person session = Person.getPerson(attempt.getUsername());
            Login newLogin = new Login(nameBox.toString(), passwordBox.toString());
            
            session.setName(newLogin.getUsername());
            session.setLogin(newLogin);
            session.setAddress(addressBox.toString());
            session.setEmail(new Email(emailBox.toString()));
            session.setSsn(new SSN(ssnBox.toString()));
            session.setDob(dobBox.getValue());

            exitPressed(event);
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
