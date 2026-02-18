package org.example.Controller;

import org.example.Model.EstadoAsistencia;
import org.example.Model.Estudiante;
import org.example.Model.RegistroAsistencia;
import org.example.Service.AsistenciaService;
import org.example.Service.EstudianteService;
import org.example.View.AsistenciaView;

import javax.swing.text.View;
import java.time.LocalDate;
import java.util.List;

public class AsistenciaController {

    private final EstudianteService estudianteService;// Servicio para operaciones con estudiantes
    private final AsistenciaService asistenciaService;// Servicio operaciones por asistencia
    private final AsistenciaView view;// vista para mostrar la informacion

    public AsistenciaController(EstudianteService estudianteService, AsistenciaService asistenciaService, AsistenciaView view) {
        this.estudianteService = estudianteService;
        this.asistenciaService = asistenciaService;
        this.view = view;
    }

    public Estudiante registrarEstudiante(String id, String nombre)
    {
        try{
            // Llama al servicio para registar el estudiante
            Estudiante estudiante = estudianteService.registrarEstudiante(id,nombre);
            //Muetra mensaje de exito y los datos del estudiante
            view.mostrarMensaje(" Estudiante registrado ");
            view.mostrarEstudiante(estudiante);
            return estudiante;

        }
        catch (IllegalArgumentException e)
        {
            // Si ocurre un error, lo muestra
            view.mostrarMensaje(" Error: "+ e.getMessage());
            return null;
        }
    }
    public RegistroAsistencia marcarAsistencia(String estudianteId, LocalDate fecha, EstadoAsistencia estado)
    {
        try{
            // Busca al estudiante por su id
            Estudiante estudiante = estudianteService.buscarEstudiante(estudianteId);
            //Marca la asistencia usando servicio asistencia
            RegistroAsistencia registro = asistenciaService.marcarAsistencia(estudiante,fecha,estado);
            view.mostrarMensaje(" Asistencia marcada correctamente");
            view.mostrarRegistro(registro);
            return registro;

        }
        catch (IllegalArgumentException | IllegalStateException e)
        {
            // Captura errores: estudiante no encontrado o registro duplicado
            view.mostrarMensaje( " Error: "+ e.getMessage());
            return null;
        }
    }
    public void consultarAsistencia(String estudianteId)
    {
        try{
            // busca al estudiante por id
            Estudiante estudiante = estudianteService.buscarEstudiante(estudianteId);
            // Obtiene la lista de registros de ese estudiante
            List<RegistroAsistencia> registros = asistenciaService.consultarAsisEstudiante(estudiante);
            //Muestra los registros usando la vista
            view.mostrarRegistros(registros, estudiante.getNombre());

        }
        catch (IllegalArgumentException e)
        {
            view.mostrarMensaje(" Error: " + e.getMessage());
        }
    }
    public void eliminarRegistro(String estudianteId, LocalDate fecha)
    {
        try{
            //busca el estudiante por id
            Estudiante estudiante = estudianteService.buscarEstudiante(estudianteId);
            // llama al servicio para eliminar el registro
            asistenciaService.eliminarRegistro(estudiante,fecha);
            view.mostrarMensaje( " Registro eliminado");

        }
        catch (IllegalArgumentException e)
        {
            view.mostrarMensaje( " Error: " + e.getMessage());
        }
    }

}
