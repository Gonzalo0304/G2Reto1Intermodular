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

    /**
     * Inicializa la ventana del perfil con la escena especificada.
     * Configura el botón para cerrar sesión y muestra el nombre de usuario.
     *
     * @param root La raíz de la escena a mostrar en la ventana del perfil.
     */
    public void inicializarVentana(Parent root) {
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        lblUsuario.setText(nombre);
        stage.show();

        btnCerrarSesion.setOnAction(this::handleLogOut);
        lblUsuario.setText(nombre);

    }

    /**
      * Maneja el evento de cierre de sesión. Carga la ventana de inicio de sesión.
     *
     * @param actionEvent El evento de clic en el botón de cerrar sesión.
     */
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

    /**
      * Establece el escenario y el nombre de usuario que inicia sesion en la ventana de perfil.
     *
     * @param stage El escenario de la ventana del perfil.
     * @param nombre El nombre de usuario a mostrar en la ventana.
     */
    public void setStage(Stage stage, String nombre) {
        this.stage = stage;
        this.nombre = nombre;
    }

}
