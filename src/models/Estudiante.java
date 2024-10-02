package models;

public class Estudiante extends Usuario {
    private String carrera;

    public Estudiante(String nombre, String id, String carrera) {
        super(nombre, id);
        this.carrera = carrera;
    }

    public String getCarrera() {
        return carrera;
    }

    @Override
    public String getTipoUsuario() {
        return "Estudiante";
    }

    @Override
    public String toString() {
        return super.toString() + ", Estudiante [Carrera=" + carrera + "]";
    }
}

