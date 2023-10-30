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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author David.
 */
public class ControllerSignUp {

    Stage stage;
    Image oAbierto = new Image(getClass().getResource("/view/ojoAbierto.png").toExternalForm());
    Image oCerrado = new Image(getClass().getResource("/view/ojoCerrado.png").toExternalForm());

    @FXML
    private Button btnRegistrarse;
    @FXML
    private ToggleButton tbMostrarPassR;
    @FXML
    private ToggleButton tbMostrarPassR1;
    @FXML
    private TextField txtFieldEmailR;
    @FXML
    private TextField txtFieldUsuarioR;
    @FXML
    private TextField txtFieldDireccion;
    @FXML
    private TextField txtFieldCodigoPostal;
    @FXML
    private TextField txtFieldTelefono;
    @FXML
    private PasswordField passFieldR;
    @FXML
    private PasswordField passFieldR1;
    @FXML
    private TextField txtFieldPassR;
    @FXML
    private TextField txtFieldPassR1;
    @FXML
    private ImageView ivMostrarPassR;
    @FXML
    private ImageView ivMostrarPassR1;
    @FXML
    private Hyperlink hyperLinkR;

    public void initStage(Parent root) {

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        txtFieldPassR.setFocusTraversable(false);
        txtFieldPassR1.setFocusTraversable(false);

        hyperLinkR.setOnAction(this::handleOpenLogIn);

        tbMostrarPassR.setOnAction(this::handleShowPassR);
        tbMostrarPassR1.setOnAction(this::handleShowPassR1);

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void signUp() {

    }

    public void handleOpenLogIn(ActionEvent actionEvent) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/signIn.fxml"));

            Parent root = loader.load();

            ControllerSignIn viewController = ((ControllerSignIn) loader.getController());
            viewController.setStage(stage);
            viewController.initStage(root);

        } catch (IOException ex) {
            Logger.getLogger(ControllerSignIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void handleShowPassR(ActionEvent actionEvent) {
        if (tbMostrarPassR.isSelected()) {
            txtFieldPassR.setVisible(true);
            txtFieldPassR.setFocusTraversable(true);
            passFieldR.setVisible(false);
            passFieldR.setFocusTraversable(false);
            txtFieldPassR.setText(passFieldR.getText());
            ivMostrarPassR.setImage(oAbierto);
        } else {
            txtFieldPassR.setVisible(false);
            txtFieldPassR.setFocusTraversable(false);
            passFieldR.setVisible(true);
            passFieldR.setFocusTraversable(true);
            passFieldR.setText(txtFieldPassR.getText());
            ivMostrarPassR.setImage(oCerrado);
        }
    }

    @FXML
    public void handleShowPassR1(ActionEvent actionEvent) {
        if (tbMostrarPassR1.isSelected()) {
            txtFieldPassR1.setVisible(true);
            txtFieldPassR1.setFocusTraversable(true);
            passFieldR1.setVisible(false);
            passFieldR1.setFocusTraversable(false);
            txtFieldPassR1.setText(passFieldR1.getText());
            ivMostrarPassR1.setImage(oAbierto);
        } else {
            txtFieldPassR1.setVisible(false);
            txtFieldPassR1.setFocusTraversable(false);
            passFieldR1.setVisible(true);
            passFieldR1.setFocusTraversable(true);
            passFieldR1.setText(txtFieldPassR1.getText());
            ivMostrarPassR1.setImage(oCerrado);
        }

    }
}
