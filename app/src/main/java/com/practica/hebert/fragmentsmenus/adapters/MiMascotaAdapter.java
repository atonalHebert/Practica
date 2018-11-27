package com.practica.hebert.fragmentsmenus.adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.practica.hebert.fragmentsmenus.R;
import com.practica.hebert.fragmentsmenus.pojo.Mascota;

import java.util.ArrayList;

public class MiMascotaAdapter extends RecyclerView.Adapter<MiMascotaAdapter.MiMascotaViewHolder>{

    private ArrayList<Mascota> mascotas ;
    private Activity activity ;

    public MiMascotaAdapter(ArrayList<Mascota> mascotas, Activity activity){
        this.activity = activity ;
        this.mascotas = mascotas ;
    } // fin del constructor


    @NonNull
    @Override
    public MiMascotaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_foto_mi_mascota, viewGroup, false) ;
        return new MiMascotaViewHolder(v) ;
    } // fin del método onCreateViewHolder

    @Override
    public void onBindViewHolder(@NonNull MiMascotaViewHolder miMascotaViewHolder, int i) {
        Mascota mascota = mascotas.get(i) ;
//        miMascotaViewHolder.imgFotoMiMascota.setImageResource(mascota.getFoto()) ;
//        miMascotaViewHolder.tvRatingMiMascota.setText(mascota.getRating()) ;
    } // fin del método onBindViewHolder

    @Override
    public int getItemCount() {
        return mascotas.size() ;
    } // fin del método getItemCount

    public static class MiMascotaViewHolder extends RecyclerView.ViewHolder{

    private ImageView imgFotoMiMascota ;
    private TextView tvRatingMiMascota ;

    public MiMascotaViewHolder(View itemView){
        super(itemView) ;
        imgFotoMiMascota = (ImageView) itemView.findViewById(R.id.imgFotoMiMascota) ;
        tvRatingMiMascota = (TextView) itemView.findViewById(R.id.tvRatingMiMascota) ;
    }// fin del constructor
    } // fin de la clase anidada MiMascotaViewHolder
} // fin de la clase MiMascotaAdapter
