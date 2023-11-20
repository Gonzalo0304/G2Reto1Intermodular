/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import controller.ControllerSignIn;
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
import static org.testfx.matcher.control.TextInputControlMatchers.hasText;
import reto2cliente.Reto2Cliente;

/**
 *
 * @author David
 *
 * La clase TestSignIn es responsable de realizar pruebas para la funcionalidad
 * de inicio de sesión. Utiliza JUnit y TestFX para realizar pruebas en la
 * interfaz de usuario.
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestSignIn extends ApplicationTest {

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
     * Inicia la aplicación y carga la interfaz de usuario de inicio de sesión
     * para realizar pruebas.
     *
     * @param primaryStage El escenario principal de la aplicación.
     */
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/signIn.fxml"));
            Parent root = (Parent) loader.load();
            ControllerSignIn viewController = ((ControllerSignIn) loader.getController());
            viewController.setStage(primaryStage);
            viewController.initStage(root);
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
     * Detiene la aplicación después de que se hayan ejecutado las pruebas.
     */
    
    @Test
    public void test1() {
        verifyThat("#txtFieldEmail", hasText(""));
        verifyThat("#passField", hasText(""));
        //verifyThat("#txtFieldPass", hasText(""));

    }

      /**
     * Prueba que esté rellenada la contraseña en el proceso de inicio de
     * sesión.
     */
    
    @Test
    public void test2() {
        clickOn("#txtFieldEmail");
        write("username");
        clickOn("#btnIniciarSesion");
        clickOn("Aceptar");
    }

     /**
     * Prueba que esté rellenado el email el proceso de inicio de sesión .
     */
    
    @Test
    public void test3() {
        clickOn("#passField");
        write("password");
        clickOn("#btnIniciarSesion");
        clickOn("Aceptar");
    }

    /**
     * Prueba el proceso de inicio de sesión con un nombre de usuario y
     * contraseña inválidos.
     */
    
    @Test
    public void test4() {
        clickOn("#txtFieldEmail");
        write("username@gmail.com");
        clickOn("#passField");
        write("abcd*1234");
        clickOn("#btnIniciarSesion");
        clickOn("Aceptar");
        
    }

     /**
     * Prueba el proceso de inicio de sesión con un nombre de usuario y
     * contraseña válidos. Verifica que el botón de cerrar sesión esté visible
     * después del inicio de sesión exitoso.
     */
    
    @Test
    public void test5() {
        clickOn("#txtFieldEmail");
        write("prueba@gmail.com");
        clickOn("#passField");
        write("abcd*1234");
        clickOn("#btnIniciarSesion");
        verifyThat("#btnCerrarSesion", isVisible());
    }

    /**
     * Prueba la funcionalidad del enlace "¿No tienes una cuenta?". Verifica que
     * el botón de registro esté visible después de hacer clic en el enlace.
     */
    
    @Test
    public void test6() {
        clickOn("#hplNoCuenta");
        verifyThat("#btnRegistrarse", isVisible());
    }

}
