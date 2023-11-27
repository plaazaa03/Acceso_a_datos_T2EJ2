package Ejercicio3;

import Ejercicio3.Trabajador;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProgramaTrabajadores {
    public static void main(String[] args) {
        try {
            // Paso 1: Crear el fichero binario de trabajadores (ftrabajador.dat)
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ftrabajador.dat"));

            // Paso 2: Solicitar datos por pantalla y almacenar objetos Trabajador en el fichero
            List<Trabajador> trabajadores = new ArrayList<>();
            solicitarDatosTrabajadores(trabajadores);
            oos.writeObject(trabajadores);

            // Cerrar el ObjectOutputStream
            oos.close();

            // Paso 3: Calcular la media de los salarios de todos los trabajadores
            double mediaSalarios = calcularMediaSalarios(trabajadores);
            System.out.println("La media de los salarios es: " + mediaSalarios);

            // Paso 4: Crear un nuevo fichero con los trabajadores cuyo salario sea inferior a la media
            List<Trabajador> trabajadoresInferiores = obtenerTrabajadoresInferioresMedia(trabajadores, mediaSalarios);
            incrementarSalario(trabajadoresInferiores, 0.2); // Incrementar salarios en un 20%
            ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("ftrabajador_inferiores.dat"));
            oos2.writeObject(trabajadoresInferiores);
            oos2.close();

            // Paso 5: Mostrar el contenido del último fichero generado
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ftrabajador_inferiores.dat"));
            List<Trabajador> trabajadoresMostrar = (List<Trabajador>) ois.readObject();
            for (Trabajador t : trabajadoresMostrar) {
                System.out.println("-------");
                System.out.println(t);
            }

            // Cerrar el ObjectInputStream
            ois.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void solicitarDatosTrabajadores(List<Trabajador> trabajadores) {
        Scanner scanner = new Scanner(System.in);
        String continuar;

        do {
            System.out.println("Introduce los datos del trabajador:");
            System.out.print("DNI: ");
            String dni = scanner.nextLine();
            System.out.print("Nombre Completo: ");
            String nombreCompleto = scanner.nextLine();
            System.out.print("Teléfono: ");
            String telefono = scanner.nextLine();
            System.out.print("Fecha de Nacimiento: ");
            String fechaNacimiento = scanner.nextLine();
            System.out.print("Salario: ");
            double salario = scanner.nextDouble();
            scanner.nextLine(); // Consumir la nueva línea

            Trabajador trabajador = new Trabajador(dni, nombreCompleto, telefono, fechaNacimiento, salario);
            trabajadores.add(trabajador);

            System.out.print("¿Quieres introducir otro trabajador? (S/N): ");
            continuar = scanner.nextLine();
        } while ("S".equalsIgnoreCase(continuar));
    }

    private static double calcularMediaSalarios(List<Trabajador> trabajadores) {
        double sumaSalarios = 0;

        for (Trabajador t : trabajadores) {
            sumaSalarios += t.getSalario();
        }

        return sumaSalarios / trabajadores.size();
    }

    private static List<Trabajador> obtenerTrabajadoresInferioresMedia(List<Trabajador> trabajadores, double media) {
        List<Trabajador> trabajadoresInferiores = new ArrayList<>();

        for (Trabajador t : trabajadores) {
            if (t.getSalario() < media) {
                trabajadoresInferiores.add(t);
            }
        }

        return trabajadoresInferiores;
    }

    private static void incrementarSalario(List<Trabajador> trabajadores, double porcentaje) {
        for (Trabajador t : trabajadores) {
            double nuevoSalario = t.getSalario() * (1 + porcentaje);
            t.setSalario(nuevoSalario);
        }
    }
}
