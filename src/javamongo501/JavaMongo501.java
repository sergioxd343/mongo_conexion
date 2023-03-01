/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javamongo501;

import java.net.UnknownHostException;

/**
 *
 * @author sergi
 */
public class JavaMongo501 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException {
        Connection conexion = new Connection();

        conexion.mostrar();
        conexion.insertar("nadar");
        conexion.mostrar();

        conexion.actualizar("nadar", "brincar");
        conexion.mostrar();

        conexion.eliminar("brincar");
        conexion.mostrar();

    }

}
