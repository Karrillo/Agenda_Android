package com.example.carrillo.agendae;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DataBaseManager manager;
    //Componentes
    private ListView lista;
    private EditText buscar;
    private ImageButton ingresar;
    private Button salir;
    private TextWatcher text = null;
    //lista para llenar la listView
    private List<Notas> notas;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**Instacia de la clase DataBaseManager**/
        manager = new DataBaseManager(this);
        /**Componentes**/
        lista = (ListView) findViewById(R.id.lista_tareas);
        buscar = (EditText) findViewById(R.id.txt_buscar);
        ingresar = (ImageButton) findViewById(R.id.btn_insertar);
        salir = (Button) findViewById(R.id.btn_salir);
        /**base de datos para el listView**/
        manager.open();
        notas = manager.todasNotas();
        refreshDisplay();
        manager.close();
    }
    public void refreshDisplay() {
        ArrayAdapter<Notas> adapter = new ArrayAdapter<Notas>(this, android.R.layout.simple_list_item_1, notas);
        lista.setAdapter(adapter);
    }
}
