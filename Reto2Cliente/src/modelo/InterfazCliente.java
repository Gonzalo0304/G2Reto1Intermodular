/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.Mensaje;

/**
 *
 * @author Gonzalo
 */
public interface InterfazCliente {
    public Mensaje singIn(Mensaje respuesta);
    public Mensaje signUp(Mensaje respuesta);
    public void closeApli();
}
