package com.example.konyvtar;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class KonyvAdapter extends BaseAdapter {
    private List<Konyv> konyvek;
    private Context context;

    public KonyvAdapter(List<Konyv> konyvek, Context context) {
        this.konyvek = konyvek;
        this.context = context;
    }

    @Override
    public int getCount() {
        return konyvek.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.lista_elem, viewGroup, false);
        TextView cimview = view.findViewById(R.id.cimtextview);
        TextView szerzoview = view.findViewById(R.id.szerzotextview);
        TextView oldalview = view.findViewById(R.id.oldaltextview);
        Button torles = view.findViewById(R.id.torles);
        cimview.setText("Cim: " + konyvek.get(position).getCim());
        szerzoview.setText("Szerzo: " + konyvek.get(position).getSzerzo());
        oldalview.setText("Oldalak szama: " + konyvek.get(position).getOldal());

        torles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(context)
                        .setTitle("Torles")
                        .setMessage("Biztos torolniszeretned?")
                        .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                konyvek.remove(position);
                                notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("Nem", null)
                        .show();
            }
        });

        return view;
    }
}
