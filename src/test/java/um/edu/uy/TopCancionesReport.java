package um.edu.uy;

import java.util.Comparator;
import java.util.List;
import java.util.Date;
import java.util.stream.Collectors;

public class TopCancionesReport {
    private List<Top50> entries;

    public TopCancionesReport(List<Top50> entries){
        this.entries = entries;
    }

    public List<Top50> getEntries(String pais, Date date) {
        return entries.stream()
                .filter(entry -> entry.getPais().equals(pais) && entry.getDate().equals(date))
                .sorted(Comparator.comparingInt(Top50::getPosicion))
                .limit(10)
                .collect(Collectors.toList());
    }
}
