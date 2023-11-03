package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author Iñigo
 */
public class ControllerProfile {

    Stage stage;
    String nombre;

    @FXML
    private Button btnCerrarSesion;
    @FXML
    private Label lblUsuario;

    void inicializarVentana(Parent root) {
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        btnCerrarSesion.setOnAction(this::handleLogOut);
        lblUsuario.setText(nombre);

    }

    public void handleLogOut(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/signIn.fxml"));

            Parent root = loader.load();

            ControllerSignIn viewController = ((ControllerSignIn) loader.getController());
            viewController.setStage(stage);
            viewController.initStage(root);
        } catch (IOException ex) {
            Logger.getLogger(ControllerProfile.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void setStage(Stage stage, String nombre) {
        this.stage = stage;
        this.nombre = nombre;
    }

}
