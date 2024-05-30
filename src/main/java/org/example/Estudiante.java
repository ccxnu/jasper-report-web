package org.example;

public class Estudiante {
    private String nombre;
    private String matricula;
    private double calificacionPromedio;

    // Constructor
    public Estudiante(String nombre, String matricula, double calificacionPromedio) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.calificacionPromedio = calificacionPromedio;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getCalificacionPromedio() {
        return calificacionPromedio;
    }

    public void setCalificacionPromedio(double calificacionPromedio) {
        this.calificacionPromedio = calificacionPromedio;
    }

    // Método toString
    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", matricula='" + matricula + '\'' +
                ", calificacionPromedio=" + calificacionPromedio +
                '}';
    }
}
