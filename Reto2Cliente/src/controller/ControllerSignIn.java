package controller;

import excepciones.invalidEmailFormat;
import excepciones.invalidPassFormat;
import excepciones.notCompleteException;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author David
 */
public class ControllerSignIn {

    private Stage stage;
    @FXML
    private Button btnIniciarSesion;
    @FXML
    private TextField txtFieldEmail;
    @FXML
    private PasswordField passField;
    @FXML
    private TextField txtFieldPass;
    @FXML
    private Hyperlink hplNoCuenta;
    @FXML
    private ToggleButton tbMostrarPass;
    @FXML
    private ImageView ivMostrarPass;

    public void initStage(Parent root) {
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        btnIniciarSesion.setDefaultButton(true);
        txtFieldPass.setFocusTraversable(false);

        //Método para preguntar antes de cerrar la ventana
        stage.setOnCloseRequest(this::handleCloseWindow);

        //Método para iniciar sesión
        btnIniciarSesion.setOnAction(this::handleSignIn);

        //Método para abrir el registrarse
        hplNoCuenta.setOnAction(this::handleOpenSignUp);

        //Método para mostrar y ocultar la contraseña
        tbMostrarPass.setOnAction(this::handleShowPass);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * 
     * @param actionEvent 
     */
    @FXML
    public void handleSignIn(ActionEvent actionEvent) {
        String pass = passField.getText();
        String texto = txtFieldEmail.getText();
        
        try {
            if (checkCompleteFileds(pass, texto)) {
                if(!checkValidEmail(texto)){
                    if(!checkValidPass(pass)){
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/profile.fxml"));

                            Parent root = loader.load();

                            ControllerProfile viewController = ((ControllerProfile) loader.getController());
                            viewController.setStage(stage);
                            viewController.inicializarVentana(root);
                        } catch (IOException ex) {
                            Logger.getLogger(ControllerSignIn.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else{
                        throw new invalidPassFormat("Error de inicio de sesión: \nPorfavor introduzca las credenciales correctamente");
                    }

                } else{
                    throw new invalidEmailFormat("Error de inicio de sesión: \nPorfavor introduzca las credenciales correctamente");
                }

            } else {
                throw new notCompleteException("Error: \nLos campos no están informados");

            }
        } catch (notCompleteException ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
            alerta.setHeaderText(null);
            alerta.show();  
        } catch (invalidEmailFormat ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
            alert.setHeaderText(null);
            alert.show();
        } catch (invalidPassFormat ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
            alert.setHeaderText(null);
            alert.show();
        }

    }

     /**
     * Abrir la ventana signUp y cerrar la ventana signIn.
     * @param actionEvent 
     */
    @FXML
    public void handleOpenSignUp(ActionEvent actionEvent) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/signUp.fxml"));

            Parent root = loader.load();

            ControllerSignUp viewController = ((ControllerSignUp) loader.getController());
            viewController.setStage(stage);
            viewController.initStage(root);

        } catch (IOException ex) {
            Logger.getLogger(ControllerSignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Método que oculta o muestra el contenido de la contraseña.
     * @param actionEvent 
     */
    @FXML
    public void handleShowPass(ActionEvent actionEvent) {
        //Si el togglebutton no está pulsado y se pulsa:
        if (tbMostrarPass.isSelected()) {
            //Obtener el texto del password field (passField) escrito por el usuario y  pasarlo al textfield (txtFieldPass)
            txtFieldPass.setText(passField.getText().toString());
            //que estaba oculto hasta la pulsación del Togglebutton
            txtFieldPass.setVisible(true);
            txtFieldPass.setFocusTraversable(true);
            //y ocultar el passField. 
            passField.setVisible(false);
            passField.setFocusTraversable(false);
            //Cambiar la imagen interior del togglebutton de ojoCerrado.png a ojoAbierto.png.
            Image imagen = new Image(getClass().getResource("/view/ojoAbierto.png").toExternalForm());
            ivMostrarPass.setImage(imagen);
        } else {
            //Si el togglebutton está pulsado y se pulsa,
            //Obtener el texto de textfield (txtFieldPass), pasarlo al password field (passField)
            passField.setText(txtFieldPass.getText().toString());
            //y hacerlo visible nuevamente.
            passField.setVisible(true);
            passField.setFocusTraversable(true);
            //Ocultar el txtFieldPass
            txtFieldPass.setVisible(false);
            txtFieldPass.setFocusTraversable(false);
            //y  cambiar la imagen interior del togglebutton de ojoAbierto.png a ojoCerrado.png.
            Image imagen = new Image(getClass().getResource("/view/ojoCerrado.png").toExternalForm());
            ivMostrarPass.setImage(imagen);
        }

    }

    /**
     * Método que solicita confirmación antes de cerrar la ventana cuando se pulsa la x de la parte superior derecha.
     * @param windowEvent 
     */
    @FXML
    public void handleCloseWindow(WindowEvent windowEvent) {
        windowEvent.consume();

        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION, "¿Quieres cerrar la ventana?");
        alerta.setHeaderText(null);

        Optional<ButtonType> accion = alerta.showAndWait();
        if (accion.get() == ButtonType.OK) {
            Platform.exit();
        }

    }
    
    private boolean checkValidEmail(String texto) /*throws InvalidEmailFormat*/ {
        boolean emailBien = false;
        Pattern pattern1 = Pattern.compile("^[a-zA-Z0-9.]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}$");
        Pattern pattern2 = Pattern.compile("^[a-zA-Z0-9._]{3,}+@(.+)$");

        Matcher matcher = pattern1.matcher(texto);
        if (matcher.find() == false) {
            matcher = pattern2.matcher(texto);
            if (matcher.find() == false) {
                emailBien=true;
            }
        }
        return emailBien;
    }

    private boolean checkValidPass(String pass) {
        boolean passBien = false;
        if(pass.length()<8){
            passBien=true;
        }
        return passBien;
    }

    private boolean checkCompleteFileds(String pass, String texto) {
        return !texto.isEmpty() && !pass.isEmpty();
    }
}

//final static Stack<Connection> = null;
