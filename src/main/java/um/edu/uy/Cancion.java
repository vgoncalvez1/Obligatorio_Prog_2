package um.edu.uy;

import java.util.List;
import java.util.Objects;

public class Cancion {
    private String nombre;
    private List<Artista> artistas;
    private int tempo;

    public Cancion(String nombre, List<Artista> artistas, int tempo){
        this.nombre = nombre;
        this.artistas = artistas;
        this.tempo = tempo;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public List<Artista> getArtistas(){
        return artistas;
    }

    public void setArtistas(List<Artista> artistas){
        this.artistas = artistas;
    }

    public int getTempo(){
        return tempo;
    }

    public void setTempo(int tempo){
        this.tempo = tempo;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cancion cancion = (Cancion) o;
        return tempo == cancion.tempo &&
                Objects.equals(nombre, cancion.nombre) &&
                Objects.equals(artistas, cancion.artistas);
    }

    @Override
    public int hashCode(){
        return Objects.hash(nombre, artistas, tempo);
    }

    @Override
    public String toString(){
        return "Cancion{" + "Nombre=" + nombre + "|" + "Artistas= " + artistas +
                "tempo=" + tempo + '}';
    }
}
