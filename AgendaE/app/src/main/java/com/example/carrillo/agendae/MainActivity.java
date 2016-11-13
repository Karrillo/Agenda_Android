package com.example.carrillo.agendae;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
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
    }
}
