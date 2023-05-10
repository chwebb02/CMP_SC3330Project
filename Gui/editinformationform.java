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
    void exitPressedEdit(ActionEvent event) {
        goHome(event);
    }

    @FXML
    void confirmEditPressed(ActionEvent event) {
        Login attempt = new Login(nameBox1.getText(), passwordBox1.getText());
        boolean canDo = Person.login(attempt);

        if (!canDo) {
            // Make this display on GUI if I have time
            System.out.println("Unable to change info (invalid login)!");
            return;
        } else {
            Person session = Person.getPerson(attempt.getUsername());
            Login newLogin = new Login(nameBox.getText(), passwordBox.getText());
            
            session.setName(newLogin.getUsername());
            session.setLogin(newLogin);
            session.setAddress(addressBox.getText());
            session.setEmail(new Email(emailBox.getText()));
            session.setSsn(new SSN(ssnBox.getText()));
            session.setDob(dobBox.getValue());

            System.out.println("Changed! Data: " + session + "\n\n");
            exitPressedEdit(event);
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
