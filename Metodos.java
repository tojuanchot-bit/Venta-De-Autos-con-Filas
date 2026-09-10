import java.util.Scanner;
import java.util.Stack;

public class Metodos {

    public Stack<Objautos> RegistrarAutos(Stack<Objautos> pila, Scanner sc){
        boolean  continuar = true;
        while (continuar){
            Objautos auto = new Objautos();

            System.out.println("Registro de vehículos. ");
            System.out.println("-------------------------------------");
            System.out.println("Ingrese la marca del vehículo");
            auto.setMarca(sc.next());
            System.out.println("Ingrese el modelo del vehiculo");
            auto.setModelo(sc.next());
            System.out.println("Ingrese el año del vehiculo");
            auto.setAnio(sc.nextInt());
            System.out.println("ingrese el estado del vehiulo (Nuevo/Usado)");
            auto.setEstado(sc.next());
            System.out.println("Disponible para entrega inmediante (Si / No)");
            String n = sc.next();

            if (n.equalsIgnoreCase("si")) {
                auto.setTiempoEspera(0);
            } else {
                System.out.println("Ingrese los dias de entrega.");
                auto.setTiempoEspera(sc.nextInt());
            }
            System.out.println(auto.getMarca() + " " + auto.getModelo() + " Registrado correctamente");
            System.out.println("¿Desea registrar un nuevo vehículo 1) Si / 2) no?");
            int m = sc.nextInt();
            if (m == 2) {
                continuar = false;
            }

        pila.push(auto);
        }
        return pila;
    }

    public void MostrarPila(Stack<Objautos> pila) {

        if (pila.isEmpty()) {
            System.out.println("Inventario vacio");
            System.out.println("--------------------");
        } else {
            for (Objautos auto : pila) {
                int contador = 1;
                System.out.println("Vehiculo " + contador);
                System.out.println("Marca: " + auto.getMarca());
                System.out.println("Modelo: " + auto.getModelo());
                System.out.println("Estado: " + auto.getEstado());
                System.out.println("Año: " + auto.getAnio());
                System.out.println("Tiempo de espera: " + auto.getTiempoEspera());
                System.out.println("Valor: " + auto.getPrecio());

                contador++;
            }
        }
    }

    public Stack<Objautos> VenderAuto(Stack<Objautos> pila, Stack<Objautos> vendidos, Scanner sc) {

        if (pila.isEmpty()) {
            System.out.println("No hay vehiculos disponibles para vender.");
            System.out.println("--------------------");
            return pila;
        }

        System.out.println("Ingrese el modelo del vehiculo a vender.");
        String modelo = sc.next(); //aca no sabía si ingresar la marca y/o el modelo,
                                    //asi que opté mejor por dejarlo mientras solo
                                    //con el modelo

        Stack<Objautos> pilaAuxiliar = new Stack<Objautos>();
        boolean encontrado = false;

        while (!pila.isEmpty()) {
            Objautos auto = pila.pop();
            if (!encontrado && auto.getModelo().equalsIgnoreCase(modelo)) {
                vendidos.push(auto);
                encontrado = true;
            } else {
                pilaAuxiliar.push(auto);
            }
        }

        while (!pilaAuxiliar.isEmpty()) {
            pila.push(pilaAuxiliar.pop());
        }

        if (encontrado) {
            System.out.println("Vehiculo modelo " + modelo + " vendido correctamente.");
        } else {
            System.out.println("No se encontró un vehiculo con el modelo " + modelo);
        }

        return pila;
    }

}