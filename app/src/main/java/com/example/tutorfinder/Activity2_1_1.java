package com.example.tutorfinder;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Activity2_1_1 extends RecyclerView.Adapter<Activity2_1_1.ViewHolder> {

    private ArrayList<Tutors> localDataSet;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private TextView phoneNumberTextView;
        private TextView addressTextView;
        private ImageView imageView;
        private Button button;
        private TextView ratingTextView;

        public ViewHolder(View view) {
            super(view);
            nameTextView = view.findViewById(R.id.Name);
            phoneNumberTextView = view.findViewById(R.id.PhoneNumber);
            addressTextView = view.findViewById(R.id.Address);
            imageView = view.findViewById(R.id.imageView);
            button = view.findViewById(R.id.button);
            ratingTextView = view.findViewById(R.id.Rating);
        }
    }

    public Activity2_1_1(ArrayList<Tutors> dataSet, Context context) {
        localDataSet = dataSet;

        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_211, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Tutors[] tutorsArray = localDataSet.toArray(new Tutors[0]);

        Tutors tutor = tutorsArray[position];

        viewHolder.nameTextView.setText(tutor.getName());
        viewHolder.phoneNumberTextView.setText(tutor.getPhoneNumber());
        viewHolder.addressTextView.setText(tutor.getAddress());
        viewHolder.ratingTextView.setText(tutor.getRating());

        int id = context.getResources().getIdentifier(tutor.getImage1(), "drawable", context.getPackageName());
        if (id != 0) {
            viewHolder.imageView.setImageResource(id);
        }

        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Avtivity2_1_1_1.class);
                intent.putExtra("Name", tutor.getName());
                intent.putExtra("PhoneNumber", tutor.getPhoneNumber());
                intent.putExtra("Address", tutor.getAddress());
                intent.putExtra("TeachingExperience", tutor.getTeachingExperience());
                intent.putExtra("PastResults", tutor.getPastResults());
                intent.putExtra("Image1", tutor.getImage1());
                intent.putExtra("Image2", tutor.getImage2());
                intent.putExtra("Image3", tutor.getImage3());
                intent.putExtra("Review1", tutor.getReview1());
                intent.putExtra("Review2", tutor.getReview2());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
