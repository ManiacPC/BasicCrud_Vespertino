package cl.inacap.databaseinsert;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import cl.inacap.databaseinsert.helpers.DatabaseHelper;
import cl.inacap.databaseinsert.models.Contacto;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Contacto c = new Contacto(getBaseContext());

        /* // INSERTAR
        if (c.insertar("Pepe", 1234, "algo@algo.com") == true) {
            Toast.makeText(getBaseContext(),"Ha sido insertado un nuevo registro",Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getBaseContext(),"No se ha podido insertar un registro",Toast.LENGTH_LONG).show();
        }*/

        // ELIMINAR
        /* if (c.eliminar(5)) {
            Toast.makeText(getBaseContext(),"El registro ha sido eliminado",Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getBaseContext(),"No se ha podido eliminar el registro",Toast.LENGTH_LONG).show();
        }*/

    }
}
