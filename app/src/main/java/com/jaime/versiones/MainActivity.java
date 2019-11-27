package com.jaime.versiones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.jaime.versiones.adaptadores.AdaptadorVersiones;
import com.jaime.versiones.utils.Versiones;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
        ListView listaVersiones;
        Context context;
        Versiones[] versione;
        ArrayList arrayVersiones;
        ArrayAdapter arrayAdapter;
        AdaptadorVersiones adaptadorVersiones;
        final static String TAG_1="Objeto";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        rellenarVersiones();
        acciones();
    }

    private void acciones() {
        listaVersiones.setOnItemClickListener(this);
    }

    private void rellenarVersiones(){
        listaVersiones.setAdapter(adaptadorVersiones);
        arrayVersiones.add(new Versiones("Beta",R.drawable.beta,R.drawable.beta,321,321,
                getResources().getString(R.string.Beta)));
        arrayVersiones.add(new Versiones("Cupcake",R.drawable.cupcake,R.drawable.cupcake_det,123,123,
                getResources().getString(R.string.Cupcake)));
        arrayVersiones.add(new Versiones("Donut",R.drawable.donut,R.drawable.donut_det,456,456,
                getResources().getString(R.string.Donut)));
        arrayVersiones.add(new Versiones("Eclair",R.drawable.eclair,R.drawable.eclair_det,654,654,
                getResources().getString(R.string.Eclair)));
        arrayVersiones.add(new Versiones("Froyo",R.drawable.froyo,R.drawable.froyo_det,789,789,
                getResources().getString(R.string.Froyo)));
        arrayVersiones.add(new Versiones("GinGer Bread",R.drawable.gingerbread,R.drawable.gige_det,987,987,
                getResources().getString(R.string.GinGer_Bread)));
        arrayVersiones.add(new Versiones("Honey Comb",R.drawable.honeycomb,R.drawable.honey_det,011,011,
                getResources().getString(R.string.Honey_Comb)));
        arrayVersiones.add(new Versiones("Ice Cream",R.drawable.icecream,R.drawable.ice_det,110,110,
                getResources().getString(R.string.Ice_Cream)));
        arrayVersiones.add(new Versiones("Jelly Bean",R.drawable.jelly_bean,R.drawable.jelly_det,112,112,
                getResources().getString(R.string.Jelly_Bean)));
        arrayVersiones.add(new Versiones("KitKat",R.drawable.kitkat,R.drawable.kit_det,690,690,
                getResources().getString(R.string.KitKat)));
        adaptadorVersiones.notifyDataSetChanged();
    }

    private void instancias() {
        listaVersiones = findViewById(R.id.listaVersiones);
        arrayVersiones = new ArrayList();
        //arrayAdapter = new ArrayAdapter(getApplicationContext(),
        //     android.R.layout.simple_list_item_1, listaModelos);
        adaptadorVersiones = new AdaptadorVersiones(arrayVersiones,getApplicationContext());

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.listaVersiones:
                Intent intent1 = new Intent(getApplicationContext(), DescriptionActivity.class);
                intent1.putExtra(TAG_1,(Versiones)adaptadorVersiones.getItem(position));
                startActivity(intent1);
                break;
        }
    }

    }

