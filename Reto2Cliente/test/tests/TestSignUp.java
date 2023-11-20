package tests;

import controller.ControllerSignUp;
import java.io.IOException;
import java.util.Random;
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
 * La clase TestSignUp es responsable de realizar pruebas para la funcionalidad.
 * Utiliza JUnit y TestFX para realizar pruebas en la interfaz de usuario.
 *
 *
 * @author David
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestSignUp extends ApplicationTest {

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
     * Inicia la aplicación y carga la interfaz de usuario de registro para
     * realizar pruebas.
     *
     * @param primaryStage El escenario principal de la aplicación.
     */
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/signUp.fxml"));
            Parent root = (Parent) loader.load();
            ControllerSignUp viewController = ((ControllerSignUp) loader.getController());
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
     * Prueba que los campos de texto de registro estén inicialmente vacíos.
     */
    
    @Test
    public void test1() {
        verifyThat("#txtFieldEmailR", hasText(""));
        verifyThat("#txtFieldNombre", hasText(""));
        verifyThat("#passFieldR", hasText(""));
        verifyThat("#passFieldR1", hasText(""));
        verifyThat("#txtFieldDireccion", hasText(""));
        verifyThat("#txtFieldCodigoPostal", hasText(""));
        verifyThat("#txtFieldTelefono", hasText(""));
    }

    /**
     * Prueba el proceso de registro con un email invalido.
     */
    
    @Test
    public void test2() {
        clickOn("#txtFieldEmailR");
        write("username");
        clickOn("#btnRegistrarse");
        clickOn("Aceptar");

    }

    /**
     * Prueba el proceso de registro con datos incompletos.
     */
    
    @Test
    public void test3() {
        clickOn("#txtFieldEmailR");
        write("username");
        clickOn("#txtFieldNombre");
        write("username");
        clickOn("#passFieldR");
        write("pass");
        clickOn("#passFieldR1");
        write("pass");
        clickOn("#tbMostrarPassR");
        clickOn("#tbMostrarPassR1");
        clickOn("#tbMostrarPassR");
        clickOn("#tbMostrarPassR1");
        clickOn("#txtFieldDireccion");
        write("direccion");
        clickOn("#txtFieldCodigoPostal");
        write("00");
        clickOn("#txtFieldTelefono");
        write("655");
        clickOn("#btnRegistrarse");
        clickOn("Aceptar");
    }

    /**
     * Prueba el proceso de registro con una nombre mal introducida.
     */
    
    @Test
    public void test4() {
        clickOn("#txtFieldEmailR");
        write("username@gmail.com");
        clickOn("#txtFieldNombre");
        write("username");
        clickOn("#passFieldR");
        write("pass");
        clickOn("#passFieldR1");
        write("pass");
        clickOn("#tbMostrarPassR");
        clickOn("#tbMostrarPassR1");
        clickOn("#tbMostrarPassR");
        clickOn("#tbMostrarPassR1");
        clickOn("#txtFieldDireccion");
        write("direccion");
        clickOn("#txtFieldCodigoPostal");
        write("00");
        clickOn("#txtFieldTelefono");
        write("655");
        clickOn("#btnRegistrarse");
        clickOn("Aceptar");
    }

    /**
     * Prueba el proceso de registro con una contraseña de usuario inválido y diferentes.
     */
    
    @Test
    public void test6() {
        clickOn("#txtFieldEmailR");
        write("username@gmail.com");
        clickOn("#txtFieldNombre");
        write("username user name");
        clickOn("#passFieldR");
        write("password");
        clickOn("#passFieldR1");
        write("pass");
        clickOn("#tbMostrarPassR");
        clickOn("#tbMostrarPassR1");
        clickOn("#tbMostrarPassR");
        clickOn("#tbMostrarPassR1");
        clickOn("#txtFieldDireccion");
        write("direccion");
        clickOn("#txtFieldCodigoPostal");
        write("00");
        clickOn("#txtFieldTelefono");
        write("655");
        clickOn("#btnRegistrarse");
        clickOn("Aceptar");
    }

    /**
     * Prueba el proceso de registro con contraseñas incorrectas.
     */
    
    @Test
    public void test7() {
        clickOn("#txtFieldEmailR");
        write("username@gmail.com");
        clickOn("#txtFieldNombre");
        write("username user name");
        clickOn("#passFieldR");
        write("password");
        clickOn("#passFieldR1");
        write("password");
        clickOn("#tbMostrarPassR");
        clickOn("#tbMostrarPassR1");
        clickOn("#tbMostrarPassR");
        clickOn("#tbMostrarPassR1");
        clickOn("#txtFieldDireccion");
        write("direccion");
        clickOn("#txtFieldCodigoPostal");
        write("00");
        clickOn("#txtFieldTelefono");
        write("655");
        clickOn("#btnRegistrarse");
        clickOn("Aceptar");
    }

     /**
     * Prueba el proceso de registro con una contraseña débil.
     */
    
    @Test
    public void test8() {
        clickOn("#txtFieldEmailR");
        write("username@gmail.com");
        clickOn("#txtFieldNombre");
        write("username user name");
        clickOn("#passFieldR");
        write("password1");
        clickOn("#passFieldR1");
        write("password1");
        clickOn("#tbMostrarPassR");
        clickOn("#tbMostrarPassR1");
        clickOn("#tbMostrarPassR");
        clickOn("#tbMostrarPassR1");
        clickOn("#txtFieldDireccion");
        write("direccion");
        clickOn("#txtFieldCodigoPostal");
        write("00000");
        clickOn("#txtFieldTelefono");
        write("656");
        clickOn("#btnRegistrarse");
        clickOn("Aceptar");
    }

    /**
     * Prueba el proceso de registro con datos válidos.
     */
    
    @Test
    public void test9() {
        Random r = new Random();
        Integer i = r.nextInt(100)+1;
        clickOn("#txtFieldEmailR");
        write("Prueba"+i+"@gmail.com");
        clickOn("#txtFieldNombre");
        write("Prueba Din Reto");
        clickOn("#passFieldR");
        write("abcd*1234");
        clickOn("#passFieldR1");
        write("abcd*1234");
        clickOn("#tbMostrarPassR");
        clickOn("#tbMostrarPassR1");
        clickOn("#tbMostrarPassR");
        clickOn("#tbMostrarPassR1");
        clickOn("#txtFieldDireccion");
        write("direccion");
        clickOn("#txtFieldCodigoPostal");
        write("43209");
        clickOn("#txtFieldTelefono");
        write("659325874");
        clickOn("#btnRegistrarse");
        clickOn("Aceptar");
        verifyThat("#btnIniciarSesion", isVisible());

    }

    /**
     * Prueba el proceso de registro con un usuario ya existente.
     */
    
    @Test
    public void test10() {
        clickOn("#txtFieldEmailR");
        write("prueba@gmail.com");
        clickOn("#txtFieldNombre");
        write("Gonzalo Fernandez Ripa");
        clickOn("#passFieldR");
        write("abcd*1234");
        clickOn("#passFieldR1");
        write("abcd*1234");
        clickOn("#txtFieldDireccion");
        write("direccion");
        clickOn("#txtFieldCodigoPostal");
        write("43209");
        clickOn("#txtFieldTelefono");
        write("659325874");
        clickOn("#btnRegistrarse");
        verifyThat("Aceptar", isVisible());
        clickOn("Aceptar");

    }

    /**
     * Prueba la funcionalidad del enlace "¿Ya tienes una cuenta?". Verifica que
     * el botón de inicio de sesión esté visible después de hacer clic en el
     * enlace.
     */
    
    @Test
    public void test11() {
        clickOn("#hplSiCuenta");
        verifyThat("#btnIniciarSesion", isVisible());
    }

}
