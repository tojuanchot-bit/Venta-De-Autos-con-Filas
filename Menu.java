import java.util.Scanner;
import java.util.Stack;
import javax.swing.JOptionPane;

public class Menu {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean continuar = true;
        int opt;
        Metodos m = new Metodos();
        Stack<Objautos> pila = new Stack<Objautos>();
        Stack<Objautos> pilaVendidos = new Stack<Objautos>();
        System.out.println();
        System.out.println("=====Concesionario Estructuras S&J=====");

        while (continuar) {
            System.out.println();
            System.out.println("Ingrese una opción ");
            System.out.println("1. Registrar vehículo.");
            System.out.println("2) Mostrar registro de autos.");
            System.out.println("3) Vender auto.");
            System.out.println("4) Mostrar autos vendidos.");
            System.out.println("5) Mostrar autos disponibles.");
            System.out.println("6) Total ventas.");
            System.out.println("7) Salir.");
            System.out.print("Opción: ");
            opt = m.ValidarEntero(sc);
            sc.nextLine();
            System.out.println("-----------------------");

            switch (opt) {
                case 1:
                    pila = m.RegistrarAutos(pila, sc);
                    break;

                case 2:
                    m.MostrarPila(pila);
                    break;
                case 3:
                    pila = m.VenderAuto(pila, pilaVendidos, sc);
                    break;
                case 4:
                    m.MostrarVendidos(pilaVendidos);
                    break;
                case 5:
                    m.MostrarPila(pila);
                    break;
                case 6:
                    m.TotalVentas(pilaVendidos);
                    break;
                case 7:
                    continuar = false;
                    JOptionPane.showMessageDialog(null, "¡Hasta Luego!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "¡Opción inválida! intente de nuevo");
                    break;
            }
        }
        sc.close();
    }
}
