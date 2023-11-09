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
public class TestProfile extends ApplicationTest {

    @BeforeClass
    public static void setUpClass() throws TimeoutException {
        FxToolkit.registerPrimaryStage();
        FxToolkit.setupApplication(Reto2Cliente.class);
    }

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

    @Override
    public void stop() {

    }

    @Test
    public void test1() {
        clickOn("#btnCerrarSesion");
        verifyThat("#btnIniciarSesion", isVisible());

    }

}
