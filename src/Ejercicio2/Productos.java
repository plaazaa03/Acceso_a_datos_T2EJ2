package Ejercicio2;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Productos {
    public static void main(String[] args) {
        try {
            // Generar el fichero fproduct.dat
            RandomAccessFile fichero = new RandomAccessFile("fproduct.dat", "rw");
            int codproducto[] = {0, 1, 2, 3, 4};
            double precio[] = {500.00, 600.00, 20.00, 15.00, 60.00};

            // Escribir datos iniciales en el archivo
            for (int i = 0; i < codproducto.length; i++) {
                fichero.writeInt(codproducto[i]);
                fichero.writeDouble(precio[i]);
            }

            // Leer códigos de productos y aumentar precios en un 10%
            Scanner scanner = new Scanner(System.in);

            int codigo;
            do {
                System.out.print("Introduce el código del producto (0 para salir): ");
                codigo = scanner.nextInt();

                if (codigo != 0) {
                    actualizarPrecio(fichero, codigo);
                }

            } while (codigo != 0);

            // Cerrar el archivo al finalizar
            fichero.close();

        } catch (IOException e) {
            System.out.println("Error al introducir el codigo. Debe ser un rango entre (1-5)");
        }
    }

    private static void actualizarPrecio(RandomAccessFile fichero, int codigo) throws IOException {
        long posicion = (codigo - 1) * 16; // 16 bytes por registro (4 bytes para el código, 8 bytes para el precio)
        fichero.seek(posicion);

        // Leer el precio actual
        double precioActual = fichero.readDouble();

        // Calcular el nuevo precio (aumentarlo en un 10%)
        double nuevoPrecio = precioActual * 1.1;

        // Mover el puntero de escritura de nuevo a la posición del código
        fichero.seek(posicion + 4); // Saltar los primeros 4 bytes (código) para escribir el nuevo precio
        fichero.writeDouble(nuevoPrecio);

        System.out.println("Precio actualizado para el código " + codigo);
    }
}
