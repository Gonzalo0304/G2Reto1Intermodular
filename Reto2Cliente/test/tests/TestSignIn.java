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
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestSignIn extends ApplicationTest {

    @BeforeClass
    public static void setUpClass() throws TimeoutException {
        FxToolkit.registerPrimaryStage();
        FxToolkit.setupApplication(Reto2Cliente.class);
    }

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

    @Override
    public void stop() {

    }

    @Test
    public void test1() {
        verifyThat("#txtFieldEmail", hasText(""));
        verifyThat("#passField", hasText(""));
        //verifyThat("#txtFieldPass", hasText(""));

    }

    @Test
    public void test2() {
        clickOn("#txtFieldEmail");
        write("username");
        clickOn("#btnIniciarSesion");
        clickOn("Aceptar");
    }

    @Test
    public void test3() {
        clickOn("#passField");
        write("password");
        clickOn("#btnIniciarSesion");
        clickOn("Aceptar");
    }

    @Test
    public void test4() {
        clickOn("#txtFieldEmail");
        write("username@gmail.com");
        clickOn("#passField");
        write("passwords");
        clickOn("#btnIniciarSesion");
        clickOn("Aceptar");
    }
    
    @Test
    public void test5(){
        clickOn("#txtFieldEmail");
        write("prueba@gmail.com");
        clickOn("#passField");
        write("abcd*1234");
        clickOn("#btnIniciarSesion");
        verifyThat("#btnCerrarSesion", isVisible());
    }
    
    
    @Test
    public void test6() {
        clickOn("#hplNoCuenta");
        verifyThat("#btnRegistrarse", isVisible());
    }

}
