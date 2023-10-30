/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.Mensaje;
import clases.Usuario;

/**
 *
 * @author David.
 */
public interface Interfaz {

    public Mensaje iniciarSesion(Mensaje mensaje);

    public Mensaje registrarUsuario(Mensaje mensaje);
}
