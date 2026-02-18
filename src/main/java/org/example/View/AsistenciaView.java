package org.example.View;

import org.example.Model.Estudiante;
import org.example.Model.RegistroAsistencia;

import java.util.List;

public class AsistenciaView {

    public void mostrarEstudiante(Estudiante estudiante)
    {
        System.out.println(" ------------ Estudiante ------------ ");
        System.out.println(" ID: "+ estudiante.getId());
        System.out.println(" Nombre:" + estudiante.getNombre());
        System.out.println(" ------------------------------------ ");
    }
    public void mostrarRegistro(RegistroAsistencia registro)
    {
        System.out.println(" ------------ Registro Asistencia ------------ ");
        System.out.println(" Estudiante: " + registro.getEstudiante().getNombre() + " (ID: " + registro.getEstudiante().getId() + ")");
        System.out.println(" Fecha: " + registro.getFecha());
        System.out.println(" Estado: " + registro.getEstado());
        System.out.println(" --------------------------------------------- ");

    }
    public void mostrarRegistros(List<RegistroAsistencia> registros, String estudianteNombre)
    {
        System.out.println("--- Asistencia de:  " + estudianteNombre.toUpperCase() + " ---");
        if (registros.isEmpty()) {
            System.out.println("No hay registros.");
        } else {
            for (RegistroAsistencia r : registros) {
                System.out.println(r.getFecha() + " : " + r.getEstado());
            }
        }
        System.out.println("-------------------------------------");
    }
    public void mostrarMensaje(String mensaje)
    {
        System.out.println(mensaje);
    }
}
