package com.example.notify.settings;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notify.R;

import java.util.ArrayList;

public class Settings_Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_settings);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ArrayList<Setting> settingsList = new ArrayList<>();
        settingsList.add(new Setting("Theme", "Here you can choose your theme."));
        settingsList.add(new Setting("Recently deleted", "Here you can look up and restore recently deleted files."));
        settingsList.add(new Setting("Notifications", "Here you can switch on and off notifications."));
        settingsList.add(new Setting("Rate us", "Provide us a feedback, so that we can become better."));

        recyclerView = findViewById(R.id.settingsActivityRecView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SettingsActivityRecViewAdapter adapter = new SettingsActivityRecViewAdapter(settingsList, this);
        recyclerView.setAdapter(adapter);

    }
}