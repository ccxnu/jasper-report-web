package org.example;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaGestionEstudiantes sistema = new SistemaGestionEstudiantes();
        boolean salir = false;

        while (!salir) {
            System.out.println("Sistema de Gestión de Estudiantes");
            System.out.println("1. Agregar Estudiante");
            System.out.println("2. Mostrar Estudiantes");
            System.out.println("3. Buscar Estudiante por Matrícula");
            System.out.println("4. Generar Reporte");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombre del estudiante: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese matrícula del estudiante: ");
                    String matricula = scanner.nextLine();
                    System.out.print("Ingrese calificación promedio del estudiante: ");
                    double calificacion = scanner.nextDouble();
                    scanner.nextLine();  // Consumir el salto de línea restante
                    Estudiante estudiante = new Estudiante(nombre, matricula, calificacion);
                    sistema.agregarEstudiante(estudiante);
                    break;
                case 2:
                    sistema.mostrarEstudiantes();
                    break;
                case 3:
                    System.out.print("Ingrese matrícula del estudiante a buscar: ");
                    String mat = scanner.nextLine();
                    Estudiante est = sistema.buscarEstudiantePorMatricula(mat);
                    if (est != null) {
                        System.out.println("Estudiante encontrado: " + est);
                    } else {
                        System.out.println("Estudiante no encontrado.");
                    }
                    break;
                case 4:
                    generarReporte(sistema.getListaEstudiantes());
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }

        scanner.close();
    }

    public static void generarReporte(ArrayList<Estudiante> estudiantes) {
        try {
            String reportPath = "src/main/resources/reporteEstudiantes.jrxml";

            // Verificar que el archivo existe y puede ser leído
            File reportFile = new File(reportPath);
            if (!reportFile.exists() || !reportFile.canRead()) {
                throw new RuntimeException("El archivo JRXML no existe o no puede leerse: " + reportPath);
            }

            // Cargar el diseño del reporte
            JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);


            // Llenar el reporte con datos
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(estudiantes);
            Map<String, Object> parameters = new HashMap<>();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

            // Visualizar el reporte
            JasperViewer.viewReport(jasperPrint, false);

            // Exportar el reporte a PDF
            JasperExportManager.exportReportToHtmlFile(jasperPrint, "reporteEstudiantes.html");
        } catch (JRException e) {
            e.printStackTrace();
        }
    }

}