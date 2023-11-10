/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.InterfaceClienteServidor;

/**
 * La clase Factoria proporciona un método estático para obtener una instancia
 * de la interfaz InterfaceClienteServidor. Utiliza la implementación
 * predeterminada, que es la clase Implementacion. Se utiliza para encapsular la
 * creación de instancias y permitir un fácil intercambio de implementaciones.
 *
 * Uso: Para obtener una instancia de la interfaz InterfaceClienteServidor,
 * llama al método estático getInterfaz().
 *
 * @author David
 */
public class Factoria {

    /**
     * Obtiene una instancia de la interfaz InterfaceClienteServidor.
     *
     * @return Una instancia de la interfaz InterfaceClienteServidor.
     */
    public static InterfaceClienteServidor getInterfaz() {
        return (InterfaceClienteServidor) new Implementacion();
    }
}
