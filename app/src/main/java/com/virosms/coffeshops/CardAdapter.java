package com.virosms.coffeshops;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder>{
    private final List<String> names;
    private final List<String> locations;
    private final List<Integer> images;
    private final List<Float> ratings;

    public CardAdapter(List<String> names, List<String> locations, List<Integer> images, List<Float> ratings){
        this.names = names;
        this.locations = locations;
        this.images = images;
        this.ratings = ratings;
    }


    /**
     * @param parent   The ViewGroup into which the new View will be added after it is bound to 
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return
     */
    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_layout, parent, false);
        return new CardViewHolder(view);
    }

    /**
     * @param holder   The ViewHolder which should be updated to represent the contents of the 
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        holder.name.setText(names.get(position));
        holder.img.setImageResource(images.get(position));
        holder.address.setText(locations.get(position));
        holder.ratingBar.setRating(ratings.get(position));
        holder.rating.setVisibility(View.GONE);
        holder.rating.setText(String.valueOf(ratings.get(position)));


        holder.ratingBar.setOnTouchListener((v, e) -> {
            if (e.getAction() == MotionEvent.ACTION_UP)
                holder.rating.setVisibility(View.GONE);
            v.performClick();
            return true;
        });
    }

    /**
     *
     */
    @Override
    public int getItemCount() {
        return names.size();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView img;
        public RatingBar ratingBar;
        public TextView rating;
        public TextView address;

        public CardViewHolder(@NonNull View v) {
            super(v);
            name = v.findViewById(R.id.textViewNombreComida);
            img = v.findViewById(R.id.imageViewComida);
            ratingBar = v.findViewById(R.id.ratingBar);
            rating = v.findViewById(R.id.textViewRating);
            address = v.findViewById(R.id.textViewDescripcion);

            itemView.findViewById(R.id.button).setOnClickListener(
                    v1 -> Toast.makeText(itemView.getContext(),
                            "Reserved", Toast.LENGTH_SHORT).show());
        }

    }

}
