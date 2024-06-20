package um.edu.uy;

import java.util.Date;
import java.util.List;

public class ArtistaApparence{
    private List<Top50> entries;

    public ArtistaApparence(List<Top50> entries){
        this.entries = entries;
    }

    public int getArtistApparece(String nombreArtista, Date date){
        int count = 0;

        for (Top50 entry : entries){
            if (entry.getDate().equals(date)){
                for (Artista artista : entry.getCancion().getArtistas()){
                    if (artista.getNombre().equalsIgnoreCase(nombreArtista)){
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
