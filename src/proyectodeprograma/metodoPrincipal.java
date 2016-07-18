
package proyectodeprograma;
/**
 * La clase ejecutarSistemaDeReserva se creo para ejecutar un objeto que asimila
 * tener las funcionalidades de un sistema de reserva de equipos.
 * @author Anthony Ortiz Ramón.
 * @author José Romero.
 * @author Jenny Pereira.
 * @author Hamilton Ramirez.
 */
public class metodoPrincipal {
    public static void main(String[] args) {
        SistemaDeReserva objSistema = new SistemaDeReserva();//objeto creado
       
        
        while(true){                
            //condición para verificar si tiene acceso al 'sistema'.
            if (objSistema.isTieneAcceso() == true) {
                               
                if (objSistema.sesion.esAdmin) {//se verifica si es Administrador                
                    objSistema.interfazAdministrador();                 
                }else{                          //caso contrario se entendera que es un estudiante. 
                    objSistema.interfazEstudiante();    
                }
                
            }//Fin (objSistema.isTieneAcceso())
                  
        }//Fin while(true)
    }
}
