package org.example;

import org.example.Controller.AsistenciaController;
import org.example.Model.EstadoAsistencia;
import org.example.Service.AsistenciaService;
import org.example.Service.AsistenciaServiceImp;
import org.example.Service.EstudianteService;
import org.example.Service.EstudianteServiceImp;
import org.example.View.AsistenciaView;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        EstudianteService estudianteService = new EstudianteServiceImp();
        AsistenciaService asistenciaService = new AsistenciaServiceImp();
        AsistenciaView view = new AsistenciaView();
        AsistenciaController controller = new AsistenciaController(estudianteService,asistenciaService,view);

        System.out.println( "--- Registro de estudiantes ---");
        controller.registrarEstudiante("2024001", "Ana Pérez");
        controller.registrarEstudiante("2024002", "Luis Gómez");

        System.out.println("\n--- Marcando asistencias ---");
        controller.marcarAsistencia("2024001", LocalDate.of(2025, 2, 17), EstadoAsistencia.ASISTIO);
        controller.marcarAsistencia("2024001", LocalDate.of(2025, 2, 18), EstadoAsistencia.NO_ASISTIO);
        controller.marcarAsistencia("2024002", LocalDate.of(2025, 2, 17), EstadoAsistencia.ASISTIO);

        System.out.println("\n--- Intento de duplicado ---");
        controller.marcarAsistencia("2024001", LocalDate.of(2025, 2, 17), EstadoAsistencia.ASISTIO);

        System.out.println("\n--- Consultas ---");
        controller.consultarAsistencia("2024001");
        controller.consultarAsistencia("2024002");

        System.out.println("\n--- Eliminar registro del 2025-02-18 de Ana ---");
        controller.eliminarRegistro("2024001", LocalDate.of(2025, 2, 18));
        System.out.println("\n--- Asistencia de Ana después de eliminar ---");
        controller.consultarAsistencia("2024001");

    }
}