package com.example.tutorfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class addTutors extends AppCompatActivity {

    RecyclerView recyclerView;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_21);

        db = FirebaseFirestore.getInstance();
        String locality = getIntent().getStringExtra("Locality");
        String classLevel = getIntent().getStringExtra("Class");
        String subject = getIntent().getStringExtra("Subject");

        fetchTutorsFromFirestore(  locality, classLevel, subject );
    }

    private void fetchTutorsFromFirestore(String locality, String classLevel, String subject) {
        db.collection("tutors")
                .whereEqualTo("Locality", locality)
                .whereEqualTo("Class", classLevel)
                .whereEqualTo("Subject", subject)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            ArrayList<Tutors> tutors = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Tutors tutor = document.toObject(Tutors.class);
                                tutors.add(tutor);
                            }
                            showTutorsOnRecyclerView(tutors);
                        } else {
                            Log.e("addTutors", "Error getting documents: ", task.getException());
                            Toast.makeText(addTutors.this, "Error fetching tutors", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


    private void showTutorsOnRecyclerView(ArrayList<Tutors> tutors) {
        if (tutors.isEmpty()) {
            Toast.makeText(this, "No tutors available", Toast.LENGTH_SHORT).show();
            return;
        }

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        Activity2_1_1 adapter = new Activity2_1_1(tutors, this);
        recyclerView.setAdapter(adapter);
    }
}
