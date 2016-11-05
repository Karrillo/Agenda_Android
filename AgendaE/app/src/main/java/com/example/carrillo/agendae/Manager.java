package com.example.carrillo.agendae;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carrillo on 05/11/2016.
 */

public class DataBaseManager {
    SQLiteOpenHelper dbHelper;
    SQLiteDatabase database;

    private static final String[] allColumns = {
            NotasDBOpenHelper.CN_ID,
            NotasDBOpenHelper.CN_TITLE,
            NotasDBOpenHelper.CN_HOUR,
            NotasDBOpenHelper.CN_PLACE,
            NotasDBOpenHelper.CN_CONTEND
    };

    /**
     * Constructor
     *
     * @param context
     */
    public DataBaseManager(Context context) {
        dbHelper = new NotasDBOpenHelper(context);
    }

    /**
     * Abrir la base de datos
     */
    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    /**
     * Cerrar la base de datos
     */
    public void close() {
        dbHelper.close();
    }

    /**
     * Crea una base de datos
     *
     * @param notas
     * @return
     */
    //Insertar en la base de datos
    public Notas create(Notas notas) {
        database.insert(NotasDBOpenHelper.TABLE_NAME, null, columnas(notas));
        return notas;
    }

    /**
     * Actualiza una nota
     *
     * @param notas
     * @return
     */
    public Notas update(Notas notas, int id) {
        database.update(NotasDBOpenHelper.TABLE_NAME, columnas(notas), NotasDBOpenHelper.CN_ID + " = ? ", new String[]{Long.toString(id)});
        return notas;
    }

    /**
     * Contiene los valores del objeto notas
     *
     * @param notas
     * @return
     */
    public ContentValues columnas(Notas notas) {
        ContentValues values = new ContentValues();
        values.put(NotasDBOpenHelper.CN_TITLE, notas.getTitulo());
        values.put(NotasDBOpenHelper.CN_CONTEND, notas.getDescripcion());
        values.put(NotasDBOpenHelper.CN_PLACE, notas.getLugar());
        values.put(NotasDBOpenHelper.CN_HOUR, notas.getHora());
        return values;
    }


}
