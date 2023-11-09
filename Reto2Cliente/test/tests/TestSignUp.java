package tests;

import controller.ControllerSignUp;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.base.NodeMatchers.isVisible;
import reto2cliente.Reto2Cliente;

/**
 *
 * @author David
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestSignUp extends ApplicationTest {

    @BeforeClass
    public static void setUpClass() throws TimeoutException {
        FxToolkit.registerPrimaryStage();
        FxToolkit.setupApplication(Reto2Cliente.class);
    }

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

    @Override
    public void stop() {

    }

//    @Test
//    public void test1() {
//        verifyThat("#txtFieldEmailR", hasText(""));
//        verifyThat("#txtFieldNombre", hasText(""));
//        verifyThat("#passFieldR", hasText(""));
//        verifyThat("#passFieldR1", hasText(""));
//        verifyThat("#txtFieldDireccion", hasText(""));
//        verifyThat("#txtFieldCodigoPostal", hasText(""));
//        verifyThat("#txtFieldTelefono", hasText(""));
//    }
//    
//    
//    @Test
//    public void test2() {
//        clickOn("#txtFieldEmailR");
//        write("username");
//        clickOn("#btnRegistrarse");
//        clickOn("Aceptar");
//        
//    }
//    
//    @Test
//    public void test3() {
//        clickOn("#txtFieldEmailR");
//        write("username");
//        clickOn("#txtFieldNombre");
//        write("username");
//        clickOn("#passFieldR");
//        write("pass");
//        clickOn("#passFieldR1");
//        write("pass");
//        clickOn("#tbMostrarPassR");
//        clickOn("#tbMostrarPassR1");
//        clickOn("#tbMostrarPassR");
//        clickOn("#tbMostrarPassR1");
//        clickOn("#txtFieldDireccion");
//        write("direccion");
//        clickOn("#txtFieldCodigoPostal");
//        write("00");
//        clickOn("#txtFieldTelefono");
//        write("655");
//        clickOn("#btnRegistrarse");
//        clickOn("Aceptar");
//    }
//    
//    @Test
//    public void test4() {
//        clickOn("#txtFieldEmailR");
//        write("username@gmail.com");
//        clickOn("#txtFieldNombre");
//        write("username");
//        clickOn("#passFieldR");
//        write("pass");
//        clickOn("#passFieldR1");
//        write("pass");
//        clickOn("#tbMostrarPassR");
//        clickOn("#tbMostrarPassR1");
//        clickOn("#tbMostrarPassR");
//        clickOn("#tbMostrarPassR1");
//        clickOn("#txtFieldDireccion");
//        write("direccion");
//        clickOn("#txtFieldCodigoPostal");
//        write("00");
//        clickOn("#txtFieldTelefono");
//        write("655");
//        clickOn("#btnRegistrarse");
//        clickOn("Aceptar");
//    }
//    
//    @Test
//    public void test6() {
//        clickOn("#txtFieldEmailR");
//        write("username@gmail.com");
//        clickOn("#txtFieldNombre");
//        write("username user name");
//        clickOn("#passFieldR");
//        write("password");
//        clickOn("#passFieldR1");
//        write("pass");
//        clickOn("#tbMostrarPassR");
//        clickOn("#tbMostrarPassR1");
//        clickOn("#tbMostrarPassR");
//        clickOn("#tbMostrarPassR1");
//        clickOn("#txtFieldDireccion");
//        write("direccion");
//        clickOn("#txtFieldCodigoPostal");
//        write("00");
//        clickOn("#txtFieldTelefono");
//        write("655");
//        clickOn("#btnRegistrarse");
//        clickOn("Aceptar");
//    }
//    
//    @Test
//    public void test7() {
//        clickOn("#txtFieldEmailR");
//        write("username@gmail.com");
//        clickOn("#txtFieldNombre");
//        write("username user name");
//        clickOn("#passFieldR");
//        write("password");
//        clickOn("#passFieldR1");
//        write("password");
//        clickOn("#tbMostrarPassR");
//        clickOn("#tbMostrarPassR1");
//        clickOn("#tbMostrarPassR");
//        clickOn("#tbMostrarPassR1");
//        clickOn("#txtFieldDireccion");
//        write("direccion");
//        clickOn("#txtFieldCodigoPostal");
//        write("00");
//        clickOn("#txtFieldTelefono");
//        write("655");
//        clickOn("#btnRegistrarse");
//        clickOn("Aceptar");
//    }
//    
//    @Test
//    public void test8() {
//        clickOn("#txtFieldEmailR");
//        write("username@gmail.com");
//        clickOn("#txtFieldNombre");
//        write("username user name");
//        clickOn("#passFieldR");
//        write("password1");
//        clickOn("#passFieldR1");
//        write("password1");
//        clickOn("#tbMostrarPassR");
//        clickOn("#tbMostrarPassR1");
//        clickOn("#tbMostrarPassR");
//        clickOn("#tbMostrarPassR1");
//        clickOn("#txtFieldDireccion");
//        write("direccion");
//        clickOn("#txtFieldCodigoPostal");
//        write("00000");
//        clickOn("#txtFieldTelefono");
//        write("656");
//        clickOn("#btnRegistrarse");
//        clickOn("Aceptar");
//    }
    @Test
    public void test9() {
        clickOn("#txtFieldEmailR");
        write("Emma@gmail.com");
        clickOn("#txtFieldNombre");
        write("Emma Sanchez Rodriguez");
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

    @Test
    public void test10() {
        clickOn("#hplSiCuenta");
        verifyThat("#btnIniciarSesion", isVisible());
    }

}
