package com.practica.hebert.fragmentsmenus.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.practica.hebert.fragmentsmenus.R;
import com.practica.hebert.fragmentsmenus.adapters.MascotaAdapter;
import com.practica.hebert.fragmentsmenus.pojo.Mascota;

import java.util.ArrayList;

public class ListaMascotas extends Fragment {

    private ArrayList<Mascota> mascotas ;
    private RecyclerView rvMascotas ;

    public ListaMascotas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lista_mascotas, container, false);
        // Inflate the layout for this fragment
        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas) ;
        LinearLayoutManager llm = new LinearLayoutManager(getActivity()) ;
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm) ;
        listaMascotas() ;
        inicializarAdaptador() ;
        return v;
    } // fin del método onCreateView

    private void inicializarAdaptador() {
        MascotaAdapter adapter = new MascotaAdapter(mascotas, getActivity()) ;
        rvMascotas.setAdapter(adapter);
    } // fin del método inicializarAdaptador

    private void listaMascotas() {
        mascotas = new ArrayList<Mascota>() ;
        mascotas.add(new Mascota(R.drawable.bulbasaur, "Bulbasaur" , (byte) 5)) ;
        mascotas.add(new Mascota(R.drawable.bulbasaur, "Bulbasaur" , (byte) 4)) ;
        mascotas.add(new Mascota(R.drawable.bulbasaur, "Bulbasaur" , (byte) 3)) ;
        mascotas.add(new Mascota(R.drawable.bulbasaur, "Bulbasaur" , (byte) 2)) ;
        mascotas.add(new Mascota(R.drawable.bulbasaur, "Bulbasaur" , (byte) 1)) ;
        mascotas.add(new Mascota(R.drawable.bulbasaur, "Bulbasaur" , (byte) 0)) ;
    } // fin del método listaMascotas
} // fin de la clase ListaMascotas
