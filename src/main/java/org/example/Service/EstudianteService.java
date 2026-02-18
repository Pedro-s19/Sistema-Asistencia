package Service;

import Model.Estudiante;

import java.util.List;

public interface EstudianteService {

    Estudiante registrarEstudiante(String id, String nombre);
    // registra un nuevo estudiante
    Estudiante buscarEstudiante(String id);
    // buscar estudiante por id
    List<Estudiante> listaEstudiantes();
}
