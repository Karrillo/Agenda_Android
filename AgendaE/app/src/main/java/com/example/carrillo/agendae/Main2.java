package com.example.carrillo.agendae;

import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Carrillo on 25/11/2016.
 */

public class Main2 extends AppCompatActivity {
    /**
     * Base de datos
     **/
    private DataBaseManager manager;
    /**
     * Componentes
     **/
    private EditText titulo, nota, fecha, lugar;
    private Button ingresar, cancelar;
    /**
     * Objeto para las notas
     **/
    private Notas notas;
    private String[] myNota;
    private Intent intent;
    /**
     * Variable para fecha
     **/
    private String hora;
    private String cal;
    /**
     * llamado del Calendar
     **/
    private Calendar calendario;
}
