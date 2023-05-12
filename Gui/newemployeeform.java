package Gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import People.Employee;
import People.Librarian;
import People.Technician;
import Utils.Login;
import Utils.SSN;
import Utils.Email;


public class newemployeeform {

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
    private ToggleGroup employee;

    @FXML
    private TextField nameBox;

    @FXML
    private TextField ssnBox;

    @FXML
    private PasswordField passwordBox;
    
    @FXML
    private void exitPressed(ActionEvent event) {
        goHome(event);
    }

    // Handles saving the form
    @FXML
    private void savePressed(ActionEvent event) {
        RadioButton selectedRadioButton = (RadioButton) employee.getSelectedToggle();
        String value = selectedRadioButton.getText();
        Login login = new Login(nameBox.getText(), passwordBox.getText());
        SSN ssn = new SSN(ssnBox.getText());
        Email email = new Email(emailBox.getText());

        Employee emp;
        switch (value) {
            case ("Librarian"):
                emp = (Employee) new Librarian(nameBox.getText(), addressBox.getText(), email, login, dobBox.getValue(), ssn);
                break;
            case ("Technician"):
                emp = (Employee) new Technician(nameBox.getText(), addressBox.getText(), email, login, dobBox.getValue(), ssn);
                break;
            default:
                return;
        }

        System.out.println(emp.toString());
        goHome(event);
    }

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
