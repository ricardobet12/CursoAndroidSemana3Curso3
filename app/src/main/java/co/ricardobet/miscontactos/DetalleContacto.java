package co.ricardobet.miscontactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class DetalleContacto extends AppCompatActivity {

    private ArrayList<Contacto> listaMascotas;
    private RecyclerView listaMascotasView;
    MaterialToolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_contacto);
        //Para recibir los datos el activity anterior
        Bundle parametros = getIntent().getExtras();
        listaMascotas = new ArrayList<>();
        listaMascotas = (ArrayList<Contacto>) parametros.get("mascotas");
        Log.i("entro","s");
        Log.i(listaMascotas.size()+"a","s");
        listaMascotasView = (RecyclerView) findViewById(R.id.rvFavoritos);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);
        listaMascotasView.setLayoutManager(llm);

        initAdapter();
        configurationToolbar();

    }

    public void initAdapter(){
        ContactoAdaptador adaptador = new ContactoAdaptador(listaMascotas,this);
        listaMascotasView.setAdapter(adaptador);
    }

    public void configurationToolbar(){
        Toolbar myActionBar = (Toolbar) findViewById(R.id.miActionBar);
        myActionBar.inflateMenu(R.menu.main_menu);
        setSupportActionBar(myActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(null);
    }
}