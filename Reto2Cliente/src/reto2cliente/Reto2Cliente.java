package reto2cliente;

import controller.ControllerSignIn;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

/**
 *
 * @author David
 */
public class Reto2Cliente extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
           // System.out.println(greeting);
         FXMLLoader loader=new FXMLLoader(
                    getClass().getResource("/view/signIn.fxml"));
            Parent root = (Parent)loader.load();
            //Get controller for graph 
            ControllerSignIn viewController=
                    ((ControllerSignIn)loader.getController());
            //Set greeting to be used in JavaFX view controller
            viewController.setStage(primaryStage);
            viewController.initStage(root);
        } catch (IOException ex) {
            Logger.getLogger(Reto2Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
