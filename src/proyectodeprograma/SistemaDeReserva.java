
package proyectodeprograma;

import java.util.Arrays;
import java.util.Scanner;
/**
 * La clase "SisteDeReserva" fue creada para emitar el sistema de reserva de las salas
 * de computo de la UTPL.
 * Esta clase tiene métodos los cuales fueron creados para realizar ciertas tareas específicas 
 * como visualizar salas, registrar equipo, entre otros.
 * -Utiliza una clase 'Utilidades', la cual tiene dos métodos  get`s státicos: uno sirve
 * para leer enteros[Utilidades.leerInt()] y otra que sirve para leer datos del
 * tipo cadenas[Utilidades.leerString()].
 * @author Anthony Ortiz Ramón.
 * @author José Romero.
 * @author Jenny Pereira.
 * @author Hamilton Ramirez.
 */
public class SistemaDeReserva {
  Login acceso = new Login();
  private  boolean salir;
  //Strings arreglos parar reprsentar las salas de cómputo.
  private  String salaA[]={"X","X","X","X","X","X"};
  private  String salaB[]={"X","X","X","X","X","X"};
  private  String salaC[]={"X","X","X","X","X","X"};
  private  String salaD[]={"X","X","X","X","X","X"};
    
    //-----------------------------------ADMIN----------------------------------
    /**
     * Este metodo se encarga de mostrar un menu del administrador y de ejecutar
     * las funciones del mismo.
     */
    public void interfazAdministrador(){
            int opcion;
            boolean salir;
            
            do{
            salir=false;
            System.out.println("                     UNIVERSIDAD TÉCNICA PARTICULAR DE LOJA");
            System.out.println("    |=========================================|");
            System.out.println("    |Opcion[1]: visualizar sala(s) de computo |");
            System.out.println("    |Opción[2]: suspender equipo dañado(s)           |");
            System.out.println("    |Opción[3]: habilitar sala(s)             |");
            System.out.println("    |Opción[4]: deshabilitar sala(s)          |");
            System.out.println("    |Opción[5]: permitir ingreso              |");
            System.out.println("    |=========================================|");
            System.out.print("Opción: ");
            opcion=Utilidades.leerInt();
            switch (opcion){
                case 1: verDisponibilidadSalas(); visualizarSalas(); break;                     
                case 2: suspenderEquipo(); break;
                case 3: habilitarSalas();break;
                case 4: desabilititarSalas();break;
                case 5: salir = true;break;
                default:System.out.println("¡Esta opción no existe!");
            } 
            }while(salir==false);
    }
    
    /**
     * Este metodo se encarga de mostrar la disponibilidad de las salas con ayuda          
     * de otro metodo(isSalaDisponible) que verifica si cada sala esta ocupada o no. 
     */
    private void verDisponibilidadSalas(){
        System.out.println("-----------------------------------------------------");
        if (isSalaDisponible(salaA)) {
            System.out.print("  Sala A: Disponible          ");
        }else{
            System.out.print("  Sala A: No Disponible       ");
        }

        if (isSalaDisponible(salaB)) {
            System.out.println("Sala B: Disponible");
        }else{
            System.out.println("Sala B: No disponible");
        }
        
        if (isSalaDisponible(salaC)) {
            System.out.print("  Sala C: Disponible          ");
        }else{
            System.out.print("  Sala C: No disponible       ");
        }
        
        if (isSalaDisponible(salaD)) {
            System.out.println("Sala D: Disponible");
        }else{
            System.out.println("Sala D: No disponible");
        }
        System.out.println("-----------------------------------------------------");
    }

    
    //Primera opción

    private void visualizarSalas(){
            String sala;
            System.out.print("Ingrese la sala: ");
            sala=Utilidades.leerString();
            switch(sala){
                //Metodo mostrarSala() se encuentra mas abajo.
                case "a": mostrarSala(this.salaA);break;
                case "b": mostrarSala(this.salaB);break;
                case "c": mostrarSala(this.salaC);break;
                case "d": mostrarSala(this.salaD);break;
                default:System.out.println("¡Esta sala no existe!");
            }
    }
    /** 
     * @param sala(arreglo), este metodo que recibe una arreglo como parametro se encarga  
     * de imprimir el mismo pero en forma de matriz.
     */
    private void mostrarSala(String sala[]){
            System.out.println("------------------");
            System.out.print("   ");
            for (int i = 0; i < sala.length; i++) {                          
                System.out.print("["+sala[i]+"] ");
                if (i==2) {
                    System.out.println("");
                    System.out.print("   ");
                }             
            }
            System.out.print("\n------------------\n");
    }
    //FIN Primera opción
    
