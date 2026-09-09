import java.util.Scanner;
import java.util.Stack;

public class Menu {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;
        int opt;
        Metodos m = new Metodos();
        Stack<Objautos> pila = new Stack<Objautos>();

            while(continuar){

                System.out.println("Concesionario Estructuras S&J");
                System.out.println("-----------------------");

                System.out.println("1. Registrar vehículo.");
                System.out.println("0. Salir.");
                System.out.println("Ingrese una opción: ");
                opt = sc.nextInt();
                sc.nextLine();
                System.out.println("-----------------------");


                switch (opt) {
                    case 1:
                        pila = m.RegistrarAutos(pila, sc);
                        break;
                
                    default:
                        break;
                }


            }


        sc.close();
    }
}
