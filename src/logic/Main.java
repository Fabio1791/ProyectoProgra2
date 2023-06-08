/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package logic;

import erpvistas.Login;

/**
 *Es la clase Main desde donde se inicia el programa desde el Login.
 * @author fabio, Arnold, Jordy, Gladys
 */
public class Main {

    /**
     * @param  args thee command line arguments
    */
    public static void main(String[] args) {
        Login log = new Login ();
        log.setVisible(true);
        log.setLocationRelativeTo(null);
     //log.setExtendedState(log.MAXIMIZED_BOTH);
    }
    
} 
