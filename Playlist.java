package Mp3;

import java.util.LinkedList;
import java.util.ListIterator;

public class Playlist {

    private LinkedList<Cancion> list = new LinkedList<>();
    private ListIterator<Cancion> it = list.listIterator();
    private Cancion actual = null;

    public Playlist() {

    }

    // ------------------ Agregar -----------------------
    public void agregarCancion(Cancion cancion) {
        list.addLast(cancion);
        if (actual == null) {
            it = list.listIterator();
            if (it.hasNext()) {
                actual = it.next();
            }
        } else {
            int posicion = list.indexOf(actual);
            it = list.listIterator(Math.min(posicion + 1, list.size()));
        }

    }

    public void agregarEn(int index, Cancion cancion) {
        list.add(index, cancion);
        ajustar();
    }

    public void agregarPrimero(Cancion cancion) {
        list.addFirst(cancion);
        ajustar();
    }

    public void agregarUltimo(Cancion cancion) {
        list.addLast(cancion);
        ajustar();
    }

    // ------------------ Navegar -----------------------
    public Cancion Siguiente() {
        if (isVacia()) {
            System.out.println("Playslist Vacia - Agrega algo!");
            return null;
        }
        if (!it.hasNext()) {
            it = list.listIterator();
        }
        actual = it.next();
        System.out.println("Reproduciendo:" + actual);
        return actual;
    }

    public Cancion Anterior() {
        if (isVacia()) {
            System.out.println("Playslist Vacia - Agrega algo!");
            return null;
        }
        if (!it.hasPrevious()) {
            it = list.listIterator(list.size());
        }
        actual = it.previous();
        System.out.println("Reproduciendo:" + actual);
        return actual;
    }

    // ------------------ Eliminar -----------------------
    public Cancion EliminarUltimo() {
        if (isVacia()) return null;
        
        Cancion eliminado = list.removeLast();
        ajustar();
        return eliminado;
    }

    public Cancion EliminarPrimero() {
        if (isVacia()) return null;
        
        Cancion eliminado = list.removeFirst();
        ajustar();
        return eliminado;
    }
     
    
    public Cancion EliminarPosicion(int index){
        if (isVacia()) return null;
        
        Cancion eliminado = list.remove(index);
        ajustar();
        return eliminado;
    }
    // ------------------ Ajustar -----------------------
    private void ajustar() {
        if (actual == null) {
            it = list.listIterator();
        } else {
            int posicion = list.indexOf(actual);
            if (posicion == -1) {
                it = list.listIterator();
                actual = null;
            }
        }
    }

    // ------------------ Comprobar -----------------------
    public boolean isVacia() {
        return list.isEmpty();
    }

    // ------------------ Mostrar -----------------------
    public Cancion MostrarPosicion(int index) {

        if (index >= 0 || index < list.size()) {
            return list.get(index);
        } else {
            return null;
        }

    }

    public Cancion MostrarPrimera(int index) {
        return (isVacia()) ? null : list.getFirst();

    }

    public Cancion MostrarUltima(int index) {
        return (isVacia()) ? null : list.getLast();
    }

    public void mostrarPlaylist() {
        if (list.isEmpty()) {
            System.out.println("Playlist vacia");

        } else {
            for (Cancion s : list) {
                System.out.println(s);
            }
        }

    }

    public void Actual() {
        if (actual == null) {
            System.out.println("No estas reproduciendo nada...");
        } else {
            System.out.println("Reproduciendo: " + actual);
        }

    }
}
