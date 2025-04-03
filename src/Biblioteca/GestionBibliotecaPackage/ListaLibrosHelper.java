package Biblioteca.GestionBibliotecaPackage;


/**
* Biblioteca/GestionBibliotecaPackage/ListaLibrosHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Biblioteca.idl
* jueves 3 de abril de 2025 19H40' CEST
*/


// Define un tipo para secuencias de Libros
abstract public class ListaLibrosHelper
{
  private static String  _id = "IDL:Biblioteca/GestionBiblioteca/ListaLibros:1.0";

  public static void insert (org.omg.CORBA.Any a, Biblioteca.Libro[] that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static Biblioteca.Libro[] extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = Biblioteca.LibroHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_sequence_tc (0, __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (Biblioteca.GestionBibliotecaPackage.ListaLibrosHelper.id (), "ListaLibros", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static Biblioteca.Libro[] read (org.omg.CORBA.portable.InputStream istream)
  {
    Biblioteca.Libro value[] = null;
    int _len0 = istream.read_long ();
    value = new Biblioteca.Libro[_len0];
    for (int _o1 = 0;_o1 < value.length; ++_o1)
      value[_o1] = Biblioteca.LibroHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, Biblioteca.Libro[] value)
  {
    ostream.write_long (value.length);
    for (int _i0 = 0;_i0 < value.length; ++_i0)
      Biblioteca.LibroHelper.write (ostream, value[_i0]);
  }

}
