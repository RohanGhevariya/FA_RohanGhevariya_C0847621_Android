package com.example.fa_rohanghevariya_c0847621_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fa_rohanghevariya_c0847621_android.databinding.PlacesViewBinding;


import java.util.ArrayList;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder>{
    private ArrayList<Places> placesArrayList;
    private Context context;
    PlacesViewBinding binding;


    public PlaceAdapter(ArrayList<Places> placesModalArrayList, Context context) {
        this.placesArrayList = placesModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = PlacesViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceAdapter.ViewHolder holder, int position) {
        Places model = placesArrayList.get(position);
        binding.idTVPlacesName.setText(model.getPlaceName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onContactClick != null) {
                    onContactClick.onContactClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return placesArrayList.size();
    }

    public interface OnContactClick {
        public void onContactClick(int position);
    }
    OnContactClick onContactClick;
    public void setOnContactClick(OnContactClick onContactClick) {
        this.onContactClick = onContactClick;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull PlacesViewBinding binding) {
            super(binding.getRoot());
        }


    }
}
