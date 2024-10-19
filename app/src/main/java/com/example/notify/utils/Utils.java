package com.example.notify.utils;

import android.os.Build;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Utils {

    private static Utils instance;
    public ArrayList<Note> notes;

    private Utils(){
        notes = new ArrayList<>();
    }

    public static Utils getInstance() {
        if (instance == null) {
            instance = new Utils();
        }
        return instance;
    }

    public void changingSomething(Note note){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            note.setTimeLastAccessed(LocalDateTime.now());
        }
        notes.remove(note);
        notes.add(note);
    }

    public boolean addNewNote(Note note){
        return notes.add(note);
    }

}
