package cl.inacap.databaseinsert;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import cl.inacap.databaseinsert.helpers.DatabaseHelper;
import cl.inacap.databaseinsert.models.Contacto;

public class MainActivity extends AppCompatActivity {
    private ListView lstContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.lstContactos = (ListView) findViewById(R.id.lstContactos);

        // Definición e instanciación del adaptador
        ArrayAdapter<Contacto> adaptador = new ArrayAdapter<Contacto>(
                this, // Contexto es la misma actividad
                android.R.layout.simple_list_item_1, // Plantilla visual
                Contacto.contactos // Arreglo de objetos del adaptador
            );

        // Establecer el adaptador al listado gráfico de la lista (ListView)
        this.lstContactos.setAdapter(adaptador);

        // Toast.makeText(getBaseContext(),"NOMBRE OBJETO:" + Contacto.class.toString(),Toast.LENGTH_LONG).show();

        Contacto c = new Contacto(getBaseContext());


        this.lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), Contacto.contactos[position].getEmail().toString(), Toast.LENGTH_LONG).show();
            }
        });






        /////////////////////////////////// EJEMPLO DE CRUD //////////////////////////////////
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

        // ACTUALIZAR
        /*Contacto contactoActualizar = new Contacto();
        contactoActualizar.setCodContacto(4);
        contactoActualizar.setNombre("Pepe");
        contactoActualizar.setFono(1234);
        contactoActualizar.setEmail("pepe@algo.com");*/

        /*
        Contacto contactoActualizar = new Contacto(4, "Pepe", 1234, "pepe@algo.com");

        if (c.actualizar(contactoActualizar)) {
            Toast.makeText(getBaseContext(),"El registro ha sido actualizado",Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getBaseContext(),"El registro no ha sido actualizado",Toast.LENGTH_LONG).show();
        }*/

        // SELECCIONAR
/*        ArrayList<Contacto> contactos = c.obtenerContactos();
        for (Contacto con : contactos) {
            String s = new StringBuilder()
                    .append("Cod:" + String.valueOf(con.getCodContacto()))
                    .append(", Nombre:" + con.getNombre())
                    .append(", Fono:" + String.valueOf(con.getFono()))
                    .append(", Email:" + con.getEmail())
                    .toString();

            Toast.makeText(getBaseContext(), s, Toast.LENGTH_LONG).show();
        }*/
    }

}
