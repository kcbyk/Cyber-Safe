package com.solenzstudio.cybersafe;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.graphics.Color;

public class VaultActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Şimdilik basit bir siyah ekran ve yeşil yazı
        TextView tv = new TextView(this);
        tv.setText("--- CYBER-SAFE VAULT ---\n\nErişim Onaylandı.\nSistem Modülleri Aktif.");
        tv.setTextColor(Color.GREEN);
        tv.setBackgroundColor(Color.BLACK);
        tv.setTextSize(20);
        tv.setPadding(50, 50, 50, 50);
        
        setContentView(tv);
    }
}
