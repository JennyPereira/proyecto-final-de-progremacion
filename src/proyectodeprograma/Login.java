
package proyectodeprograma;

public class Login {
        String[] usuario={"a","b","c"};
        String pass[]={"a12","b12","c12"};
        String nombres[]={"Anthony","Edisson","Fernando"};
        String nombre;
        boolean acceso;
        /**
         * Este metodo pide al usuario que ingrese los datos para logearse, en su
         * interior recorre un 'FORD' para verificar el usuario y la contraseña que
         * se encuentran en diferentes arreglos.
         * @return una variable boolean 'acceso', si el usuario y la contraseña se 
         * encuentran en los arreglos retorna un true caso contrario retorna false.
         * Y si no existe los datos muestra un mensaje.
         */
        public boolean isTieneAcceso(){
            String usuario,contraseña;
            boolean acceso=false;
            
                while(acceso==false){
                    System.out.print("Usuario: ");
                    usuario=Utilidades.leerString();
                    System.out.print("Contraseña: ");
                    contraseña=Utilidades.leerString();
                        for (int i = 0; i < this.usuario.length; i++) {                    
                            if (this.usuario[i].equals(usuario)&& pass[i].equals(contraseña)) {
                                 System.out.println("Bienvenido "+nombres[i]);
                                 nombre =nombres[i];
                                 acceso=true;
                                 break;
                            }else if(this.usuario[i].equals(usuario) && !pass[i].equals(contraseña)){
                                
                                        System.out.println("La contraseña es incorrecta");
                                         break;
                           } else if (pass[i].equals(contraseña) && !this.usuario[i].equals(usuario)) {
                                
                                        System.out.println("El usuario es incorrecto"); 
                                        break;                                                     
                           }else if (i+1 == this.usuario.length){
                               System.out.println("Los datos son incorrectos");
                           }
                       }
                       
                       
                 }
                
            return acceso;
        }
        /**
         * hola
         */
}
