
package proyectodeprograma;

/**
 * Esta clase fue creada para poder iniciar sesión en un 'objeto sistema'. 
 * La principal funcionalidad de esta clase es la de solicitar datos al usuario y 
 * verificar los mediante métodos ya definidos en él. 
 * -Utiliza una clase 'Utilidades', la cual tiene dos métodos get`s státicos: uno sirve
 * para leer enteros[Utilidades.leerInt()] y otra que sirve para leer datos del
 * tipo cadenas[Utilidades.leerString()].
 * @author Anthony Ortiz Ramón.
 * @author José Romero.
 * @author Jenny Pereira.
 * @author Hamilton Ramirez.
 */
public class Login {
         //Atributos del usuario Administrador
        String[] usuarioAdministrador={"admin1","admin2"};
        String[] contraseniaAdministrador={"123","456"};
        String[] nombreAdmin={"Margoth","Kaila"};
        
        //Atributos del usuario Estudiante.
        String[] usuarioEstudiante={"a","b","c"};
        String[] contraseniaEstudiante={"a12","b12","c12"};
        String[] nombreEstudiante={"Anthony","Edisson","Fernando"};
        
        String nombre;//Atributo para utilizar el nombre del usuario que accedio al sistema.
        boolean esAdmin;//Atributo para verificar si el usuario es Administrador o no.
       
       /**
        * Método encargado de solicitar los datos al usuario y verificar los mediante los métodos
        * isVerificacionUsuario() y isVerificacionContrasenia().
        * @return accsesoConcedido boolean, si se cumple la primera condición obtienen el valor 
        * de 'true' caso contrario se queda con su valor original 'false'.
        */ 
       public boolean isPeticionDatos(){
           String usuario;
           String contrasenia;
           boolean accsesoConcedido = false;
                    System.out.println("·························");//salto de línea.
                    System.out.print  ("  Usuario: ");
                    usuario=Utilidades.leerString();
                    System.out.print  ("  Contraseña: ");
                    contrasenia=Utilidades.leerString();
                    System.out.println("·························");//salto de línea.
                    if (isVerificacionUsuario(usuario)== true && isVerificacionContrasenia(contrasenia) == true) {
                        accsesoConcedido = true;
                        System.out.println("Bienvenido "+nombre);
                    }else if(isVerificacionUsuario(usuario)== true && isVerificacionContrasenia(contrasenia) == false ){
                        System.out.println("¡La contraseña es incorrecta!");
                    }else if(isVerificacionContrasenia(contrasenia) == true && isVerificacionUsuario(usuario)== false){
                        System.out.println("¡El usuario es incorrecto!");
                    }else{
                        System.out.println("Datos incorrectos, intente de nuevo"); 
                    }
            return accsesoConcedido;        
       }
       /**
        * Este método se encarga de verificar el 'usuario' que se ingreso por teclado
        * recorriendo cada arreglo con FOR's.
        * @param usuario obtenido del dato ingresado en el Método isPeticionDatos().
        * @return usuarioCorrecto boolean, si encontro el 'usuario' en algún Arreglo
        * tendra el valor de true caso contrario 'false'.
        */
       public boolean isVerificacionUsuario(String usuario){
           boolean usuarioCorrecto = false;
           for (int i = 0; i < usuarioAdministrador.length && usuarioCorrecto == false; i++) {
                if (usuarioAdministrador[i].equals(usuario)) {
                    usuarioCorrecto = true;
                    esAdmin = true;
                    nombre = nombreAdmin[i];
                }
           }
           for (int i = 0; i < usuarioEstudiante.length && usuarioCorrecto == false; i++) {
               if (usuarioEstudiante[i].equals(usuario)) {
                    usuarioCorrecto = true;
                    esAdmin = false;
                    nombre = nombreEstudiante[i];
               }
           }
         return usuarioCorrecto;
       }
       /**
        * Este método se encarga de verificar el 'contraseña' que se ingreso por teclado
        * recorriendo cada arreglo con FOR's.
        * @param contrasenia obtenido del dato ingresado en el Método isPeticionDatos().
        * @return contraseniaCorrecta boolean, si encontro el 'usuario' en algún Arreglo
        * tendra el valor de true caso contrario 'false'.
        */
       public boolean isVerificacionContrasenia(String contrasenia){
           boolean contraseniaCorrecta = false;
           for (int i = 0; i < contraseniaAdministrador.length && contraseniaCorrecta == false; i++) {
                if (contraseniaAdministrador[i].equals(contrasenia)) {
                    contraseniaCorrecta = true;
                }
           }
           for (int i = 0; i < contraseniaEstudiante.length && contraseniaCorrecta == false; i++) {
               if (contraseniaEstudiante[i].equals(contrasenia)) {
                    contraseniaCorrecta = true;
               }
           }
         return contraseniaCorrecta;
       }
}
