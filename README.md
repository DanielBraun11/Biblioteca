# README P3 - Distribuidos

## Versiones utilizadas

Un ORB compatible con CORBA para Java, como el que viene integrado en el JDK.

Java Development Kit(JDK) en Eclipse Temurin 1.8.

## Ejecución de la práctica:

## Compilación y ejecución de la aplicación CORBA

Primero, compila los archivos IDL para generar los stubs y esqueletos requeridos por CORBA (esto creará la carpeta  
[Biblioteca](src/Biblioteca)):

bash
idlj -fall Biblioteca.idl
`
Después, compila los archivos .java correspondientes al servidor y al cliente:

bash
javac ServidorBiblioteca.java

javac ClienteBiblioteca.java

### Ejecución del Servidor y Cliente

Inicia el servicio de nombres de CORBA utilizando el puerto 1050:

tnameserv -ORBInitialPort 1050

En una terminal diferente, lanza el servidor de la biblioteca:
bash
java ServidorBiblioteca

ORBInitialHost localhost

ORBInitialPort 1050

Por último, en otra terminal, ejecuta el cliente de la biblioteca:

bash
java ClienteBiblioteca -ORBInitialHost localhost -ORBInitialPort 1050


## Diagrama de flujo:
```mermaid
classDiagram
    class Libro {
        - titulo: String
        - autor: String
        - ISBN: String
        - estaDisponible: boolean
        - cantidad: int
        + Libro(String, String, String, boolean, int)
        + getTitulo(): String
        + getAutor(): String
        + getISBN(): String
        + isDisponible(): boolean
        + getCantidad(): int
        + setDisponible(boolean): void
        + setCantidad(int): void
    }

    class GestionBiblioteca {
        <<interface>>
        + buscarLibro(String): Libro
        + prestarLibro(String): boolean
        + devolverLibro(String): boolean
        + mostrarLibros(): Libro[]
        + obtenerAutor(String): String
        + buscarPorAutor(String): Libro[]
        + obtenerLibrosNoDisponibles(): Libro[]
        + verDetallesLibro(String): String
        + añadirLibro(Libro): boolean
        + eliminarLibro(String): boolean
        + actualizarLibro(Libro): boolean
    }

    class GestionBibliotecaImpl {
        - libros: Map~String, Libro~
        - orb: ORB
        + GestionBibliotecaImpl(ORB)
        + setORB(ORB): void
        + buscarLibro(String): Libro
        + prestarLibro(String): boolean
        + devolverLibro(String): boolean
        + mostrarLibros(): Libro[]
        + obtenerAutor(String): String
        + buscarPorAutor(String): Libro[]
        + obtenerLibrosNoDisponibles(): Libro[]
        + verDetallesLibro(String): String
        + añadirLibro(Libro): boolean
        + eliminarLibro(String): boolean
        + actualizarLibro(Libro): boolean
    }

    class ServidorBiblioteca {
        + main(String[]): void
    }

    class ClienteBiblioteca {
        + main(String[]): void
        - mostrarMenu(): void
        - buscarLibro(GestionBiblioteca, Scanner): void
        - prestarLibro(GestionBiblioteca, Scanner): void
        - devolverLibro(GestionBiblioteca, Scanner): void
        - mostrarLibros(GestionBiblioteca): void
        - mostrarAutor(GestionBiblioteca, Scanner): void
        - buscarPorAutor(GestionBiblioteca, Scanner): void
        - mostrarNoDisponibles(GestionBiblioteca): void
        - verDetallesLibro(GestionBiblioteca, Scanner): void
    }

    class ORB {
        <<external>>
    }

    class Scanner {
        <<external>>
    }

    GestionBibliotecaImpl ..|> GestionBiblioteca: implements
    GestionBibliotecaImpl --> Libro: manages
    ServidorBiblioteca --> GestionBibliotecaImpl: creates
    ServidorBiblioteca --> ORB: uses
    ClienteBiblioteca --> GestionBiblioteca: uses
    ClienteBiblioteca --> Scanner: uses
    ClienteBiblioteca --> ORB: uses
```
