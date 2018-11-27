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
import com.practica.hebert.fragmentsmenus.adapters.MiMascotaAdapter;
import com.practica.hebert.fragmentsmenus.pojo.Mascota;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MiMascotaPerfil extends Fragment {

    private RecyclerView rvMiMascota ;
    private ArrayList<Mascota> mascotas ;


    public MiMascotaPerfil() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mi_mascota_perfil, container, false);
        // Inflate the layout for this fragment
        rvMiMascota = (RecyclerView) v.findViewById(R.id.rvMiMascota) ;
        GridLayoutManager glm = new GridLayoutManager(getActivity(),3 ) ;
        rvMiMascota.setLayoutManager(glm) ;
        listaFotos() ;
        inicializarAdaptador() ;
        return v;
    } // fin del método onCreateView

    private void inicializarAdaptador() {
        MiMascotaAdapter adapter = new MiMascotaAdapter(mascotas, getActivity()) ;
        rvMiMascota.setAdapter(adapter) ;
    } // fin del método inicializarAdaptador

    private void listaFotos() {
        mascotas = new ArrayList<Mascota>() ;
        for(int i= 1; i<=15;i++)
        mascotas.add(new Mascota(R.drawable.bulbasaur, (byte) 5)) ;
    } // fin del método listaFotos


} // fin de la clase MiMascotaPerfil
