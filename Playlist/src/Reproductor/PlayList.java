package Reproductor;
import Contenedores.*;

public class PlayList extends Lista1DLinkedList {
    protected String nombre;

    public PlayList(String nombre) {
        super();
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // public void agregarCancion(Cancion cancion) {
    //     this.insertar(cancion, tamanio());
    // }

    // public void eliminarCancion(int posicion) {
    //     this.eliminar(posicion);
    // }

    // public int cantidadCanciones() {
    //     return this.tamanio();
    // }

    public boolean iguales(Object elementoL, Object elemento) {
        Cancion c1 = (Cancion) elementoL;
        Cancion c2 = (Cancion) elemento;

        String r1 = c1.getRuta();
        String r2 = c2.getRuta();

        return r1.equals(r2);
    }

}
