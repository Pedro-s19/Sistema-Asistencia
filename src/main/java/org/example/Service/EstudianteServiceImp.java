package org.example.Service;

import org.example.Model.Estudiante;

import java.util.ArrayList;
import java.util.List;

public class EstudianteServiceImp implements EstudianteService{

    // Lista que simula una base de datos para los estudiantes
    private final List<Estudiante> estudiantes = new ArrayList<>();

    public Estudiante registrarEstudiante(String id, String nombre)
    {
        // verifica si existe un estudiante con el mismo id
        for(Estudiante e : estudiantes)
        {
            if(e.getId().equals(id))
            {
                throw new IllegalArgumentException(" Ya existe un estudiante con ese ID ");

            }
        }
        // Crea un nuevos estudiante y lo agrega a la lista
        Estudiante nuevo = new Estudiante(id, nombre);
        estudiantes.add(nuevo);
        return nuevo;

    }
    public Estudiante buscarEstudiante(String id)
    {
        for(Estudiante e : estudiantes)
        {
            if(e.getId().equals(id))
            {
                return e;
            }
        }
        throw new IllegalArgumentException(" El estudiante no fue encontrado ");

    }
    public List<Estudiante> listaEstudiantes()
    {
        // devuelve una nueva lista con los mismos elementos
        return new ArrayList<>(estudiantes);
    }
}
