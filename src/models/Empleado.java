package models;

public class Empleado extends Usuario {
    private String departamento;

    public Empleado(String nombre, String id, String departamento) {
        super(nombre, id);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    @Override
    public String getTipoUsuario() {
        return "Empleado";
    }

    @Override
    public String toString() {
        return super.toString() + ", Empleado [Departamento=" + departamento + "]";
    }
}

