package com.blueroofstudio.plantcareapp.plant;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.blueroofstudio.plantcareapp.R;

import java.util.ArrayList;
import java.util.List;

public class PlantListAdapter extends RecyclerView.Adapter<PlantListAdapter.PlantHolder> {

    List<Plant> data = new ArrayList<>();

    @Override
    public PlantHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plant_item, parent, false);
        return new PlantHolder(view);
    }

    @Override
    public void onBindViewHolder(PlantHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<Plant> plants) {
        data.clear();
        data.addAll(plants);
        notifyDataSetChanged();
    }

    static class PlantHolder extends RecyclerView.ViewHolder {

        TextView name;

        public PlantHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.text);
        }

        void bind(Plant plant) {
            name.setText(plant.getName());
        }
    }

}
