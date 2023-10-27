/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author Gonzalo
 */
public class PassDontMatch extends Exception {

    /**
     * Creates a new instance of <code>PassDontMatch</code> without detail
     * message.
     */
    public PassDontMatch() {
    }

    /**
     * Constructs an instance of <code>PassDontMatch</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public PassDontMatch(String msg) {
        super(msg);
    }
}
