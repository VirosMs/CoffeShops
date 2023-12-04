package com.virosms.coffeshops;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.virosms.coffeshops.databinding.ActivityMainBinding;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private List<String> names = Arrays.asList(
            "Cafe 1",
            "Cafe 2",
            "Cafe 3",
            "Cafe 4",
            "Cafe 5",
            "Cafe 6",
            "Cafe 7");

    private List<String> locations = Arrays.asList(
            "Location 1",
            "Location 2",
            "Location 3",
            "Location 4",
            "Location 5",
            "Location 6",
            "Location 7");

    private List<Integer> images = Arrays.asList(
            R.drawable.images,
            R.drawable.images1,
            R.drawable.images2,
            R.drawable.images3,
            R.drawable.images4,
            R.drawable.images5,
            R.drawable.images6);

    private List<Float> ratings = Arrays.asList(
            4.5f,
            4.0f,
            3.5f,
            3.0f,
            2.5f,
            2.0f,
            1.5f,
            1.0f,
            0.5f,
            0.0f);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        CardAdapter adapter = new CardAdapter(names, locations, images, ratings);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}