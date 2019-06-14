package com.example.proyecto02_is;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnCreate;
    private Button btnDelete;

    private TurnoSQLiteHelper turnosHelper;
    private SQLiteDatabase db;

    private ListView listView;
    private MyAdapter adapter;

    private List<Turno> turnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = (ListView) findViewById(R.id.listView);
        turnos = new ArrayList<Turno>();
        btnCreate = (Button) findViewById(R.id.buttonCreate);
        btnDelete = (Button) findViewById(R.id.buttonDelete);


        btnCreate.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                //getAllTurnos();
                create();
                create2();
                //create3();
                update();
            }

        });

        btnDelete.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                //removeAll();
                deleteLast();
                update();
            }
        });

        //Abrimos la BD 'DBTest' en modo de escritura
        turnosHelper = new TurnoSQLiteHelper(this, "DBTest", null, 1);
        db = turnosHelper.getWritableDatabase();

        adapter = new MyAdapter(this, turnos, R.layout.itemdb);
        listView.setAdapter(adapter);

        update();
    }

    /*public void AddData(){
        btnCreate.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        boolean isInserted = turnosHelper.insertData(listView.toString(), turnos.toString());
                        if(isInserted = true)
                            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this, "Data Not Inserted", Toast.LENGTH_LONG).show();
                    }
        });
    }*/

    private List<Turno> getAllTurnos(){
        //Seleccionamos todos los registros de la tabla Turnos
        Cursor cursor = db.rawQuery("select * from Turnos", null);
        List<Turno> list = new ArrayList<Turno>();
        if(cursor.moveToFirst()){
            //Iteramos sobre el cursor de resultados
            //Y vamos rellenando el array que posteriormente devolveremos
            while(cursor.isAfterLast()==false){
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String nombre = cursor.getString(cursor.getColumnIndex("nombre"));
                String jornada = cursor.getString(cursor.getColumnIndex("jornada"));

                list.add(new Turno(id, nombre, jornada));
                cursor.moveToNext();
            }
        }
        return list;
    }

    public void create(){
        //Si hemos creado la BD correctamente
        if(db != null){
            ContentValues nuevoRegistro = new ContentValues();
            //El ID es autoincremental por eso mo se declara
            //nuevoRegistro.put("id", 1);
            nuevoRegistro.put("nombre", "Turno Lunes: Mañana");
            nuevoRegistro.put("jornada", "De 08:00 a 14:00 Hrs.");

            //nuevoRegistro.put("id", 2);
            //nuevoRegistro.put("nombre", "Turno Lunes");
            //nuevoRegistro.put("jornada", "De 14:00 a 20:00 Hrs.");

            //nuevoRegistro.put("id", 3);
            //nuevoRegistro.put("nombre", "Turno Lunes");
            //nuevoRegistro.put("jornada", "De 18:00 a 00:00 Hrs.");


            db.insert("Turnos", null, nuevoRegistro);
        }
    }

    public void create2(){
        //Si hemos creado la BD correctamente
        if(db != null){
            ContentValues nuevoRegistro = new ContentValues();
            //El ID es autoincremental por eso mo se declara

            //nuevoRegistro.put("id", 2);
            nuevoRegistro.put("nombre", "Turno Lunes: Tarde");
            nuevoRegistro.put("jornada", "De 14:00 a 20:00 Hrs.");

            db.insert("Turnos", null, nuevoRegistro);
        }
    }

    public void create3(){
        //Si hemos creado la BD correctamente
        if(db != null){
            ContentValues nuevoRegistro = new ContentValues();
            //El ID es autoincremental por eso mo se declara

            //nuevoRegistro.put("id", 3);
            nuevoRegistro.put("nombre", "Turno Lunes: Tarde 2");
            nuevoRegistro.put("jornada", "De 18:00 a 00:00 Hrs.");
        }
    }

    private void removeAll(){
        db.delete("Turnos", "id", null);
    }

    public void deleteLast(){
        Cursor cursor = db.rawQuery("select * from Turnos", null);
        if(cursor.moveToLast()){
            String filaId = cursor.getString(cursor.getColumnIndex("id"));
            db.delete("Turnos", "id" + "=?", new String[]{filaId});
        }
    }

    private void update(){
        //Borramos todos los elementos
        turnos.clear();
        //Cargamos todos los elementos
        turnos.addAll(getAllTurnos());
        //Refrescamos el adaptador
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy(){
        db.close();
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){

            /*case R.id.cambioVista:
                Intent intent = new Intent(MainActivity.this, MartesActivity.class);
                startActivity(intent);
                return true;*/

            case R.id.cambioVista2:
                Intent intent2 = new Intent(MainActivity.this, MartesActivity.class);
                startActivity(intent2);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //Creamos el menu contextual
    /*@Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        //menu.setHeaderTitle(this.nombre.get(info.position).getNombre());
        menu.setHeaderTitle(this.turnos.get(info.position));
        inflater.inflate(R.menu.context_menu, menu);
    }

    //Manejamos eventos del menu contextual
    @Override
    public boolean onContextItemSelected(MenuItem item){
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch(item.getItemId()){
            case R.id.empleado_1:
                //Eliminamos el item clickeado
                this.turnos.remove(info.position);
                //Notificamos al adapter del cambio
                adapter.notifyDataSetChanged();
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }*/
}

