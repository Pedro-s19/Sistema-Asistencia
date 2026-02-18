package org.example.Service;

import org.example.Model.EstadoAsistencia;
import org.example.Model.Estudiante;
import org.example.Model.RegistroAsistencia;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AsistenciaServiceImp implements AsistenciaService {

    // Lista que simula una base de datos para los registros de asistencia
    private final List<RegistroAsistencia> registros = new ArrayList<>();

    public RegistroAsistencia marcarAsistencia(Estudiante estudiante, LocalDate fecha, EstadoAsistencia estado)
    {
        // Verfica si ta existe un registro para el mismo estudiante en la misma fecha
        for(RegistroAsistencia r : registros)
        {
            if(r.getEstudiante().getId().equals(estudiante.getId()) && r.getFecha().equals(fecha))
            {
                throw new IllegalStateException( " Ya existe un registro para el estudinate ");
            }
        }
        // si no existe crea un nuevo registro y lo agrega a la lista
        RegistroAsistencia nuevo = new RegistroAsistencia(estudiante,fecha,estado);
        registros.add(nuevo);
        return nuevo;
    }

    @Override
    public List<RegistroAsistencia> consultarAsisEstudiante(Estudiante estudiante) {
        List<RegistroAsistencia> resultado = new ArrayList<>();
        //Recorre todos los registros y hace un filtro por estudiante
        for(RegistroAsistencia r : registros)
        {
            if(r.getEstudiante().getId().equals(estudiante.getId()))
            {
                resultado.add(r);
            }
        }
        return resultado;
    }

    @Override
    public void eliminarRegistro(Estudiante estudiante, LocalDate fecha) {

        RegistroAsistencia encontrado = null;
        //buscar registro que coincida con estudiante y fecha
        for(RegistroAsistencia r : registros)
        {
            if(r.getEstudiante().getId().equals(estudiante.getId()) && r.getFecha().equals(fecha))
            {
                encontrado = r;
                break;
            }
        }
        // si no se esncuentra muestra una excepcion
        if(encontrado == null)
        {
            throw new IllegalArgumentException(" No existe un registro en esa fecha ");
        }
        //elimiar el registro de la lista
        registros.remove(encontrado);

    }

}
