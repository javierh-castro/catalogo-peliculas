package server;

import dominio.Pelicula;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ServicioPeliculasArchivo implements IServiciosPeliculas{
    private final String NOMBRE_ARCHIVO = "peliculas.txt";

    public ServicioPeliculasArchivo() {
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            // Si ya existe el archivo, NO se vuelve a spear
            if (archivo.exists()) {
                System.out.println("El archivo ya existe!");
            } else{
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Se ha creado el archivo");
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error al abrir archivo: " + e.getMessage());
        }
    }

    @Override
    public void listarPelicula() {

    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {

    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {

    }
}
