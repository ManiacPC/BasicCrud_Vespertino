package cl.inacap.databaseinsert;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import cl.inacap.databaseinsert.helpers.DatabaseHelper;

public class MainActivity extends AppCompatActivity {
    private DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.helper = new DatabaseHelper(getBaseContext());

        if (insertar("Pepe", 1234, "algo@algo.com") == true) {
            Toast.makeText(getBaseContext(),"Ha sido insertado un nuevo registro",Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getBaseContext(),"No se ha podido insertar un registro",Toast.LENGTH_LONG).show();
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
}
