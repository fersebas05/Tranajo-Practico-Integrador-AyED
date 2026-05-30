package Reproductor;

import java.io.File;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.Mp3File;


public class LectorMP3 {
    public Cancion leer(File archivo) {
        Cancion cancion = null;

        try {
            Mp3File mp3file = new Mp3File(archivo);
        
            String titulo = "";
            String artista = "";
            String album = "";

            if(mp3file.hasId3v2Tag()) {
                ID3v2 tag = mp3file.getId3v2Tag();
                titulo = tag.getTitle();
                artista = tag.getArtist();
                album = tag.getAlbum();
            }
            else if(mp3file.hasId3v1Tag()) {
                ID3v1 tag = mp3file.getId3v1Tag();

                titulo = tag.getTitle();
                artista = tag.getArtist();
                album = tag.getAlbum();
            }
            long duracion = mp3file.getLengthInSeconds();

            if(titulo == null  || titulo.isEmpty()) {
                titulo = archivo.getName();
            }
            
            cancion = new Cancion(titulo, artista, album, archivo.getAbsolutePath(), duracion);
        }
        catch(Exception e) {
            System.out.println("Error al leer el archivo MP3: " + e.getMessage());
        }
        return cancion;
    }

}
