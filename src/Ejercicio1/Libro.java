package Ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Libro {
    private long ISBN;
    private String Titulo;
    private String Autor;

    //Constructor de la clase.
     public Libro(long cod, String s1, String s2 ){
        this.ISBN = cod;
        this.Titulo = s1;
        this.Autor = s2;
    }

    //Guarda en el fichero que se le pasa como argumento los datos del fichero.
    public void grabarLibro(DataOutputStream fich) throws IOException {
    fich.writeLong(ISBN);
    fich.writeUTF(Titulo);
    fich.writeUTF(Autor);
    }

    //Lee del ficheros los datos del libro y los almacena en los atributos del libro.
    public void leerLibro(DataInputStream fich) throws IOException{
    ISBN = fich.readLong();
    Titulo = fich.readUTF();
    Autor = fich.readUTF();
    }

    //Muestra en pantalla los datos del libro.
    public void mostrarLibro(){
    System.out.println("ISBN: "+ ISBN);
    System.out.println("Titulo: "+ Titulo);
    System.out.println("Autor: "+ Autor);
     }

     //Devuleve el valos del ISBN.
    public long getISBN() {
        return ISBN;
    }

    //Devuleve el valor del titulo del libro.
    public String getTitulo(){
    return Titulo;
    }

    //Devuelve el valor del autor del libro.
    public String getAutor() {
        return Autor;
    }
}
