package presentacion;

import dominio.Pelicula;
import server.IServiciosPeliculas;
import server.ServicioPeliculasArchivo;
import server.ServicioPeliculasLista;

import java.util.Scanner;

public class CatalogoPeliculasApp {
    public static void main(String[] args) {
        var salir = false;
        var consola = new Scanner(System.in);
        // Agregamos la implementacion del servicio
        //IServiciosPeliculas servicioPeliculas = new ServicioPeliculasLista(); //Solo se cambia el codigo del lado derecho
        IServiciosPeliculas servicioPeliculas = new ServicioPeliculasArchivo();
        while (!salir) {
            try {
                mostrarMenu();
                salir = ejecutarOpciones(consola, servicioPeliculas);
            } catch (Exception e) {
                System.out.println("Ocurrio un error: " + e.getMessage());
            }
        }
    }

    private static void mostrarMenu() {
        System.out.print("""
                *** Catalogo de Peliculas ***
                1. Agregar pelicula
                2. Listar peliculas
                3. Buscar pelicula
                4. Salir
                Elige una opcion: 
                """);
    }

    private static boolean ejecutarOpciones(Scanner consola,
                                            IServiciosPeliculas serviciosPeliculas) {
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        switch (opcion) {
            case 1 -> {
                System.out.println("Introduce el nombre de la pelicula: ");
                var nombrePelicula = consola.nextLine();
                serviciosPeliculas.agregarPelicula(new Pelicula(nombrePelicula));//No inteiendo de donde saco la Pelicula
            }
            case 2 -> serviciosPeliculas.listarPelicula();
            case 3 -> {
                System.out.println("Introduce la pelicula a buscar: ");
                var buscar = consola.nextLine();
                serviciosPeliculas.buscarPelicula(new Pelicula(buscar));
            }
            case 4 -> {
                System.out.println("Hasta pronto!");
                salir = true;
            }
            default -> System.out.println("Opcion no reconocida: ");
        }
        return salir;
    }
}