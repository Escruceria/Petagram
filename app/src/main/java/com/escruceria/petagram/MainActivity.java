package com.escruceria.petagram;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

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
    }

    private void inicializarFAB() {
        FloatingActionButton fab = findViewById(R.id.fabMiFAB);
        fab.setOnClickListener(v -> {
            // Acción al hacer clic en el FAB
            Toast.makeText(MainActivity.this, "Favorito :)", Toast.LENGTH_SHORT).show();

            // Aquí puedes agregar la lógica que quieras ejecutar al presionar el FAB
        });
    }
}