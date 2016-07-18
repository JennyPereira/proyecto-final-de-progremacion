
package proyectodeprograma;

public class metodoPrincipal {
    public static void main(String[] args) {
        SistemaDeReserva obj = new SistemaDeReserva();
               
        while(true){
            obj.interfazAdministrador();
            
            while(obj.isHaySalasDisponibles()){
                obj.interfazEstudiante();
            }
            
        }
        
    }
    
}
