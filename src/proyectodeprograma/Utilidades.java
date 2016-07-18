
package proyectodeprograma;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Utilidades {
    public static String leerString(){
        Scanner teclado = new Scanner(System.in);
        String dato;
        dato=teclado.nextLine();
        dato=dato.toLowerCase();
        return dato;
    }
    public static int leerInt(){
        Scanner teclado = new Scanner(System.in);
        int dato;
        dato=teclado.nextInt();
        return dato;
    }
}
