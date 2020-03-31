package com.example.listviewpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    List<Animales> animalesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView)findViewById(R.id.listViewAnimales);

        animalesList = new ArrayList<>();
        animalesList.add(new Animales("Aquiles","Marrón","https://misanimales.com/wp-content/uploads/2019/10/perros-arrugas.jpg","Shar pei"));
        animalesList.add(new Animales("Dana", "Negro","https://d2devwt40at1e2.cloudfront.net/api/file/wSXTJACZT2i7mTZoESYA/convert?width=600&fit=max&quality=80","Salchica"));
        animalesList.add(new Animales("Titan","Marrón","https://www.hola.com/imagenes/estar-bien/20191004150785/pastor-aleman-raza-de-perro-caracteristicas/0-728-57/raza-de-perro-pastor-aleman-m.jpg","Pastor Aleman"));
        animalesList.add(new Animales("Layka","Blanco y Negro" ,"https://www.petclic.es/wikipets/wp-content/uploads/sites/default/files/library/dalmata_-_razas_de_perro.jpg","Dalmata"));

        MiAdaptadorAnimales adaptadorAnimales = new MiAdaptadorAnimales(this,R.layout.animal_item, animalesList);

        lista.setAdapter(adaptadorAnimales);
    }
}
