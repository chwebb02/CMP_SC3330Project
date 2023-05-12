import Gui.mainController;
import Gui.newmemberform;
import Gui.editinformationform;
import Gui.returnform;
import Gui.addmediaform;
import Gui.removeFromCollection;

import java.nio.file.Path;

import Collections.Book;
import Collections.LibraryCollection;
import Collections.LibraryCollection.SectionCode;
import People.Person;
import Gui.checkoutform;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUIExample extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("./Gui/main.fxml"));

        loader.setClassLoader(getClass().getClassLoader());

        Parent root = loader.load();

        Scene scene = new Scene(root);
        stage.setTitle("Library GUI");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        LibraryCollection.load();
        // Need a peopleDB loader

        launch(args);
    }
}