package um.edu.uy;

import java.util.Objects;
public class Artista{
    private String nombre;

    public Artista(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null & getClass() != o.getClass()) return false;
        Artista artista = (Artista) o;
        return Objects.equals(nombre, artista.nombre);
    }

    @Override
    public int hashCode(){
        return Objects.hash(nombre);
    }

    @Override
    public String toString(){
        return "Artista{nombre='" + nombre + "'}";
    }
}
