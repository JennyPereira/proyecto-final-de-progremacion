
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
        SistemaDeReserva obj = new SistemaDeReserva();//objeto creado
               
        while(true){
            obj.interfazAdministrador();
            
            while(obj.isHaySalasDisponibles()){
                obj.interfazEstudiante();
            }
            
        }//Fin while(true)
        
    }
    
}
