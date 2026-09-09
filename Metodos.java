import java.util.Scanner;
import java.util.Stack;


public class Metodos {
    public Stack<Objautos> RegistrarAutos(Stack<Objautos> pila, Scanner sc){
        boolean  continuar = true;
        while (continuar){
            Objautos auto = new Objautos();
            System.out.println("Ingrese la marca del vehículo");
            auto.setMarca(sc.next());
            System.out.println("Ingrese el modelo del vehiculo");
            auto.setModelo(sc.next());
            System.out.println("Ingrese el año del vehiculo");
            auto.setAnio(sc.nextInt());
            System.out.println("ingrese el estado del vechiulo (Nuevo/Usado)");
            auto.setEstado(sc.next());
            System.out.println("Disponible para entrega inmediante 1) Si / 2) No");
            int n=sc.nextInt();
            if (n == 1) {
                auto.setTiempoEspera(0);
                
            } else {

                System.out.println("Ingrese los dias de entrega.");
                auto.setTiempoEspera(sc.nextInt());
            }

        }
        return pila;
    }
    
}
