package controller;

import clases.Mensaje;
import clases.Usuario;
import excepciones.CredentialsException;
import excepciones.InvalidEmailFormatException;
import excepciones.InvalidPassFormatException;
import excepciones.NotCompleteExceptionException;
import excepciones.ServerErrorException;
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
import model.Factoria;
import model.Implementacion;
import sockets.ClienteSocket;

/**
 * Controlador para la ventana de inicio de sesión. Permite a los usuarios
 * iniciar sesión, registrarse y realizar otras operaciones relacionadas.
 *
 * Esta ventana muestra un formulario de inicio de sesión donde los usuarios
 * pueden introducir sus credenciales (Email y Contraseña). Cuando se validan
 * los datos, el usuario accede a la ventana de Profile. También proporciona un
 * enlace para acceder a la ventana de registro.
 *
 * Comportamiento: - Inicialización: La ventana se inicializa con las siguientes
 * configuraciones. - Iniciar Sesión: Permite al usuario iniciar sesión después
 * de validar los campos de entrada. - Mostrar/Ocultar Contraseña: Permite al
 * usuario mostrar u ocultar la contraseña. - Registrarse: Permite al usuario
 * acceder a la ventana de registro.
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

    /**
     * Inicializa la ventana de inicio de sesión con las configuraciones
     * iniciales.
     *
     * - Muestra la ventana en modal. - La ventana no es redimensionable. -
     * Establece el foco en el campo de correo electrónico (txtFieldEmail). - El
     * botón por defecto es el botón de Iniciar sesión (btnIniciarSesion). -
     * Establece el título de la ventana como "Sign In".
     *
     * @param root La raíz de la escena a mostrar en la ventana de inicio de
     * sesión.
     */
    public void initStage(Parent root) {
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
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

    /**
     * Establece el escenario para el controlador.
     *
     * @param stage El escenario de la ventana de inicio de sesión.
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    // Comentarios para otros métodos y eventos...
    /**
     * Maneja el evento de inicio de sesión.
     *
     * @param actionEvent El evento de clic en el botón de inicio de sesión.
     */
    @FXML
    public void handleSignIn(ActionEvent actionEvent) {
        if (tbMostrarPass.isSelected()) {
            passField.setText(txtFieldPass.getText());
        }
        String pass = passField.getText();
        String texto = txtFieldEmail.getText();
        ClienteSocket csk = new ClienteSocket();
        try {
            if (checkCompleteFileds(pass, texto)) {
                if (!checkValidEmail(texto)) {
                    if (!checkValidPass(pass)) {

                        Factoria fac = new Factoria();
                        Implementacion imp = (Implementacion) fac.getInterfaz();

                        Usuario us = new Usuario();
                        us.setEmail(texto);
                        us.setPass(pass);

                        Mensaje msj2 = imp.signIn(us);

                        switch (msj2.getMessageEnum()) {
                            case OK:
                                openProfile(txtFieldEmail.getText());
                                break;
                            case ERRORSIGNIN:
                                throw new CredentialsException("Las credenciales no coinciden.");
                            case ERRORSERVER:
                                throw new ServerErrorException("Error del server.");
                            case MAXUSERS:
                                Alert alert4 = new Alert(Alert.AlertType.ERROR, "Error de servidor: \n Maximo de usuarios en servidor intentelo mas tarde", ButtonType.OK);
                                alert4.setHeaderText(null);
                                alert4.show();
                                throw new ServerErrorException("Numero maximo de usuarios en el servidor");

                        }
                    } else {
                        throw new InvalidPassFormatException("Error de inicio de sesión: \nPorfavor introduzca las credenciales correctamente");
                    }

                } else {
                    throw new InvalidEmailFormatException("Error de inicio de sesión: \nPorfavor introduzca las credenciales correctamente");
                }

            } else {
                throw new NotCompleteExceptionException("Error: \nLos campos no están informados");

            }
        } catch (NotCompleteExceptionException ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
            alerta.setHeaderText(null);
            alerta.show();
        } catch (InvalidEmailFormatException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
            alert.setHeaderText(null);
            alert.show();
        } catch (InvalidPassFormatException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
            alert.setHeaderText(null);
            alert.show();
        } catch (ServerErrorException ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
            alerta.setHeaderText(null);
            alerta.show();
            Logger.getLogger(ControllerSignIn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CredentialsException ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
            alerta.setHeaderText(null);
            alerta.show();
            Logger.getLogger(ControllerSignIn.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Abrir la ventana signUp y cerrar la ventana signIn.
     *
     * @param actionEvent El evento de acción.
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
     *
     * @param actionEvent
     */
    @FXML
    public void handleShowPass(ActionEvent actionEvent) {
        //Si el togglebutton no está pulsado y se pulsa:
        if (tbMostrarPass.isSelected()) {
            //Obtener el texto del password field (passField) escrito por el usuario y  pasarlo al textfield (txtFieldPass)
            txtFieldPass.setText(passField.getText());
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
            passField.setText(txtFieldPass.getText());
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
     * Método que solicita confirmación antes de cerrar la ventana cuando se
     * pulsa la x de la parte superior derecha.
     *
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

    /**
     * Verifica si el formato del correo electrónico es válido.
     *
     * @param texto El correo electrónico a verificar.
     * @return true si el formato es válido, false en caso contrario.
     * @throws InvalidEmailFormat Si el formato del correo electrónico es
     * inválido.
     */
    private boolean checkValidEmail(String texto) throws InvalidEmailFormatException {
        boolean emailBien = false;
        Pattern pattern1 = Pattern.compile("^[a-zA-Z0-9._]{3,}+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}$");

        Matcher matcher = pattern1.matcher(texto);
        if (matcher.find() == false) {
            emailBien = true;
        }
        return emailBien;

    }

    /**
     * Verifica si la contraseña cumple con los requisitos de longitud mínima.
     *
     * @param pass La contraseña a verificar.
     * @return true si la longitud es válida, false en caso contrario.
     */
    private boolean checkValidPass(String pass) {
        boolean passBien = false;
        if (pass.length() < 8) {
            passBien = true;
        }
        return passBien;
    }

    /**
     * Verifica si los campos de correo electrónico y contraseña están
     * completos.
     *
     * @param pass La contraseña ingresada.
     * @param texto El correo electrónico ingresado.
     * @return true si ambos campos están completos, false en caso contrario.
     */
    private boolean checkCompleteFileds(String pass, String texto) {
        return !texto.isEmpty() && !pass.isEmpty();
    }

    /**
     * Abre la ventana de perfil con el nombre de usuario proporcionado.
     *
     * @param nombre El nombre de usuario.
     */
    private void openProfile(String nombre) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/profile.fxml"));

            Parent root = loader.load();

            ControllerProfile viewController = ((ControllerProfile) loader.getController());
            viewController.setStage(stage, nombre);
            viewController.inicializarVentana(root);
        } catch (IOException ex) {
            Logger.getLogger(ControllerSignIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}