package com.example.listviewpersonalizado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.List;

class MiAdaptadorAnimales extends ArrayAdapter<Animales> {

    Context ctx;
    int layout;
    List<Animales> animalesList;

    public MiAdaptadorAnimales(@NonNull Context context, int resource, @NonNull List<Animales> objects) {
        super(context, resource, objects);

        this.ctx = context;
        this.animalesList = objects;
        this.layout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(layout,parent,false);

        //Obtenemos la informacion del elemento de la lista que estoy iterando en este momento
        Animales elementoA = animalesList.get(position);

        //Rescatamos los elementos de la interfaz
        TextView nombre = v.findViewById(R.id.textViewNombre);
        TextView raza = v.findViewById(R.id.textViewRaza);
        TextView color = v.findViewById(R.id.textViewColor);
        ImageView imageView = (ImageView)v.findViewById(R.id.imageViewFoto);

        //Hacer un set de la informacion del elemento actual en los elementos de la interfaz del usuario
        nombre.setText(elementoA.getNombre());
        raza.setText(elementoA.getRaza());
        color.setText(elementoA.getColor());

        if(!elementoA.getUrlFoto().isEmpty()){//si hay imagen la carga, si no deja la que puse en el layout por defecto
                Glide.with(ctx)
                .load(elementoA.getUrlFoto())
                .into(imageView);
        }


        return v;
    }
}
