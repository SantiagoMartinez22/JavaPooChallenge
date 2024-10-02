
import models.*;
import Services.Biblioteca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//intento de crear un sistema con java swing pero aun en proceso, en el main se prueba la funcionalidad normal

public class SistemaBiblioteca extends JFrame {
    private Biblioteca biblioteca;

    public SistemaBiblioteca() {
        biblioteca = new Biblioteca();
        setTitle("Sistema de Gestión de Biblioteca");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));

        JButton btnRegistrarUsuario = new JButton("Registrar Usuario");
        JButton btnAgregarLibro = new JButton("Agregar Libro");
        JButton btnPrestarLibro = new JButton("Prestar Libro");
        JButton btnMostrarLibros = new JButton("Mostrar Libros Disponibles");

        panel.add(btnRegistrarUsuario);
        panel.add(btnAgregarLibro);
        panel.add(btnPrestarLibro);
        panel.add(btnMostrarLibros);


        btnRegistrarUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarUsuario();
            }
        });

        btnAgregarLibro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarLibro();
            }
        });

        btnPrestarLibro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                prestarLibro();
            }
        });

        btnMostrarLibros.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarLibrosDisponibles();
            }
        });

        add(panel);
    }


    private void registrarUsuario() {
        JTextField nombreField = new JTextField(10);
        JTextField idField = new JTextField(10);
        String[] opciones = {"Estudiante", "Empleado"};
        JComboBox<String> tipoUsuarioBox = new JComboBox<>(opciones);
        JTextField extraField = new JTextField(10);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Nombre:"));
        myPanel.add(nombreField);
        myPanel.add(new JLabel("ID:"));
        myPanel.add(idField);
        myPanel.add(new JLabel("Tipo de Usuario:"));
        myPanel.add(tipoUsuarioBox);
        myPanel.add(new JLabel("Carrera/Departamento:"));
        myPanel.add(extraField);

        int result = JOptionPane.showConfirmDialog(null, myPanel, "Registrar Usuario", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String nombre = nombreField.getText();
            String id = idField.getText();
            String extra = extraField.getText();
            Usuario usuario;

            if (tipoUsuarioBox.getSelectedItem().equals("Estudiante")) {
                usuario = new Estudiante(nombre, id, extra);
            } else {
                usuario = new Empleado(nombre, id, extra);
            }
            biblioteca.registrarUsuario(usuario);
            JOptionPane.showMessageDialog(this, "Usuario registrado con éxito.");
        }
    }


    private void agregarLibro() {
        JTextField tituloField = new JTextField(10);
        JTextField autorField = new JTextField(10);
        JTextField isbnField = new JTextField(10);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Título:"));
        myPanel.add(tituloField);
        myPanel.add(new JLabel("Autor:"));
        myPanel.add(autorField);
        myPanel.add(new JLabel("ISBN:"));
        myPanel.add(isbnField);

        int result = JOptionPane.showConfirmDialog(null, myPanel, "Agregar Libro", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String titulo = tituloField.getText();
            String autor = autorField.getText();
            String isbn = isbnField.getText();
            Libro libro = new Libro(titulo, autor, isbn);
            biblioteca.agregarLibro(libro);
            JOptionPane.showMessageDialog(this, "Libro agregado con éxito.");
        }
    }


    private void prestarLibro() {
        JTextField isbnField = new JTextField(10);
        JTextField idUsuarioField = new JTextField(10);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("ISBN del libro:"));
        myPanel.add(isbnField);
        myPanel.add(new JLabel("ID del Usuario:"));
        myPanel.add(idUsuarioField);

        int result = JOptionPane.showConfirmDialog(null, myPanel, "Prestar Libro", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String isbn = isbnField.getText();
            String idUsuario = idUsuarioField.getText();
            Usuario usuario = biblioteca.buscarUsuarioPorId(idUsuario);

            if (usuario != null) {
                biblioteca.prestarLibro(isbn, usuario);
            } else {
                JOptionPane.showMessageDialog(this, "Usuario no encontrado.");
            }
        }
    }


    private void mostrarLibrosDisponibles() {
        biblioteca.mostrarLibrosDisponibles();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SistemaBiblioteca().setVisible(true);
            }
        });
    }
}
