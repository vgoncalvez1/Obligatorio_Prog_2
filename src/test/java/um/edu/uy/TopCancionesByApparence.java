package um.edu.uy;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopCancionesByApparence {
    private List<Top50> entries;

    public TopCancionesByApparence(List<Top50> entries){
        this.entries = entries;
    }

    public List<Cancion> getEntries(Date date) {
        Map<Cancion, Integer> cancioncount = new HashMap<>();

        for(Top50 entry : entries){
            if (entry.getDate().equals(date)){
                Cancion cancion = entry.getCancion();
                cancioncount.put(cancion, cancioncount.getOrDefault(cancion, 0) + 1);
            }
        }

        return cancioncount.entrySet().stream()
                .sorted(Map.Entry.<Cancion, Integer> comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
