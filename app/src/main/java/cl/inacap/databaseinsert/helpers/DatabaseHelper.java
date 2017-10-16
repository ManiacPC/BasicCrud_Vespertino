package cl.inacap.databaseinsert.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "applectura.db";
    public static final int DATABASE_VERSION = 2;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE contacto(nombre TEXT, fono INTEGER, email TEXT);");
        db.execSQL("INSERT INTO contacto VALUES('Tulio', 1122, 'tulio@31minutos.cl');");
        db.execSQL("INSERT INTO contacto VALUES('Juan', 2233, 'juan@31minutos.cl');");
        db.execSQL("INSERT INTO contacto VALUES('Anacleto', 3344, 'anacleto@31minutos.cl');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE contacto;");
        db.execSQL("CREATE TABLE contacto(codcontacto INTEGER PRIMARY KEY, nombre TEXT, fono INTEGER, email TEXT);");
        db.execSQL("INSERT INTO contacto VALUES(1, 'Tulio', 1122, 'tulio@31minutos.cl');");
        db.execSQL("INSERT INTO contacto VALUES(2, 'Juan', 2233, 'juan@31minutos.cl');");
        db.execSQL("INSERT INTO contacto VALUES(3, 'Anacleto', 3344, 'anacleto@31minutos.cl');");
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE contacto;");
        db.execSQL("CREATE TABLE contacto(nombre TEXT, fono INTEGER, email TEXT);");
        db.execSQL("INSERT INTO contacto VALUES('Tulio', 1122, 'tulio@31minutos.cl');");
        db.execSQL("INSERT INTO contacto VALUES('Juan', 2233, 'juan@31minutos.cl');");
        db.execSQL("INSERT INTO contacto VALUES('Anacleto', 3344, 'anacleto@31minutos.cl');");
    }

}
