package Ejercicio3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Trabajador implements Serializable {
    private String dni;
    private String nombreCompleto;
    private String telefono;
    private String fechaNacimiento;
    private double salario;

    // Constructor
    public Trabajador(String dni, String nombreCompleto, String telefono, String fechaNacimiento, double salario) {
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.salario = salario;
    }

    // Getters y Setters

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "DNI: " + dni + "Nombre Completo: " + nombreCompleto + "Teléfono: " + telefono + "Fecha de Nacimiento: " + fechaNacimiento + "Salario: " + salario;
    }
}

