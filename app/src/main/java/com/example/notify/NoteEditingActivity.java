package com.example.notify;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.notify.main_activity.MainActivity;
import com.example.notify.utils.Note;
import com.example.notify.utils.Utils;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class NoteEditingActivity extends AppCompatActivity {
    private ImageButton backButton;
    private Button saveButton;
    private EditText titleEditText, noteEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_note_editing);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        backButton = (ImageButton) findViewById(R.id.backImageButton);
        saveButton = (Button) findViewById(R.id.saveButton);
        titleEditText = (EditText) findViewById(R.id.titleText);
        noteEditText = (EditText) findViewById(R.id.noteText);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((titleEditText.getText().toString().isEmpty()) && (noteEditText.getText().toString().isEmpty())){
                    Toast.makeText(NoteEditingActivity.this, "The note wasn't saved, since you didn't enter anything.", Toast.LENGTH_SHORT).show();
                }
                else{
                    saveTheNote();
                }
                goToMainActivity();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( !noteEditText.getText().toString().isEmpty() || !titleEditText.getText().toString().isEmpty()){
                    MaterialAlertDialogBuilder dialogBuilder = new MaterialAlertDialogBuilder(NoteEditingActivity.this);
                    dialogBuilder.setTitle("Don't you want to save it?");
                    dialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            goToMainActivity();
                        }
                    });

                    dialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            saveTheNote();
                            goToMainActivity();
                        }
                    });

                    dialogBuilder.show();
                }
                else{
                    goToMainActivity();
                }

            }
        });

        titleEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    titleEditText.setHint("");
                }else{
                    titleEditText.setHint("Enter your title...");
                }
            }
        });

        noteEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    noteEditText.setHint("");
                }else{
                    noteEditText.setHint("Enter the text of your note...");
                }
            }
        });

    }

    private void goToMainActivity(){
        Intent intent = new Intent(NoteEditingActivity.this, MainActivity.class);
        startActivity(intent);
    }

    private void saveTheNote(){
        String title = titleEditText.getText().toString();
        String noteText = noteEditText.getText().toString();
        Note newNote = null;
        if(title.isEmpty()){
            newNote =  new Note(title, false);
        }
        else if(noteText.isEmpty()){
            newNote = new Note(noteText, true);
        }else{
            newNote = new Note(title, noteText);
        }
    }

}