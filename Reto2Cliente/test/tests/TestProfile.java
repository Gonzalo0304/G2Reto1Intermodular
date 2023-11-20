/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import controller.ControllerProfile;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.base.NodeMatchers.isVisible;
import reto2cliente.Reto2Cliente;

/**
 *
 * La clase TestProfile es responsable de realizar pruebas para la funcionalidad
 * del perfil. Utiliza JUnit y TestFX para realizar pruebas en la interfaz de
 * usuario.
 *
 * @author David
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestProfile extends ApplicationTest {

    /**
     * Configura la aplicación antes de ejecutar las pruebas. Registra el
     * primaryStage y configura la aplicación Reto2Cliente.
     *
     * @throws TimeoutException si hay un problema en la configuración de la
     * aplicación.
     */
    @BeforeClass
    public static void setUpClass() throws TimeoutException {
        FxToolkit.registerPrimaryStage();
        FxToolkit.setupApplication(Reto2Cliente.class);
    }

     /**
     * Inicia la aplicación y carga la interfaz de usuario del perfil para
     * realizar pruebas.
     *
     * @param primaryStage El escenario principal de la aplicación.
     */
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/profile.fxml"));
            Parent root = (Parent) loader.load();
            ControllerProfile viewController = ((ControllerProfile) loader.getController());
            viewController.setStage(primaryStage, "Ejemplo");
            viewController.inicializarVentana(root);
        } catch (IOException ex) {
            Logger.getLogger(TestSignIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     /**
     * Detiene la aplicación después de que se hayan ejecutado las pruebas.
     */
    @Override
    public void stop() {

    }

     /**
     * Prueba la funcionalidad de cerrar sesión y verifica que el botón de
     * inicio de sesión sea visible.
     */
    @Test
    public void test1() {
        clickOn("#btnCerrarSesion");
        verifyThat("#btnIniciarSesion", isVisible());

    }

}
