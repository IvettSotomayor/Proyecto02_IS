package com.example.proyecto02_is;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TurnoSQLiteHelper extends SQLiteOpenHelper {

    //public static final String DATABASE_NAME = "empleados";
    //public static final String TABLE_NAME = "Turnos";
    //public static final String COL_1 = "id";
    //public static final String COL_2 = "nombre";
    //public static final String COL_3 = "jornada";

    //Sentencia SQL para crear la tabla Cars
    String sqlCreate = "CREATE TABLE Turnos (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, nombre TEXT, jornada TEXT)";
    /*String sqlCreate2 = "CREATE TABLE TurnosMa (id INTEGER PRIMARY KEY NOT NULL, nombre TEXT, jornada TEXT)";
    String sqlCreate3 = "CREATE TABLE TurnosMi (id INTEGER PRIMARY KEY NOT NULL, nombre TEXT, jornada TEXT)";
    String sqlCreate4 = "CREATE TABLE TurnosJ (id INTEGER PRIMARY KEY NOT NULL, nombre TEXT, jornada TEXT)";
    String sqlCreate5 = "CREATE TABLE TurnosV (id INTEGER PRIMARY KEY NOT NULL, nombre TEXT, jornada TEXT)";
    String sqlCreate6 = "CREATE TABLE TurnosS (id INTEGER PRIMARY KEY NOT NULL, nombre TEXT, jornada TEXT)";*/

    public TurnoSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.sqlCreate = sqlCreate;
        //SQLiteDatabase db = this.getWritableDatabase();
        //this.sqlCreate = sqlCreate;
        /*this.sqlCreate2 = sqlCreate2;
        this.sqlCreate3 = sqlCreate3;
        this.sqlCreate4 = sqlCreate4;
        this.sqlCreate5 = sqlCreate5;
        this.sqlCreate6 = sqlCreate6;*/
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(sqlCreate);
        //db.execSQL("CREATE TABLE Turnos (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, nombre TEXT, jornada TEXT)");

        //db.execSQL("INSERT INTO Turnos(id, nombre, jornada) VALUES(1, 'Turno Lunes: Mañana', 'De 8:00 a 14:00 Hrs.')");
        //db.execSQL("INSERT INTO Turnos(id, nombre, jornada) VALUES(2, 'Turno Lunes: Tarde 1', 'De 14:00 a 20:00 Hrs.')");
        //db.execSQL("INSERT INTO Turnos(id, nombre, jornada) VALUES(3, 'Turno Lunes: Tarde 2', 'De 18:00 a 00:00 Hrs.')");
        /*db.execSQL(sqlCreate2);
        db.execSQL(sqlCreate3);
        db.execSQL(sqlCreate4);
        db.execSQL(sqlCreate5);
        db.execSQL(sqlCreate6);*/

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Se elimina la version anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS Turnos");
        db.execSQL(sqlCreate);
        /*db.execSQL("DROP TABLE IF EXISTS TurnosMa");
        db.execSQL("DROP TABLE IF EXISTS TurnosMi");
        db.execSQL("DROP TABLE IF EXISTS TurnosJ");
        db.execSQL("DROP TABLE IF EXISTS TurnosV");
        db.execSQL("DROP TABLE IF EXISTS TurnosS");*/

        //Se crea la nueva version de la tabla
        //db.execSQL(sqlCreate);
        /*db.execSQL(sqlCreate2);
        db.execSQL(sqlCreate3);
        db.execSQL(sqlCreate4);
        db.execSQL(sqlCreate5);
        db.execSQL(sqlCreate6);*/
    }

    /*public boolean insertData(String nombre, String jornada){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, nombre);
        contentValues.put(COL_3, jornada);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }*/
}
