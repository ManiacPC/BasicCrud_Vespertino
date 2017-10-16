package cl.inacap.databaseinsert.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import cl.inacap.databaseinsert.helpers.DatabaseHelper;

public class Contacto {
    private DatabaseHelper helper;

    private int codContacto;
    private String nombre;
    private int fono;
    private String email;

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

    private boolean actualizar(int codContacto, Contacto contactoActualizar)
    {
        return false; // Retorno temporal
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
}
