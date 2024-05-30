package org.example;

import java.util.ArrayList;

public class SistemaGestionEstudiantes {
    private final ArrayList<Estudiante> listaEstudiantes;

    public SistemaGestionEstudiantes() {
        listaEstudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        listaEstudiantes.add(estudiante);
    }

    public void mostrarEstudiantes() {
        for (Estudiante estudiante : listaEstudiantes) {
            System.out.println(estudiante);
        }
    }

    public Estudiante buscarEstudiantePorMatricula(String matricula) {
        for (Estudiante estudiante : listaEstudiantes) {
            if (estudiante.getMatricula().equals(matricula)) {
                return estudiante;
            }
        }
        return null;
    }

    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }
}
