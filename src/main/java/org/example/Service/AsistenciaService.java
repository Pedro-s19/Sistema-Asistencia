package org.example.Service;

import org.example.Model.EstadoAsistencia;
import org.example.Model.Estudiante;
import org.example.Model.RegistroAsistencia;

import java.time.LocalDate;
import java.util.List;

public interface AsistenciaService {
    RegistroAsistencia marcarAsistencia(Estudiante estudiante, LocalDate fecha, EstadoAsistencia estado);
    // Marca asistencia para un estudiante en una fecha
    List<RegistroAsistencia> consultarAsisEstudiante(Estudiante estudiante);
    //Consulta todos los registros de un estudiante
    void eliminarRegistro(Estudiante estudiante, LocalDate fecha);
    //Elimina un registro especifico

}
