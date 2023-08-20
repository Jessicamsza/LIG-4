import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application{

    @Override
    public void start(Stage stage){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/telas/Menu.fxml"));

            Scene menu =  new Scene(root);
            stage.setResizable(false);
            
            stage.setScene(menu);
            stage.setTitle("LIG 4");
            Image icon = new Image("/design/img/icon-LIG4.png");
            stage.getIcons().add(icon);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        launch(args);
    }
}
