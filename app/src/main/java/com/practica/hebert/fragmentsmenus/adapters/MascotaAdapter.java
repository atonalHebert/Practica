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
import com.practica.hebert.fragmentsmenus.fragments.MiMascotaPerfil;
import com.practica.hebert.fragmentsmenus.pojo.Mascota;

import java.util.ArrayList;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder> {

    private ArrayList<Mascota> mascotas ;
    private Activity activity ;

    public MascotaAdapter(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas ;
        this.activity = activity ;
    } // fin del constructor de la clase MascotaAdapter

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_mascota, viewGroup, false) ;
        return new MascotaViewHolder(v) ;
    } // fin de método onCreateViewHolder

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int i) {
        Mascota mascota = mascotas.get(i) ;
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto()) ;
        mascotaViewHolder.tvNombre.setText(mascota.getNombre()) ;
        mascotaViewHolder.tvRating.setText(String.valueOf(mascota.getRating()));
    } // fin del método onBindViewHolder

    @Override
    public int getItemCount() {
        return mascotas.size() ;
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto ;
        private TextView tvNombre ;
        private TextView tvRating ;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto) ;
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre) ;
            tvRating = (TextView) itemView.findViewById(R.id.tvRating) ;
        } // fin del constructor de la clase MascotaViewHolder
    } // fin de la clase anidada MascotaViewHolder
} // fin de la clase MascotaAdapter
