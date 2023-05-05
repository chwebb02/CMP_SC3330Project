import Gui.mainController;
import Gui.newmemberform;
import Gui.EditInformation;
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
        loader.setLocation(getClass().getResource("./gui/main.fxml"));

        loader.setClassLoader(getClass().getClassLoader());

        Parent root = loader.load();

        Scene scene = new Scene(root);
        stage.setTitle("Library GUI");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}