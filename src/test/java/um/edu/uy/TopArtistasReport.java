package um.edu.uy;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopArtistasReport {
    private List<Top50> entries;

    public TopArtistasReport(List<Top50> entries){
        this.entries = entries;
    }

    public List<Artista> gettop7Artistas(Date starDate, Date endDate){
        Map<Artista, Integer> artistaCount = new HashMap<>();

        for (Top50 entry : entries){
            Date entryDate = entry.getDate();
            if (!entryDate.before(starDate) && !entryDate.after(endDate)){
                for (Artista artista : entry.getCancion().getArtistas()){
                    artistaCount.put(artista, artistaCount.getOrDefault(artista, 0) + 1);
                }
            }
        }

        return artistaCount.entrySet().stream()
                .sorted(Map.Entry.<Artista, Integer> comparingByValue().reversed())
                .limit(7)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
