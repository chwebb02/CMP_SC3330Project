package Gui;

import java.io.IOException;
import Collections.LibraryCollection;
import People.Member;
import Utils.CheckedOutMedia;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.util.ArrayList;

public class CheckOverdue {
    @FXML
    private TextField isbnField;
    @FXML
    private Label statusLabel;

    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<LibraryCollection> collections = new ArrayList<>();
    private ArrayList<CheckedOutMedia> checkedOut = new ArrayList<>();

    public void initialize() {
        // Initialize data here
    }

    @FXML
    private void checkStatus() {
        String isbn = isbnField.getText();

        // Find the LibraryCollection by ISBN
        LibraryCollection collection = null;
        for (LibraryCollection c : collections) {
            if (c.getISBN().equals(isbn)) {
                collection = c;
                break;
            }
        }

        if (collection == null) {
            // Collection not found
            statusLabel.setText("Book not found");
            return;
        }

        // Find the CheckedOutMedia for this collection, if any
        CheckedOutMedia checkedOutMedia = null;
        for (CheckedOutMedia c : checkedOut) {
            if (c.getCheckedOutMedia() == collection) {
                checkedOutMedia = c;
                break;
            }
        }

        if (checkedOutMedia == null) {
            // Book not checked out
            statusLabel.setText("Book is available");
        } else {
            // Book is checked out, check if it's overdue
            if (checkedOutMedia.isLate()) {
                statusLabel.setText("Book is overdue!");
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Overdue Book");
                alert.setHeaderText("This book is overdue");
                alert.setContentText("Please return this book as soon as possible.");
                alert.showAndWait();
            } else {
                statusLabel.setText("Book is checked out, but not overdue");
            }
        }
    }
}
