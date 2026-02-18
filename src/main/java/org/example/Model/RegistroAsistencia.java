package org.example.Model;

import java.time.LocalDate;

public class RegistroAsistencia {

    private Estudiante estudiante; // Estudiante
    private LocalDate fecha; //fecha del registro
    private EstadoAsistencia estado; //estado(Asistio/No asistio

    public RegistroAsistencia() {
    }

    public RegistroAsistencia(Estudiante estudiante, LocalDate fecha, EstadoAsistencia estado) {
        this.estudiante = estudiante;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public EstadoAsistencia getEstado() {
        return estado;
    }

    public void setEstado(EstadoAsistencia estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "RegistroAsistencia{" +
                "estudiante=" + estudiante +
                ", fecha=" + fecha +
                ", estado=" + estado +
                '}';
    }
}
