package com.solenzstudio.cybersafe;
import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefsHelper {
    private SharedPreferences prefs;

    public SharedPrefsHelper(Context context) {
        prefs = context.getSharedPreferences("CyberSafe_Prefs", Context.MODE_PRIVATE);
    }

    public void setPin(String pin) { prefs.edit().putString("master_pin", pin).apply(); }
    public String getPin() { return prefs.getString("master_pin", ""); }

    public void saveNotes(String notesJson) { prefs.edit().putString("notes_data", notesJson).apply(); }
    public String getNotes() { return prefs.getString("notes_data", "[]"); }
      }
