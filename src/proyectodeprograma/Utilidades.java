
package proyectodeprograma;

import java.util.Scanner;
/**
 * Esta clase fue creada para leer datos sin tener que volver instanciar un objeto
 * 'Scanner' en cada clase y de se evita que erros al ingresar datos.
 * @author Anthony Ortiz Ramón.
 * @author José Romero.
 * @author Jenny Pereira.
 * @author Hamilton Ramirez.
 */
/**
 *
 * @author Usuario
 */
public class Utilidades {
        /**
     * Método encargado de leer un dato de tipo cadena.
     * @return dato String.
     */
    public static String leerString(){
        Scanner teclado = new Scanner(System.in);
        String dato;
        dato=teclado.nextLine();
        dato=dato.toLowerCase();
        return dato;
    }
        /**
     *  Método encargado de leer un dato de tipo entero.
     * @return dato int.
     */
    public static int leerInt(){
        Scanner teclado = new Scanner(System.in);
        int dato;
        dato=teclado.nextInt();
        return dato;
    }
}
