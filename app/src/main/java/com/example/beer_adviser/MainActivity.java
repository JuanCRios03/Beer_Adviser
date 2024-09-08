package com.example.beer_adviser;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView tv1;
    private Spinner beer;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.tv1);
        beer = findViewById(R.id.beer);
        btn = findViewById(R.id.btn);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.spinner_item,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        beer.setAdapter(adapter);

        btn.setOnClickListener(this::cervezas);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void cervezas(View v) {
        String selection = beer.getSelectedItem().toString();

        if (selection.equals("light")) {
            tv1.setText("aguila light" +
                    "polar light");
        } else if (selection.equals("amber")) {
            tv1.setText("Club Colombia Roja" +
                    "Ambar");
        } else if (selection.equals("stout")) {
            tv1.setText("Club Colombia negra" +
                    "Cordillera negra");
        } else {
            Toast.makeText(this, "Por favor seleccione un tipo de cerveza", Toast.LENGTH_SHORT).show();
        }
    }
}


