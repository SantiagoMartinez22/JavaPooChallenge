
import models.*;
import Services.Biblioteca;

public class Main {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();


        Usuario estudiante = new Estudiante("Santiago Martinez", "S123", "Ingeniería");
        Usuario empleado = new Empleado("Ana Gómez", "E456", "Biblioteca");

        biblioteca.registrarUsuario(estudiante);
        biblioteca.registrarUsuario(empleado);


        Libro libro1 = new Libro("El Quijote", "Miguel de Cervantes", "ISBN123");
        Libro libro2 = new Libro("Cien Años de Soledad", "Gabriel García Márquez", "ISBN456");

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);


        biblioteca.prestarLibro("ISBN123", estudiante);
        biblioteca.prestarLibro("ISBN456", empleado);


        biblioteca.mostrarLibrosDisponibles();

    }
}