    //Segunda opción
    /**
     * La funcionalidad de este metodo es de suspender un equipo daño, primero solicita
     * la sala  donde quiere deshabilitar el equipo despues llama al metodo
     * (setEquipoDañado() que se encunetra de bajo de este metodo).
     */
    private void suspenderEquipo(){
            String sala,respuesta;
            System.out.println("--------------------------------------------");
            do{          
                System.out.print("Ingrese la sala:");
                sala=Utilidades.leerString();
                switch(sala){
                    case "a": setEquipoDañado(salaA);break;
                    case "b": setEquipoDañado(salaB);break;
                    case "c": setEquipoDañado(salaC);break;
                    case "d": setEquipoDañado(salaD);break;
                 default: System.out.println("¡Esta sala no existe!");
                }
                System.out.print("Ingresar a otra sala(si/no): ");
                respuesta=Utilidades.leerString();
            } while(respuesta.equals("si"));
   }
    /**
     * @param sala(arreglo), su funcionalidad se centra en deshabilitar un equipo 
     * que se encuentre dañado en la sala especificada como parametro.
     */
    private void setEquipoDañado(String sala[]){
            Scanner teclado1 = new Scanner(System.in);
            String respuesta;
            int equipo;
            do{
                System.out.print("Equipo: ");
                equipo=teclado1.nextInt();
                System.out.print("Confirmar(si/no): ");
                respuesta=Utilidades.leerString();               
                if (respuesta.equals("si")) {
                     if (equipo > 0 && equipo < 7) {
                            sala[equipo-1]="D";                        
                     }else{
                            System.out.println("¡Este equipo no existe!");
                     }                 
                }            
                System.out.print("Registrar otro(si/no):");
                respuesta=Utilidades.leerString();                 
            }while(respuesta.equals("si"));
    }
    //FIN Segunda opción
    
    
    //Tercera opción 
    private void habilitarSalas(){
        String sala, respuesta;
        System.out.println("--------------------------------------------");
        do{
            System.out.print("Ingrese la sala: ");
            sala=Utilidades.leerString();
            switch(sala){
                //habilitarSala() se encuentra mas abajo. 
                case "a": habilitarSala(salaA);break;
                case "b": habilitarSala(salaB);break;
                case "c": habilitarSala(salaC);break;
                case "d": habilitarSala(salaD);break;
                default:System.out.println("¡Esta sala no existe!");
            }
            System.out.print("Desea habilitar otra sala(si/no): ");
            respuesta=Utilidades.leerString();
        }while(respuesta.equals("si"));
     } 
    /**
     * @param sala(arreglo), al recibir este arreglo como parametro lo recorre y
     * si el arreglo no tiene equipos dañados asigna el valor del contador de cada 
     * posicion para indicar el numero del equipo.
     */
    private void habilitarSala(String sala[]){
        for (int i = 0; i < sala.length; i++) {
            if (!sala[i].equals("D")) {
                sala[i]=Integer.toString(i+1);
            }
        }
    }
    //FIN Tercera opción 
    
    //Cuarta opción
    /**
     * La funcionalidad de este metodo permite llenar el arreglo con 'X', en la sala que 
     * se indique(esto da entender que los equipos ya no etan disponibles).
     */
    private void desabilititarSalas(){
        String sala, respuesta;        
        System.out.println("--------------------------------------------");
        do{
            System.out.print("Ingrese la sala: ");
            sala=Utilidades.leerString();
            switch(sala){
                case "a": Arrays.fill(salaA, "X");break;
                case "b": Arrays.fill(salaB, "X");break;
                case "c": Arrays.fill(salaC, "X");break;
                case "d": Arrays.fill(salaD, "X");break;
                default:System.out.println("¡Esta sala no existe!");
            }
            System.out.print("Desea habilitar otra sala(si/no): ");
            respuesta=Utilidades.leerString();
        }while(respuesta.equals("si"));        
    }
    
