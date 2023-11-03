/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.util.concurrent.TimeoutException;
import javafx.stage.Stage;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.base.NodeMatchers.isDisabled;
import static org.testfx.matcher.base.NodeMatchers.isEnabled;
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
public class TestSignIn extends ApplicationTest{
    
     @BeforeClass
    public static void setUpClass() throws TimeoutException {
        FxToolkit.registerPrimaryStage();
        FxToolkit.setupApplication(Reto2Cliente.class);
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
    }
    /*
    @Test
    public void test3() {
        clickOn("#passField");
        write("password");
        clickOn("#btnIniciarSesion");
    }
    */
    /*
    @Test
    public void test4() {
        clickOn("#txtFieldEmail");
        write("username@gmail.com");
        clickOn("#passField");
        write("passwords");
        clickOn("#btnIniciarSesion");
    }
    */


}
