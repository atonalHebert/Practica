package com.practica.hebert.fragmentsmenus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class AcercaDe extends AppCompatActivity {

    Toolbar toolbar ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);
        toolbar = (Toolbar) findViewById(R.id.toolbar) ;
        if(toolbar!=null) setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    } // fin del método onCreate
} // fin de la clase AcercaDe
