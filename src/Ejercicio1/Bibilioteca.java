package Ejercicio1;

import java.io.*;

public class Bibilioteca  {
    public static void main(String[] args) {
        try {
            //Flujos de entrada y salida
            DataOutputStream salida = new DataOutputStream(new FileOutputStream("fichero.dat"));
            DataInputStream entrada = new DataInputStream(new FileInputStream("fichero.dat"));


            //Solicitar datos de libros y almacenarlos en el fichero
            Libro libro1 = new Libro(1, "Don Quixote de la Mancha", "Miguel de Cervantes");
            Libro libro2 = new Libro(2, "El niño del pijamas de rayas", "John Boyne");

            libro1.grabarLibro(salida);
            libro2.grabarLibro(salida);

            salida.close();

            //Leer el contenido del fichero mostrando en pantalla todos los libros insertados.
            DataInputStream lectura = new DataInputStream(new FileInputStream("fichero.dat"));

            while (entrada.available() > 0){
                Libro libro = new Libro(0, "", "");
                libro.leerLibro(entrada);
                libro.mostrarLibro();
                System.out.println("==========================");
            }
            entrada.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
