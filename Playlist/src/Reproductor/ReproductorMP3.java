package Reproductor;

public class ReproductorMP3 {
    protected PlayList playlist;
    protected int indiceActual;

    protected boolean reproduciendo;
    protected boolean pausado;

    public ReproductorMP3() {
        this.playlist = null;
        this.indiceActual = -1;
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

    public void play() { 
        Cancion actual = getCancionActual();
        if(actual != null) {
            reproduciendo = true;
            pausado = false;

            System.out.println("Reproduciendo: " + actual);
        }
    }

    public void pause() {
        if(this.reproduciendo) {
            this.reproduciendo = false;
            this.pausado = true;

            System.out.println("Pausado ");
        }
    }

    public void stop() {
        this.reproduciendo = false;
        this.pausado = false;

        System.out.println("Detenido");
    }

    public void siguiente() {
        if(this.playlist != null) {
            if(this.indiceActual < this.playlist.tamanio() - 1) {
                this.indiceActual++;
                System.out.println("Actual: "+ getCancionActual());
            }
        }
        else {
            if(this.indiceActual >= this.playlist.tamanio() - 1) {
                System.out.println("No hay siguiente cancion");
            }
        }
    }

    public void anterior() {
        if(playlist != null) {
            if(this.indiceActual > 0) {
                indiceActual--;

                System.out.println("Actual: "+ getCancionActual());
            }
        }
    }

}
