package Reproductor;

public class Cancion {
    protected String titulo;
    protected String artista;
    protected String album;
    protected String ruta; 
    protected double duracion;

    public Cancion (String titulo, String artista, String album, String ruta, double duracion) {
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.ruta = ruta;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getArtista() {
        return this.artista;
    }

    public String getAlbum() {
        return this.album;
    }

    public String getRuta() {
        return this.ruta;
    }

    public double getDuracion() {
        return this.duracion;
    }

    public String toString() {
        return "Titulo: " + this.titulo + "\n Artista: " + this.artista + "\n Album: " + this.album + "\n Duracion: " + this.duracion;
    }

}
