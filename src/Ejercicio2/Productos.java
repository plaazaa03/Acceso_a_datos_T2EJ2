package Ejercicio2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Productos {
    public static void main(String[] args) throws FileNotFoundException {
        try{
            //Generar el fichero fproduct.dat
            RandomAccessFile randomAccessFile = new RandomAccessFile("fproduct.dat", "rw");
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
