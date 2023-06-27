package com.example.m5individual2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.m5individual2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;
private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        boton=binding.btn;

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarFragmento1(v);
            }
        });
    }

    private void mostrarFragmento1(View v) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragmento1 = fragmentManager.findFragmentByTag("fragmento1");

        if (fragmento1 != null) {
            // El Fragmento1 está presente, cerrarlo y cambiar el texto del botón
            fragmentManager.beginTransaction()
                    .remove(fragmento1)
                    .commit();
            boton.setText("Abrir");

        } else {
            // El Fragmento1 no está presente, mostrarlo y cambiar el texto del botón
            fragmentManager.beginTransaction()
                    .add(R.id.frame1, new Fragmento1(), "fragmento1")
                    .commit();
           boton.setText("Cerrar");


        }
    }

}