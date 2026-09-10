import java.util.Scanner;
import java.util.Stack;

public class Metodos {

    public Stack<Objautos> RegistrarAutos(Stack<Objautos> pila, Scanner sc) {
        boolean continuar = true;
        while (continuar) {
            Objautos auto = new Objautos();

            System.out.println("Registro de vehículos. ");
            System.out.println("-------------------------------------");
            System.out.println("Ingrese la marca");
            auto.setMarca(ValidarString(sc));
            System.out.println("Ingrese el modelo");
            auto.setModelo(ValidarString(sc));
            System.out.println("Ingrese el año");
            auto.setAnio(ValidarEntero(sc));
            System.out.println("ingrese el estado del vehiulo (Nuevo/Usado)");
            auto.setEstado(ValidarString(sc));
            System.out.println("Ingrese el precio");
            auto.setPrecio(ValidarDouble(sc));
            System.out.println("Disponible para entrega inmediante (Si / No)");
            String n = ValidarString(sc);

            if (n.equalsIgnoreCase("si")) {
                auto.setTiempoEspera(0);
            } else {
                System.out.println("Ingrese los dias de entrega.");
                auto.setTiempoEspera(ValidarEntero(sc));
            }
            System.out.println(auto.getMarca() + " " + auto.getModelo() + " Registrado correctamente");
            System.out.println();
            System.out.println("¿Desea registrar un nuevo vehículo 1) Si / 2) no?");
            int m = ValidarEntero(sc);
            if (m == 2) {
                continuar = false;
            }

            pila.push(auto);
        }
        return pila;
    }

    public void MostrarPila(Stack<Objautos> pila) {

        if (pila.isEmpty()) {
            System.out.println("Inventario vacío");
            System.out.println("--------------------");
        } else {
            int contador = 1;
            for (Objautos auto : pila) {
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

        System.out.print("Ingrese la marca del vehículo: ");
        String marca = ValidarString(sc);
        System.out.print("Ingrese el modelo del vehículo a vender: ");
        String modelo = ValidarString(sc);

        Stack<Objautos> pilaAuxiliar = new Stack<Objautos>();
        boolean encontrado = false;

        while (!pila.isEmpty()) {
            Objautos auto = pila.pop();
            if (!encontrado && marca.equalsIgnoreCase(auto.getMarca()) && modelo.equalsIgnoreCase(auto.getModelo())) {
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
            System.out.println("Marca " + marca);
            System.out.println("Modelo " + modelo);
            System.out.println("¡Venta exitosa!");
        } else {
            System.out.println("Vehiculo marca: " + marca + " y modelo: " + modelo);
            System.out.println("No encontrado");
        }

        return pila;
    }

    public void MostrarVendidos(Stack<Objautos> vendidos) {

        if (vendidos.isEmpty()) {
            System.out.println("No hay autos vendidos aún");
            System.out.println("-------------------------");
        } else {
            System.out.println("-----Autos Vendidos-----");
            int contador = 1;
            for (Objautos auto : vendidos) {
                System.out.println("Vehiculo N°" + contador);
                System.out.println("Marca: " + auto.getMarca());
                System.out.println("Modelo: " + auto.getModelo());
                System.out.println("Estado: " + auto.getEstado());
                System.out.println("Precio: " + auto.getPrecio());
                System.out.println("----------------------");
                contador++;

            }
            System.out.println("Total autos vendidos: " + vendidos.size());
        }

    }

    public double TotalVentas(Stack<Objautos> vendidos) {
        if (vendidos.isEmpty()) {
            System.out.println("No hay ventas registradas");
            System.out.println("-------------------");
            return 0;
        }
        double total = 0;
        for (Objautos auto : vendidos) {
            total = total + auto.getPrecio();
        }
        System.out.println("Autos vendidos: " + vendidos.size());
        System.out.println("Total ventas: $" + total);
        return total;
    }

    public int ValidarEntero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Por favor ingresar un dato entero numérico");
            sc.next();
        }
        return sc.nextInt();
    }

    public double ValidarDouble(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.println("Por favor ingresar un valor valido");
            sc.next();
        }
        return sc.nextDouble();
    }

    public String ValidarString(Scanner sc) {
        String entrada = sc.next();
        while (entrada.trim().isEmpty()) {
            System.out.println("No puede estar vacío. Intente de nuevo ");
            entrada = sc.next();
        }
        return entrada;
    }
}
