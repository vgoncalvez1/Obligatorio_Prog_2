package um.edu.uy;

import um.edu.uy.Artista;
import um.edu.uy.Cancion;
import um.edu.uy.Top50;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CargaDatos {
    private List<Top50> entries;
    private Map<String, List<Top50>> paisEntries;
    private Map<Date, List<Top50>> dateEntries;

    public CargaDatos(){
        this.entries = new ArrayList<>();
        this.paisEntries = new HashMap<>();
        this.dateEntries = new HashMap<>();
    }

    public void cargarDatos(String filePath){
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

            while ((line = br.readLine()) != null){
                if (line.startsWith("fecha")) continue;

                String[] values = line.split(",");
                Date data = dateFormat.parse(values[0]);
                String pais = values[1];
                int posicion = Integer.parseInt(values[2]);
                String NombreCancion = values[3];
                String NombreArtista = values[4];
                int tempo = Integer.parseInt(values[5]);

                Artista artista = new Artista(NombreArtista);
                Cancion cancion = new Cancion(NombreCancion, List.of(artista), tempo);
                Top50 top50 = new Top50(cancion, posicion, pais, data);

                addEntry(top50);
            }
        } catch (IOException | ParseException e){
            e.printStackTrace();
        }

    }

    private void addEntry(Top50 entry){
        entries.add(entry);

        paisEntries.computeIfAbsent(entry.getPais(), K -> new ArrayList<>()).add(entry);
        dateEntries.computeIfAbsent(entry.getDate(), K -> new ArrayList<>()).add(entry);
    }

    public List<Top50> getEntries() {
        return entries;
    }

    public Map<Date, List<Top50>> getDateEntries() {
        return dateEntries;
    }

    public Map<String, List<Top50>> getPaisEntries() {
        return paisEntries;
    }
}