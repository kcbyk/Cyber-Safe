package com.solenzstudio.cybersafe;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import java.util.ArrayList;

public class MainActivity extends Activity {
    SharedPrefsHelper db;
    ArrayList<String> notes;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new SharedPrefsHelper(this);

        // Xiaomi Tarzı Başlık (Tetikleyici)
        TextView header = findViewById(R.id.notesHeader);
        ListView listView = findViewById(R.id.listView);
        
        notes = db.getNotes();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notes);
        listView.setAdapter(adapter);

        // Not Ekleme (Turuncu Buton)
        findViewById(R.id.fabAdd).setOnClickListener(v -> {
            EditText input = new EditText(this);
            new AlertDialog.Builder(this).setTitle("Yeni Not").setView(input)
                .setPositiveButton("Kaydet", (d, w) -> {
                    notes.add(0, input.getText().toString());
                    db.saveNotes(notes);
                    adapter.notifyDataSetChanged();
                }).show();
        });

        // 🔥 GİZLİ KAPI: Başlığa 3 saniye basılı tutunca PIN ekranı
        header.setOnLongClickListener(v -> {
            enterVault();
            return true;
        });
    }

    private void enterVault() {
        final EditText pinBox = new EditText(this);
        pinBox.setInputType(2); 
        new AlertDialog.Builder(this).setTitle("Güvenlik").setView(pinBox)
            .setPositiveButton("Giriş", (d, w) -> {
                if(pinBox.getText().toString().equals(db.getPin())) {
                    startActivity(new Intent(this, VaultActivity.class));
                }
            }).show();
    }
                                                     }
