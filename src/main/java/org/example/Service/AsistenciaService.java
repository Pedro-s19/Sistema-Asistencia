package Service;

import Model.EstadoAsistencia;
import Model.Estudiante;
import Model.RegistroAsistencia;

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
