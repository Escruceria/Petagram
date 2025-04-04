package com.escruceria.petagram;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout swipeRefreshLayout;
    ListView lstMiLista;
    Adapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Configuración del edge-to-edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicialización del FAB
        inicializarFAB();

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        lstMiLista = (ListView) findViewById(R.id.lstMiLista);

        String[] planetas = getResources().getStringArray(R.array.planetas);
        lstMiLista.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, planetas));

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }

        });
    }

    public void refrescandoContenido() {
        String[] planetas = getResources().getStringArray(R.array.planetas);
        lstMiLista.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, planetas));
        swipeRefreshLayout.setRefreshing(false);
    }

    private void inicializarFAB() {
        FloatingActionButton fab = findViewById(R.id.fabMiFAB);
        fab.setOnClickListener(v -> {
            Snackbar.make(v, getString(R.string.mensaje), Snackbar.LENGTH_LONG)
                    .setAction(getString(R.string.texto_accion), new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.i("SNACKBAR", "Click en Snackbar");

                        }
                    })
                    .setActionTextColor(getResources().getColor(R.color.colorWhite))
                    .show();
        });
    }
}