package com.example.konyvtar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText cimedittext;
    private EditText szerzoedittext;
    private EditText oldaledittext;
    private Button hozzaadas;
    private ListView konyvlistview;
    private static List<Konyv> konyvlista = new ArrayList<>();
    private KonyvAdapter adapter = new KonyvAdapter(konyvlista, MainActivity.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        hozzaadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int oldalakszama = 0;
                    String cim = cimedittext.getText().toString();
                    String szerzo = szerzoedittext.getText().toString();
                    String oldal = oldaledittext.getText().toString();
                    System.out.println(oldal);
                    oldalakszama = Integer.parseInt(oldal);
                    if (cim.isEmpty() || szerzo.isEmpty() || oldal.isEmpty()) {
                        Toast.makeText(MainActivity.this, "mindent ki kell tolteni", Toast.LENGTH_SHORT).show();
                    } else if (oldalakszama < 50) {
                            System.out.println("kevesebb");
                            Toast.makeText(MainActivity.this, "az oldalak szama nem lehet kevesebb 50-nel", Toast.LENGTH_SHORT).show();
                    } else {
                        konyvlista.add(new Konyv(cim, szerzo, oldalakszama));
                        konyvlistview.setAdapter(adapter);
                        cimedittext.setText("");
                        szerzoedittext.setText("");
                        oldaledittext.setText("");
                    }
                } catch (Exception e) {
                    //System.out.println(e);
                    Toast.makeText(MainActivity.this, "mindent ki kell tolteni", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



    public void init() {
        cimedittext = findViewById(R.id.cimtext);
        szerzoedittext = findViewById(R.id.szerzotext);
        oldaledittext = findViewById(R.id.oldaltext);
        hozzaadas = findViewById(R.id.hozzaadas);
        konyvlistview = findViewById(R.id.konyvlistview);
        konyvlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Konyv kivalasztott = konyvlista.get(i);
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("cim", kivalasztott.getCim());
                intent.putExtra("szerzo", kivalasztott.getSzerzo());
                intent.putExtra("oldal", kivalasztott.getOldal());
                System.out.println(kivalasztott.getOldal());
                startActivity(intent);
            }
        });
    }
}