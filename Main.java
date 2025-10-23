package Mp3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Selecciona una opcion:");
            System.out.println("1. Agregar cancion al final");
            System.out.println("2. Agregar cancion en indice");
            System.out.println("3. Agregar primera cancion");
            System.out.println("4. Agregar ultima cancion");
            System.out.println("5. Siguiente");
            System.out.println("6. Anterior");
            System.out.println("7. Mostrar cancion actual");
            System.out.println("8. Mostrar Playlist completa");
            System.out.println("9. Mostrar cancion por indice");
            System.out.println("10. Mostrar primera cancion");
            System.out.println("11. Mostrar ultima cancion");
            System.out.println("12. Eliminar ultima cancion");
            System.out.println("13. Eliminar primera cancion");
            System.out.println("14. Eliminar por indice");
            System.out.println("15. Salir");

            int opcion;
            if (!sc.hasNextInt()) {
                System.out.println("Entrada invalida, ingresa un numero.");
                sc.next();
                continue;
            }
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1: {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Artista: ");
                    String artista = sc.nextLine();
                    System.out.print("Duracion (segundos): ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Duracion invalida. Ingresa un numero (segundos): ");
                        sc.next();
                    }
                    int duracion = sc.nextInt();
                    sc.nextLine();
                    Cancion cancion = new Cancion(nombre, artista, duracion);
                     
                    playlist.agregarCancion(cancion);  //<-------------------------------
                    
                    System.out.println("Cancion agregada: " + cancion);
                    System.out.println();
                    break;
                }
                case 2: {
                    System.out.print("Indice donde insertar: ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Indice invalido. Ingresa un numero: ");
                        sc.next();
                    }
                    int index = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Artista: ");
                    String artista = sc.nextLine();
                    System.out.print("Duracion (segundos): ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Duracion invalida. Ingresa un numero (segundos): ");
                        sc.next();
                    }
                    int duracion = sc.nextInt();
                    sc.nextLine();
                    Cancion cancion = new Cancion(nombre, artista, duracion);
                    
                    playlist.agregarEn(index, cancion); //<-------------------------------
                    
                    
                    System.out.println("Cancion insertada en indice " + index + ": " + cancion);
                    System.out.println();
                    break;
                }
                case 3: {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Artista: ");
                    String artista = sc.nextLine();
                    System.out.print("Duracion (segundos): ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Duracion invalida. Ingresa un numero (segundos): ");
                        sc.next();
                    }
                    int duracion = sc.nextInt();
                    sc.nextLine();
                    Cancion cancion = new Cancion(nombre, artista, duracion);
                    
                    playlist.agregarPrimero(cancion); //<-------------------------------
                    
                    System.out.println("Cancion agregada al inicio: " + cancion);
                    System.out.println();
                    break;
                }
                case 4: {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Artista: ");
                    String artista = sc.nextLine();
                    System.out.print("Duracion (segundos): ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Duracion invalida. Ingresa un numero (segundos): ");
                        sc.next();
                    }
                    int duracion = sc.nextInt();
                    sc.nextLine();
                    Cancion cancion = new Cancion(nombre, artista, duracion);
                    
                    playlist.agregarUltimo(cancion);  //<-------------------------------
                    
                    System.out.println("Cancion agregada al final: " + cancion);
                    System.out.println();
                    break;
                }
                case 5: {
                    playlist.Siguiente();
                    System.out.println();
                    break;
                }
                case 6: {
                    playlist.Anterior();
                    System.out.println();
                    break;
                }
                case 7: {
                    playlist.Actual();
                    System.out.println();
                    break;
                }
                case 8: {
                    playlist.mostrarPlaylist();
                    System.out.println();
                    break;
                }
                case 9: {
                    System.out.print("Indice a mostrar: ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Indice invalido. Ingresa un numero: ");
                        sc.next();
                    }
                    int index = sc.nextInt();
                    sc.nextLine();
                    Cancion mostrada = playlist.MostrarPosicion(index);
                    if (mostrada == null) System.out.println("Indice fuera de rango o playlist vacia.");
                    else System.out.println("Cancion en indice " + index + ": " + mostrada);
                    System.out.println();
                    break;
                }
                case 10: {
                    Cancion primera = playlist.MostrarPrimera(0);
                    if (primera == null) System.out.println("Playlist vacia.");
                    else System.out.println("Primera: " + primera);
                    System.out.println();
                    break;
                }
                case 11: {
                    Cancion ultima = playlist.MostrarUltima(0); 
                    if (ultima == null) System.out.println("Playlist vacia.");
                    else System.out.println("Ultima: " + ultima);
                    System.out.println();
                    break;
                }
                case 12: {
                    Cancion eliminar = playlist.EliminarUltimo();
                    if (eliminar == null) System.out.println("Playlist vacia, no se elimino.");
                    else System.out.println("Eliminado ultimo: " + eliminar);
                    System.out.println();
                    break;
                }
                case 13: {
                    Cancion eliminar = playlist.EliminarPrimero();
                    if (eliminar == null) System.out.println("Playlist vacia, no se elimino.");
                    else System.out.println("Eliminado primero: " + eliminar);
                    System.out.println();
                    break;
                }
                case 14: {
                    System.out.print("Indice a eliminar: ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Indice invalido. Ingresa un numero: ");
                        sc.next();
                    }
                    int index = sc.nextInt();
                    sc.nextLine();
                    Cancion eliminado = playlist.EliminarPosicion(index);
                    if (eliminado == null) System.out.println("Indice fuera de rango o playlist vacia.");
                    else System.out.println("Eliminado en indice " + index + ": " + eliminado);
                    System.out.println();
                    break;
                }
                case 15: {
                    exit = true;
                    break;
                }
                default: {
                    System.out.println("Opcion invalida");
                    System.out.println();
                    break;
                }
            }
        }
        
    }
}