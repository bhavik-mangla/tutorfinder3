package com.example.tutorfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button student;
    Button tutor;
    FirebaseFirestore db;
//    private void addTutorsToFirestore() {
//        try {
//            File yourFilePath = MainActivity.this.getFilesDir();
//
//
//
//            // Read JSON data from the file
//            AssetManager assetManager = getAssets();
//            InputStream is = assetManager.open("a.json");
//            int size = is.available();
//            byte[] buffer = new byte[size];
//            is.read(buffer);
//            is.close();
//            String json = new String(buffer, StandardCharsets.UTF_8);
//
//
//            // Convert JSON string to JSONArray
//            JSONArray jsonArray = new JSONArray(json);
//
//            // Get reference to the "tutors" collection
//
//            // Add each tutor to Firestore
//            for (int i = 0; i < jsonArray.length(); i++) {
//                JSONObject obj = jsonArray.getJSONObject(i);
//                String Name = obj.getString("name");
//                String Class1 = obj.getString("class");
//                String Locality = obj.getString("location");
//                String PastResults = obj.getString("achievement");
//                String Subject = obj.getString("subject");
//                String PhoneNumber = obj.getString("contact");
//                String Address = obj.getString("address");
//                String TeachingExperience = obj.getString("experience");
//                JSONArray imagesArray = obj.getJSONArray("images");
//
//                String[] images = new String[imagesArray.length()];
//
//// Loop through the JSON array and extract image strings
//                for (int j = 0; j < imagesArray.length(); j++) {
//                    images[j] = imagesArray.getString(j);
//                }
//
//// Now you can access individual image strings
//                String Image1 = images[0];
//                String Image2 = images[1];
//                String Image3 = images[2];
//
//                String Rating = obj.getString("rating");
//                String Review1 = obj.getString("review");
//                String Review2 = "Great tutor!😇";
//
//                if (Name.isEmpty() || Class1.isEmpty() || Locality.isEmpty()) {
//                    Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//
//                // Create a new tutor object
//                Map<String, Object> tutor = new HashMap<>();
//                tutor.put("Name", Name);
//                tutor.put("Class", Class1);
//                tutor.put("Locality", Locality);
//                tutor.put("PastResults", PastResults);
//                tutor.put("Image1", Image1);
//                tutor.put("Image2", Image2);
//                tutor.put("Image3", Image3);
//                tutor.put("Subject", Subject);
//                tutor.put("PhoneNumber", PhoneNumber);
//                tutor.put("Address", Address);
//                tutor.put("TeachingExperience", TeachingExperience);
//                tutor.put("Review1", Review1);
//                tutor.put("Review2", Review2);
//                tutor.put("Rating", Rating);
//
//
//                Tutors tutorJson = new Tutors(Name, Class1, Locality, PastResults, Image1, Image2, Image3, Subject, PhoneNumber, Address, TeachingExperience, Rating, Review1, Review2);
//
//
//                db.collection("tutors")
//                        .add(tutorJson)
//                        .addOnSuccessListener(documentReference -> {
//                            Toast.makeText(MainActivity.this, "Tutor added successfully", Toast.LENGTH_SHORT).show();
//                            // Clear EditText fields after adding tutor
//
//
//
//                        })
//                        .addOnFailureListener(e -> Toast.makeText(MainActivity.this, "Error adding tutor: " + e.getMessage(), Toast.LENGTH_SHORT).show());
//            }
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);

        setContentView(R.layout.activity_main);
        student = findViewById(R.id.student);
        tutor = findViewById(R.id.tutor);

        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                startActivity(intent);
            }
        });
//        FirebaseApp.initializeApp(this);
//
//        db = FirebaseFirestore.getInstance();
//
//
//



        tutor.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                addTutorsToFirestore();
                Intent intent = new Intent(MainActivity.this, AddTutorActivity.class);
                startActivity(intent);


            }
        });


    }
}




