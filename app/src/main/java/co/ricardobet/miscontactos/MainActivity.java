package co.ricardobet.miscontactos;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaContactos = (RecyclerView) findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
       // GridLayoutManager glm = new GridLayoutManager(this,2);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaContactos.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();
        configurationToolbar();


      /*  ListView lstContactos =(ListView) findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,nombresContacto));

        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre),contactos.get(i).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono),contactos.get(i).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail),contactos.get(i).getEmail());
                startActivity(intent);
                finish();
            }
        }); */

    }

    public void inicializarAdaptador() {
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos,this);
        listaContactos.setAdapter(adaptador);
    }

    public void inicializarListaContactos() {
        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto(R.drawable.mascota1,"mascota1","3182997874","ricardo.bet@utp.edu.co",1));
        contactos.add(new Contacto(R.drawable.mascota2,"mascota2","312433444","jhon@utp.edu.co",2));
        contactos.add(new Contacto(R.drawable.mascota3,"mascota3","323212223","cesar@utp.edu.co",3));
        contactos.add(new Contacto(R.drawable.mascota4,"mascota4","3578976777","santiago@utp.edu.co",4));
        contactos.add(new Contacto(R.drawable.mascota5,"mascota5","3333333333","yeison@utp.edu.co",5));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.favoritos:
                favoritos();
                break;
            default:
                break;
        }
        return true;
    }

    public void configurationToolbar(){
        Toolbar myActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(myActionBar);

    }

    public void favoritos(){
        final ArrayList<Contacto> mas = new ArrayList<>();
        for (int i= 0 ;i< contactos.size();i++) {
            if (contactos.get(i).getLike() >= 5) {
                mas.add(contactos.get(i));
            }
        }
        Intent vistaDatos = new Intent(MainActivity.this, DetalleContacto.class);
        vistaDatos.putExtra("mascotas", mas);
        startActivity(vistaDatos);
    }
}