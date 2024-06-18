package um.edu.uy;
import java.util.Date;
public class Top50 {
    private Cancion cancion;
    private int posicion;
    private String pais;
    private Date date;

    public Top50(Cancion cancion, int posicion, String pais, Date date){
        this.cancion =cancion;
        this.date =date;
        this.pais = pais;
        this.posicion= posicion;
    }

    public Cancion getCancion(){
        return cancion;
    }

    public void setCancion(Cancion cancion){
        this.cancion = cancion;
    }

    public Date getDate(){
        return date;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public int getPosicion(){
        return posicion;
    }

    public void setPosicion(int posicion){
        this.posicion = posicion;
    }

    public String getPais(){
        return pais;
    }

    public void setPais(String pais){
        this.pais= pais;
    }

    @Override
    public String toString(){
        return "top50{" + "Cancion=" + cancion + "Posicion=" + posicion +
                "Pais=" + pais + "Date=" + date + '}';
    }
}
