package um.edu.uy;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class DataLoader {
    public void cargarDatos(String filePath){
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
            while ((line = br.readLine() != null)){
                String[] values = line.split(",");
                Data data = dateFormat.parse(values[0]);
                String pais = values[1];
                int posicion = Integer.parseInt(values[2]);
                String NombreCancion = values[3];
                String NombreArtista = values[4];
                int tempo = Integer.parseInt(values[5]);

                Artista artista = new Artista(NombreArtista);
                Cancion cancion = new Cancion(NombreCancion, List.of(artista), tempo);
                Top50 top50 = new Top50(cancion, posicion, pais, data);

                //Completar funcion
                //Completar funcion
            }
        } catch (IOException | ParseException e){
            e.printStackTrace();
        }

        }

    }
