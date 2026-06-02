package GUI;

//Actualizado 02 / 06 / 2026

import java.io.File;

import Reproductor.*;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Ventana extends Application{
    protected Button button_addFiles;

    protected Button button_play;
    protected Button button_pause;
    protected Button button_stop;

    protected Button button_prev;
    protected Button button_next;

    protected ReproductorMP3 reproductor;
    protected PlayList playlist;
    protected LectorMP3 lector;

    protected Button button_ordenarTitulo;
    protected Button button_ordenarArtista; 
    protected Button button_ordenarAnio;
    
    public void start(Stage stage) {
        inicializarComponentes();

        Scene escena = new Scene(crearLayout(), 500, 300);

        stage.setTitle("Reproductor MP3");
        stage.setScene(escena);
        stage.show();

    }

    private void inicializarComponentes() {
        this.reproductor = new ReproductorMP3();
        this.playlist = new PlayList("Musica");
        this.lector = new LectorMP3();

        this.button_addFiles = new Button("Add Files");

        this.button_prev = new Button("<<");
        this.button_play = new Button("Play");
        this.button_pause = new Button("Pause");
        this.button_stop = new Button("Stop");
        this.button_next = new Button(">>");
        this.button_ordenarTitulo = new Button("Ordenar por Título");
        this.button_ordenarArtista = new Button("Ordenar por Artista");
        this.button_ordenarAnio = new Button("Ordenar por Año");

        registrarEventos();
    }

    private void registrarEventos() {
        button_addFiles.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos MP3", "*.mp3"));

            File archivo = fileChooser.showOpenDialog(null);


            if(archivo != null) {
                Cancion cancion = lector.leer(archivo);
                if (cancion != null) {
                    this.playlist.insertar(cancion, playlist.tamanio());
                    this.reproductor.cargarPlayList(this.playlist);
                    System.out.println("Cancion agregada: "+ cancion);
                }
                else{
                    System.out.println("No se puede leer el archivo.");
                }
                
            }

        });

        this.button_prev.setOnAction(e -> {
            System.out.println("ANTERIOR");
            this.reproductor.anterior();
        });

        this.button_play.setOnAction(e -> {
            System.out.println("PLAY");
            this.reproductor.play();
        });
        this.button_pause.setOnAction(e -> this.reproductor.pause());
        this.button_stop.setOnAction(e -> this.reproductor.stop());

        this.button_next.setOnAction(e -> {
            System.out.println("SIGUIENTE");
            this.reproductor.siguiente();
        });

        this.button_ordenarTitulo.setOnAction(e -> {
            this.playlist.ordenar(PlayListAbs.OrdenCriterio.TITULO);
            this.reproductor.cargarPlayList(this.playlist);
        });
        this.button_ordenarArtista.setOnAction(e -> {
            this.playlist.ordenar(PlayListAbs.OrdenCriterio.ARTISTA);
            this.reproductor.cargarPlayList(this.playlist);
        });
        this.button_ordenarAnio.setOnAction(e -> {
            this.playlist.ordenar(PlayListAbs.OrdenCriterio.ANIO);
            this.reproductor.cargarPlayList(this.playlist);
        });
    }

    private VBox crearLayout() {
        HBox controles = new HBox();
        controles.setSpacing(10);
        controles.getChildren().addAll(button_prev,button_play, button_pause, button_stop, button_next);
        controles.setAlignment(Pos.CENTER);

        HBox ordenar = new HBox();
        ordenar.setSpacing(10);
        ordenar.getChildren().addAll(button_ordenarTitulo, button_ordenarArtista, button_ordenarAnio);
        ordenar.setAlignment(Pos.CENTER);

        VBox root = new VBox();
        root.setSpacing(20);
        root.getChildren().addAll(button_addFiles, controles, ordenar);
        root.setAlignment(Pos.CENTER);

        return root;
    }

}
