/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.InterfaceClienteServidor;

/**
 *
 * @author David
 */
public class Factoria {

    public static InterfaceClienteServidor getInterfaz() {
        return (InterfaceClienteServidor) new Implementacion();
    }
}
