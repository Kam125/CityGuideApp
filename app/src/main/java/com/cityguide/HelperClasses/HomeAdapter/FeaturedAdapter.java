package com.cityguide.HelperClasses.HomeAdapter;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cityguide.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.FeaturedViewHolder> {

    ArrayList<FeaturedHelperClass> featuredLocations;

    public FeaturedAdapter(ArrayList<FeaturedHelperClass> featuredLocations) { //hold Data of java
        this.featuredLocations = featuredLocations;
    }

    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_card_design, parent, false);
        FeaturedViewHolder featuredViewHolder = new FeaturedViewHolder(view);

        return featuredViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {

        FeaturedHelperClass featuredHelperClass = featuredLocations.get(position);

        holder.image.setImageResource(featuredHelperClass.getImage());
        holder.title.setText(featuredHelperClass.getTitle());
        holder.desc.setText(featuredHelperClass.getDescription());
    }

    @Override
    public int getItemCount() {
        return featuredLocations.size() ;
    }

    public static class FeaturedViewHolder extends RecyclerView.ViewHolder{ //Hold Design to get design we call this function

        ImageView image;
        TextView title, desc;


        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView); //file received in this item

            //Hooks
            image = itemView.findViewById(R.id.featured_image);
            title = itemView.findViewById(R.id.featured_title);
            desc = itemView.findViewById(R.id.featured_desc);

        }
    }
}
