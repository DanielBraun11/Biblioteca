package Biblioteca;


/**
* Biblioteca/Libro.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Biblioteca.idl
* jueves 3 de abril de 2025 19H40' CEST
*/

public final class Libro implements org.omg.CORBA.portable.IDLEntity
{
  public String titulo = null;
  public String autor = null;
  public String ISBN = null;
  public boolean estaDisponible = false;
  public int cantidad = (int)0;

  public Libro ()
  {
  } // ctor

  public Libro (String _titulo, String _autor, String _ISBN, boolean _estaDisponible, int _cantidad)
  {
    titulo = _titulo;
    autor = _autor;
    ISBN = _ISBN;
    estaDisponible = _estaDisponible;
    cantidad = _cantidad;
  } // ctor

} // class Libro
