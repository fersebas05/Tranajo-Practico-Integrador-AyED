package Reproductor;
//USANDO MEDIA PLAYER
import java.io.File;

import javafx.embed.swing.JFXPanel;

public class test2 {

    public static void main(String[] args) {

        new JFXPanel();

        LectorMP3 lector = new LectorMP3();

        Cancion c1 = lector.leer(
            new File(
                "C:\\Users\\sebas\\Downloads\\Harry Styles - Sign of the Times (Official Video).mp3"
            )
        );

        System.out.println(c1);

        PlayList playlist = new PlayList("Musica");

        playlist.insertar(c1, 0);

        ReproductorMP3 mp3 = new ReproductorMP3();

        mp3.cargarPlayList(playlist);

        mp3.play();

        
    }
}
