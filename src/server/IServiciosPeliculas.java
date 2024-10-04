package server;

import dominio.Pelicula;

public interface IServiciosPeliculas {
    public void listarPelicula();

    public void agregarPelicula(Pelicula pelicula);

    public void buscarPelicula(Pelicula pelicula);
}
