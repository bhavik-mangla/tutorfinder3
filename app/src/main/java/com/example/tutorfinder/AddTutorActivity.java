package com.example.tutorfinder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddTutorActivity extends AppCompatActivity {

    private EditText editTextName, editTextClass, editTextLocality, editTextRating;
    //Tutors {
    //
    //    private String Name;
    //    private String Class1;
    //    private String Locality;
    //    private String PastResults;
    //    private String Image1;
    //    private String Image2;
    //    private String Image3;
    //    private String Subject;
    //    private String PhoneNumber;
    //    private String Address;
    //    private String TeachingExperience;
    //    private String Rating;
    //    private String Review1;
    //    private String Review2;
    private EditText  editTextPastResults, editTextImage1, editTextImage2, editTextImage3, editTextSubject, editTextPhoneNumber, editTextAddress, editTextTeachingExperience, editTextReview1, editTextReview2;

    private Button buttonAddTutor;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tutor);

        // Initialize Firebase

        editTextName = findViewById(R.id.editTextName);
        editTextClass = findViewById(R.id.editTextClass);
        editTextLocality = findViewById(R.id.editTextLocality);
        editTextPastResults = findViewById(R.id.editTextPastResults);
        editTextImage1 = findViewById(R.id.editTextImage1);
        editTextImage2 = findViewById(R.id.editTextImage2);
        editTextImage3 = findViewById(R.id.editTextImage3);
        editTextSubject = findViewById(R.id.editTextSubject);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        editTextAddress = findViewById(R.id.editTextAddress);
        editTextTeachingExperience = findViewById(R.id.editTextTeachingExperience);
        buttonAddTutor = findViewById(R.id.buttonAddTutor);
        FirebaseApp.initializeApp(this);

        db = FirebaseFirestore.getInstance();

        buttonAddTutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTutor();
            }
        });
    }

    private void addTutor() {
        String name = editTextName.getText().toString().trim();
        String class1 = editTextClass.getText().toString().trim();
        String locality = editTextLocality.getText().toString().trim();
        String pastResults = editTextPastResults.getText().toString().trim();
        String image1 = editTextImage1.getText().toString().trim();
        String image2 = editTextImage2.getText().toString().trim();
        String image3 = editTextImage3.getText().toString().trim();
        String subject = editTextSubject.getText().toString().trim();
        String phoneNumber = editTextPhoneNumber.getText().toString().trim();
        String address = editTextAddress.getText().toString().trim();
        String teachingExperience = editTextTeachingExperience.getText().toString().trim();
        String review1 = "";
        String review2 = "";
        String rating = "5.0⭐️"  ;


        // Check if any field is empty
        if (name.isEmpty() || class1.isEmpty() || locality.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create a new tutor object
        Map<String, Object> tutor = new HashMap<>();
        tutor.put("Name", name);
        tutor.put("Class", class1);
        tutor.put("Locality", locality);
        tutor.put("PastResults", pastResults);
        tutor.put("Image1", image1);
        tutor.put("Image2", image2);
        tutor.put("Image3", image3);
        tutor.put("Subject", subject);
        tutor.put("PhoneNumber", phoneNumber);
        tutor.put("Address", address);
tutor.put("TeachingExperience", teachingExperience);
        tutor.put("Review1", review1);
        tutor.put("Review2", review2);
        tutor.put("Rating", rating);


        // Add the tutor to Firestore
        db.collection("tutors")
                .add(tutor)
                .addOnSuccessListener(documentReference -> {
                    Toast.makeText(AddTutorActivity.this, "Tutor added successfully", Toast.LENGTH_SHORT).show();
                    // Clear EditText fields after adding tutor
                    Intent intent = new Intent(AddTutorActivity.this, MainActivity.class);
                    startActivity(intent);



                })
                .addOnFailureListener(e -> Toast.makeText(AddTutorActivity.this, "Error adding tutor: " + e.getMessage(), Toast.LENGTH_SHORT).show());
    }
}