    //FIN Cuarta opción
    //-----------------------------------ADMIN----------------------------------
    
    //----------------------------------ESTUDIANTE------------------------------
    /**
     * Su funcionalidad se encarga de mostrar el menu del estudiante y de ejecutar
     * los metodos correspodientes a las opciones.
     */
    public void interfazEstudiante(){
        Scanner teclado = new Scanner(System.in);
        int opcion;  
        if (acceso.isTieneAcceso()) {    
            do{
                 this.salir=false;
                 System.out.println("|========================================|");
                 System.out.println("|Opción[1]: visualizar sala(s) de computo|");
                 System.out.println("|Opción[2]: registrar equipo             |");
                 System.out.println("|Opción[3]: salir                        |");
                 System.out.println("|========================================|");
                 System.out.print("Opción: ");
                 opcion = teclado.nextInt();
                    switch(opcion){
                        case 1: verDisponibilidadSalas(); visualizarSalas(); break;
                        case 2: registrarEquipo();break;
                        case 3: this.salir=true;break;
                        default:System.out.println("¡Esta opción no existe!");
                    }
            }while(this.salir==false);
      } 
    }
    //Segunda opción estudainte
    public void registrarEquipo(){
        String sala;
        System.out.println("--------------------------------------------");
            System.out.print("Ingrese la sala: "); 
            sala=Utilidades.leerString();
            switch(sala){
                //El metodo setRegistroEn() se encuentra mas abajo.
                case "a": setRegistroEn(salaA);break;
                case "b": setRegistroEn(salaB);break;
                case "c": setRegistroEn(salaC);break;
                case "d": setRegistroEn(salaD);break;
                default:System.out.println("¡Esta sala no existe!");            
            }
    }
    /**
     * Este metodo se encarga de solicitar y registrar un equipo. 
     * @param sala(arreglo), al recibir este parametro lo recorre y verifica si 
     * el equipo que ingreso esta disponible, si el equipo que ingreso esta disponible
     * se registra en el arreglo indicado por el estudiante.
     */
    private void setRegistroEn(String sala[]){
        int equipo;
        String respuesta;
        boolean salir;
        mostrarSala(sala);
        System.out.print("Ingrese el equipo: ");
        equipo=Utilidades.leerInt();
        System.out.print("Confirmar(si/no): ");
        respuesta=Utilidades.leerString();                                                                        
        if (respuesta.equals("si")) {       
            for (int i = 0; i < sala.length; i++) {
                if (sala[equipo-1].equals(Integer.toString(equipo))) {
                     sala[equipo-1]="0";
                     this.salir=true;
                     mostrarSala(sala);
                     System.out.println(acceso.nombre+" Máquina ["+ equipo+"]"+" reservada");
                     break;
                }else {
                    if(sala[i].equals("X")||sala[i].equals("0")){
                            System.out.println("¡Este equipo no esta disponible!");
                            break;
                    }else{                        
                            System.out.println("¡Este equipo esta dañado!");
                            break;
                        
                    }                 
                }
            }
        }
    }        
    //FIN Segunda opción estudainte
    //----------------------------------ESTUDIANTE------------------------------
    /**
     * Este metodo se encarga de verificar la disponibilidad de una sala.
     * @param sala, al momento de 
     * @return 
     */
    private boolean isSalaDisponible(String sala[]){
        boolean disponibilidad=true;
        int n=0;
        for (int i = 0; i < sala.length; i++) {
            if (sala[i].equals("X")||sala[i].equals("D")||sala[i].equals("0")) {
                n+=1;
            }
        }
        if (n==6) {
            disponibilidad=false;
        }
        return disponibilidad;
    }
                                                       
    public boolean isHaySalasDisponibles(){
        int n=0;
        boolean disponibilidad=true;
        if (isSalaDisponible(salaA)==false){
            n+=1;
        }
        if (isSalaDisponible(salaB)==false){
            n+=1;
        }
        if (isSalaDisponible(salaC)==false){
            n+=1;
        }
        if (isSalaDisponible(salaD)==false){
            n+=1;
        } 
        if (n==4) {
            disponibilidad = false;
        }
        return disponibilidad;
    }
    
}
