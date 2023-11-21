package Ejercicio1;

import java.io.DataOutputStream;
import java.io.IOException;

public class Libro {
    private long ISBN;
    private String Titulo;
    private String Autor;

     public Libro(long cod, String s1, String s2 ){
        this.ISBN = cod;
        this.Titulo = s1;
        this.Autor = s2;
    }

    public void grabarLibro(DataOutputStream fich) throws IOException {
    fich.writeLong(ISBN);
    fich.writeUTF(Titulo);
    fich.writeUTF(Autor);
    }
    public void leerLibro(DataOutputStream fich) throws IOException{

    }

    public void mostrarLibro(){
    System.out.println("ISBN: "+ISBN);
    System.out.println("Titulo: "+ Titulo);
    System.out.println("Autor: "+ Autor);

     }

    public long getISBN() {
        return ISBN;
    }

    public String getTitulo(){
    return Titulo;
    }

    public String getAutor() {
        return Autor;
    }
}
