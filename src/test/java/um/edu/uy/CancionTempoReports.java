package um.edu.uy;

import java.util.Date;
import java.util.List;

public class CancionTempoReports {
    private List<Top50> entries;

    public CancionTempoReports(List<Top50> entries){
        this.entries = entries;
    }

    public int getCancionTempoReports(int minTempo, int maxTempo, Date startDate, Date endDate){
        int count = 0;

        for (Top50 entry: entries){
            Date entryDate = entry.getDate();
            if (!entryDate.before(startDate) && !entryDate.after(endDate)){
                int tempo = entry.getCancion().getTempo();
                if (tempo >= minTempo && tempo <= maxTempo){
                    count ++;
                }
            }
        }

        return count;
    }

}
