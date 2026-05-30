package Reproductor;

import java.io.File;

import javafx.scene.media.Media; //Usando la libreria MediaPlayer
import javafx.scene.media.MediaPlayer;

public class ReproductorMP3 {
    protected PlayList playlist;
    protected int indiceActual;

    protected MediaPlayer player; // Declaracion del atributo MediaPlayer

    protected boolean reproduciendo;
    protected boolean pausado;

    public ReproductorMP3() {
        this.playlist = null;
        this.indiceActual = -1;
        this.player = null;
        this.reproduciendo = false;
        this.pausado = false;
    }

    public void cargarPlayList(PlayList playlist) {
        this.playlist = playlist;

        if (this.playlist != null && this.playlist.tamanio() > 0) {
            indiceActual = 0;
        } 
        else {
            indiceActual = -1;
        }
    }

    public Cancion getCancionActual() {
        Cancion cancion = null;

        if(this.playlist != null && this.indiceActual >= 0 && this.indiceActual < this.playlist.tamanio()) {
            cancion = (Cancion)this.playlist.devolver(this.indiceActual);
        }

        return cancion;
    }

    private void cargarCancionActual() { //Metodo privado para agregar una cancion
        Cancion actual = getCancionActual();

        if(actual != null ){
            if(this.player != null){
                this.player.stop();
                this.player.dispose();
            }
            File archivo = new File(actual.getRuta());

            Media media = new Media(archivo.toURI().toString());

            this.player = new MediaPlayer(media);

        }
    }

    public void play() { 
        Cancion actual = getCancionActual();
        if(actual != null) {
            if(this.player == null) {
                cargarCancionActual();
            }
            
                this.player.play();
                reproduciendo = true;
                pausado = false;

                System.out.println("Reproduciendo: " + actual);
            
        }
    }

    public void pause() {
        if(this.player != null) {
            this.player.pause();
            this.reproduciendo = false;
            this.pausado = true;

            System.out.println("Pausado ");
        }
    }

    public void stop() {
        if(this.player != null){
            this.player.stop();
            this.reproduciendo = false;
            this.pausado = false;

            System.out.println("Detenido");
        }
    }

    public void siguiente() {
        if(this.playlist != null && this.indiceActual < this.playlist.tamanio() - 1) {
            boolean flag = reproduciendo;
            this.indiceActual++;
            cargarCancionActual();

            System.out.println("Actual: "+ getCancionActual());
            
            if(flag) {
                play();
            }
        }
        else{
            System.out.println("No hay siguiente cancion...");
        }
    }

    public void anterior() {
        if(playlist != null && this.indiceActual > 0) {
            boolean flag = this.reproduciendo;
            this.indiceActual--;

            cargarCancionActual();

            System.out.println("Actual: "+ getCancionActual());

            if(flag) {
                play();
            }
        }
    }

}
