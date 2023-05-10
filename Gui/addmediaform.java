package Gui;

import java.io.IOException;

import Collections.Book;
import Collections.DVD;
import Collections.Journal;
import Collections.Newspaper;
import Collections.LibraryCollection.SectionCode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class addmediaform {
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private TextField mediaID;

    @FXML
    private ToggleGroup mediaType;

    @FXML
    private ToggleGroup sectionCode;

    @FXML
    private Label displayLabel;

    @FXML
    private TextField priceString;

    @FXML
    void addToCollection(ActionEvent event) {
        if (mediaID.getText().length() != 6) {
            displayLabel.setText("Please enter a 6 digit ISBN or ISSN");
            return ;
        }

        String sectionString = ((RadioButton) sectionCode.getSelectedToggle()).getText();
        String typeString = ((RadioButton) mediaType.getSelectedToggle()).getText();

        SectionCode code = SectionCode.ARTS;
        switch (sectionString) {
            case "ARTS":
                code = SectionCode.ARTS;
                break;
            case "SCIENCE":
                code = SectionCode.SCIENCES;
                break;
            case "NEWSPAPER":
                code = SectionCode.NEWSPAPER;
                break;
            case "LAW":
                code = SectionCode.LAW;
                break;
            default:
                System.err.println("You should not be seeing this!");
        }

        float price;
        try {
            price = Float.parseFloat(priceString.getText());
        } catch (NumberFormatException e) {
            displayLabel.setText("Please enter a number for price!");
            return;
        }

        

        try {
            switch (typeString) {
                case "Book":
                    new Book(mediaID.getText().toCharArray(), code, price);
                    break;
                case "Journal":
                    new Journal(mediaID.getText().toCharArray(), code, price);
                    break;
                case "Newspaper":
                    new Newspaper(mediaID.getText().toCharArray(), code, price);
                    break;
                case "DVD":
                    new DVD(mediaID.getText().toCharArray(), code, price);
                    break;
                default:
                    System.err.println("You should not be seeing this either!");
            }

            displayLabel.setText("Added " + typeString + " #" + mediaID.getText());
        } catch (Exception e) {
            displayLabel.setText("Please enter a valid 6 digit ISBN or ISSN");
            return;
        }
    }

    @FXML
    void exitPressedCheckout(ActionEvent event) {
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
