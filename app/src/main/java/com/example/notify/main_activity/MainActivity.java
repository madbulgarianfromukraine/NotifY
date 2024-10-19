package com.example.notify.main_activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notify.ABOUTActivity;
import com.example.notify.NoteEditingActivity;
import com.example.notify.R;
import com.example.notify.settings.Settings_Activity;
import com.example.notify.utils.Utils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity {
    //declaration of view attributes
    private ImageButton imageViewABOUT, imageButtonSettings;
    private FloatingActionButton fabEdit;
    private RecyclerView recViewMainActivity;
    Utils db = Utils.getInstance();

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

        imageViewABOUT = (ImageButton) findViewById(R.id.imageButtonABOUT);

        imageViewABOUT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ABOUTActivity.class);
                startActivity(intent);
            }
        });

        imageButtonSettings = (ImageButton) findViewById(R.id.imageButtonSettings);

        imageButtonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Settings_Activity.class);
                startActivity(intent);
            }
        });

        fabEdit  = findViewById(R.id.edit_FAB);
        recViewMainActivity = findViewById(R.id.mainActivityNotesRecyclerView);

        fabEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(MainActivity.this, NoteEditingActivity.class);
                startActivity(intent);
            }
        });
        recViewMainActivity.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                // Check if the scrolling has stopped
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    // Scrolling has stopped, make the button visible
                    fabEdit.setVisibility(View.VISIBLE);
                }
            }
        });

        recViewMainActivity.setLayoutManager(new LinearLayoutManager(this));
        MainActivityRecViewAdapter adapter = new MainActivityRecViewAdapter(this);
        recViewMainActivity.setAdapter(adapter);
    }


}