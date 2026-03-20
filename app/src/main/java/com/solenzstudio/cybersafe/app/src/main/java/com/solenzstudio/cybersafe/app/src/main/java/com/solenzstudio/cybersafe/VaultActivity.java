package com.solenzstudio.cybersafe;
import android.app.Activity;
import android.os.Bundle;
import android.widget.*;

public class VaultActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vault);
        
        TextView status = new TextView(this);
        status.setText("CYBER-SAFE: ERİŞİM ONAYLANDI\n\nUygulama Gizleme Modülü Yükleniyor...");
        status.setTextColor(android.graphics.Color.GREEN);
        setContentView(status);
    }
}
