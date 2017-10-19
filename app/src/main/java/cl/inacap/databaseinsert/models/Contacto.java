package cl.inacap.databaseinsert.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import cl.inacap.databaseinsert.helpers.DatabaseHelper;

public class Contacto {
    private DatabaseHelper helper;

    private int codContacto;
    private String nombre;
    private int fono;
    private String email;
    public static final Contacto contactos[] = {
        new Contacto(1, "Juanito Nieve", 1111, "jn@westeros.cl"), // Contacto.class.toString()
        new Contacto(2, "Daniela Targaryen", 2222, "dt@westeros.cl"),
        new Contacto(3, "Jorah Friendzone Mormont", 3333, "jm@westeros.cl"),
        new Contacto(4, "Tyrion Lannister", 4444, "tl@westeros.cl")
    };

    public Contacto() { }

    public Contacto(Context contexto) {
        this.helper = new DatabaseHelper(contexto);
    }

    public Contacto(int codContacto, String nombre, int fono, String email) {
        this.codContacto = codContacto;
        this.nombre = nombre;
        this.fono = fono;
        this.email = email;
    }

    // CRUD
    // CREATE (INSERTAR) READ (SELECCIONAR - OBTENER) UPDATE (ACTUALIZAR) DELETE (BORRAR)
    public ArrayList<Contacto> obtenerContactos() {
        ArrayList<Contacto> contactos = new ArrayList<>();
        SQLiteDatabase db = this.helper.getReadableDatabase();

        // Cursor consulta = db.rawQuery("SELECT * FROM contacto WHERE codcontacto = ?", new String[] { String.valueOf(1)});
        Cursor consulta = db.rawQuery("SELECT * FROM contacto", null);
        if(consulta.moveToFirst()) {
            do {
                // Fila = Columnas(codContacto[0], Nombre[1], Fono[2], Email[3])
                int codContacto = consulta.getInt(0);
                String nombre = consulta.getString(1);
                int fono = consulta.getInt(2);
                String email = consulta.getString(3);

                Contacto contacto = new Contacto(codContacto, nombre, fono, email);
                contactos.add(contacto);
            } while (consulta.moveToNext());
            return contactos;
        } else {
            return null;
        }
    }

    public boolean actualizar(Contacto contactoActualizar)
    {
        SQLiteDatabase db = this.helper.getWritableDatabase();
        ContentValues c = new ContentValues();
        //     PARAMETRO    VALOR
        c.put("NOMBRE", contactoActualizar.getNombre());
        c.put("FONO", contactoActualizar.getFono());
        c.put("EMAIL", contactoActualizar.getEmail());
        int filasModificadas;

        try {
            filasModificadas = db.update("contacto",c,"codcontacto = ?", new String[] { String.valueOf(contactoActualizar.getCodContacto()) });
            // if(filasModificadas > 0) return true; else return false;
            return (filasModificadas > 0 ? true : false);
        } catch (Exception e) {
            return false;
        } finally {
            db.close();
        }
    }

    private boolean eliminar(int codContacto)
    {
        SQLiteDatabase db = this.helper.getWritableDatabase();
        int filasAfectadas;

        try {
            // db.delete("contacto","codcontacto = ? AND fono = ?", new String[] { String.valueOf(codContacto), String.valueOf(fono) });
            filasAfectadas = db.delete("contacto","codcontacto = ?", new String[] { String.valueOf(codContacto) });
            //if(filasAfectadas > 0) return true; else return false;
            return (filasAfectadas > 0 ? true : false);
        } catch (Exception e) {
            return false;
        } finally {
            db.close();
        }
    }

    private boolean insertar(String nombre, int fono, String email)
    {
        SQLiteDatabase db = this.helper.getWritableDatabase();
        try {
            ContentValues c = new ContentValues();
            //     CLAVE    VALOR
            c.put("NOMBRE", nombre);
            c.put("FONO", fono);
            c.put("EMAIL", email);
            // db.execSQL("INSERT INTO contacto VALUES...)");
            db.insert("contacto",null,c);
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            db.close();
        }
    }

    public int getCodContacto() {
        return codContacto;
    }

    public void setCodContacto(int codContacto) {
        this.codContacto = codContacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFono() {
        return fono;
    }

    public void setFono(int fono) {
        this.fono = fono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString()
    {
        return this.nombre;
    }
}
