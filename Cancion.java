package Mp3;

public class Cancion {

    private String nombre;
    private String artista;
    private int duracion;

    public Cancion(String nombre, String artista, int duracion) {
        this.nombre = nombre;   
        this.artista = artista;
        this.duracion = duracion;
    }

    public Cancion() {
    }

    public String getNombre() {
        return nombre;
    }

    public String getArtista() {
        return artista;
    }

    public int getDuracion() {
        return duracion;
    }
    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "[" + nombre + " de -" + artista + " |" + duracion + "|" + ']';
    }

}
