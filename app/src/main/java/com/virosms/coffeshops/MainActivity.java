package com.virosms.coffeshops;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.virosms.coffeshops.databinding.ActivityMainBinding;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<String> names = Arrays.asList(
                "Cafe 1",
                "Cafe 2",
                "Cafe 3",
                "Cafe 4",
                "Cafe 5",
                "Cafe 6",
                "Cafe 7");

        List<String> locations = Arrays.asList(
                "Location 1",
                "Location 2",
                "Location 3",
                "Location 4",
                "Location 5",
                "Location 6",
                "Location 7");

        List<Integer> images = Arrays.asList(
                R.drawable.images,
                R.drawable.images1,
                R.drawable.images2,
                R.drawable.images3,
                R.drawable.images4,
                R.drawable.images5,
                R.drawable.images6);



        CardAdapter adapter = new CardAdapter(names, locations, images);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}