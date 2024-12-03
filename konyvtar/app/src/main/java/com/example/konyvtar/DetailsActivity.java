package com.example.konyvtar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class DetailsActivity extends AppCompatActivity {

    private TextView cimtextview2;
    private TextView szerzotextview2;
    private TextView oldaltextview2;
    private TextView evtextview;
    private Button vissza;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
    }

    @SuppressLint("SetTextI18n")
    public void init() {
        cimtextview2 = findViewById(R.id.cimtextview2);
        szerzotextview2 = findViewById(R.id.szerzotextview2);
        oldaltextview2 = findViewById(R.id.oldaltextview2);
        evtextview = findViewById(R.id.evtextview);
        vissza = findViewById(R.id.vissza);
        Intent intent = getIntent();
        String cim = intent.getStringExtra("cim");
        String szerzo = intent.getStringExtra("szerzo");
        int oldal = intent.getIntExtra("oldal", 0);
        System.out.println(oldal);
        cimtextview2.setText("Cim: " + cim);
        szerzotextview2.setText("Szerzo: " + szerzo);
        oldaltextview2.setText("Oldalak szama: " + oldal);
        int ev = random.nextInt(2024 - 1000 + 1) + 1000;
        evtextview.setText("Ev: " + ev);
        vissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}