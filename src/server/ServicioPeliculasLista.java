package server;
import dominio.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class ServicioPeliculasLista implements IServiciosPeliculas {
    private final List<Pelicula> peliculas; //List en un interface

    public ServicioPeliculasLista(){
        this.peliculas = new ArrayList<>(); //Con esto lla estamos inicialicando la lista de peliculas
    }

    //Dava error por eso implemente estos metodos
    @Override
    public void listarPelicula() {
        System.out.println("Listado de Peliculas...");
        peliculas.forEach(System.out::println);
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        System.out.println("Se agrego la pelicula: " + pelicula);
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        // Regresar el iundice de la pelicula encontrada en la lista
        var indece = peliculas.indexOf(pelicula);
        if (indece == -1)
            System.out.println("No se encontro la pelicula: " + pelicula);
        else
            System.out.println("Pelicula encontrar en el indece: " + indece);
    }

    public static void main(String[] args) {
        //Creamos algunos objetos de tipo pelicula
        var pelicula1 = new Pelicula("Batman");
        var pelicula2 = new Pelicula("Superman");

        //Creamos el servicos (patron de dienio service)
        IServiciosPeliculas servicioPeliculas = new ServicioPeliculasLista();

        //Agregamos las peliculas a la lista
        servicioPeliculas.agregarPelicula(pelicula1);
        servicioPeliculas.agregarPelicula(pelicula2);

        //Listamos las peliculas
        servicioPeliculas.listarPelicula();

        // Buscamos una pelicula
        // Se debe implementar el metodo equals y hashCode
        servicioPeliculas.buscarPelicula(new Pelicula("olboy"));
    }
}
