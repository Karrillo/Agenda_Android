package com.example.carrillo.agendae;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
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

    @RequiresApi(api = Build.VERSION_CODES.N)//requerido para el calendario
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_form);
        /**Instacia de la clase DataBaseManager**/
        manager = new DataBaseManager(this);
        /**Componentes**/
        titulo = (EditText) findViewById(R.id.txt_titulo);
        nota = (EditText) findViewById(R.id.txt_nota);
        fecha = (EditText) findViewById(R.id.txt_hora);
        lugar = (EditText) findViewById(R.id.txt_lugar);
        ingresar = (Button) findViewById(R.id.btn_ingresar);
        cancelar = (Button) findViewById(R.id.btn_cancelar);

        /**Inicializar Calendar**/
        calendario = Calendar.getInstance();
        /**Obtiene datos del intent**/
        intent = getIntent();
        myNota = intent.getStringArrayExtra("NOTAS");
        if (myNota != null) {
            llenar();
        }

        /**
         * evento de touch al edit
         */
        fecha.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    new DatePickerDialog(MainActivityForm.this, calendarListener, calendario.get(Calendar.YEAR),
                            calendario.get(Calendar.MONTH), calendario.get(Calendar.DAY_OF_MONTH)).show();
                    return true;
                }
                return false;
            }
        });
}
