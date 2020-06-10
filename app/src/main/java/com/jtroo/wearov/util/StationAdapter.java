package com.jtroo.wearov.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.wear.widget.WearableRecyclerView;

import com.jtroo.wearov.R;
import com.jtroo.wearov.locations.Station;

import java.util.ArrayList;

public class StationAdapter extends WearableRecyclerView.Adapter<StationAdapter.StationViewHolder> {
    private ArrayList<Station> stations;

    public StationAdapter(ArrayList<Station> stations) {
        this.stations = stations;
    }

    @NonNull
    @Override
    public StationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.station_row, parent, false);
        return new StationViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StationViewHolder holder, int position) {
        Station station = stations.get(position);
        holder.stationName.setText(station.getName());
        holder.typeAndPlace.setText(station.getPlace().getName());
        if (station.getType().equals("stop"))
            holder.icon.setImageResource(R.drawable.driver);
        else
            holder.icon.setImageResource(R.drawable.train_station);
    }

    @Override
    public int getItemCount() {
        return stations.size();
    }

    public class StationViewHolder extends WearableRecyclerView.ViewHolder {
        public TextView stationName, typeAndPlace;
        public ImageView icon;
        public StationViewHolder(@NonNull View itemView) {
            super(itemView);
            stationName = (TextView) itemView.findViewById(R.id.stationName);
            typeAndPlace = (TextView) itemView.findViewById(R.id.typeAndPlace);
            icon = (ImageView) itemView.findViewById(R.id.iconRow);
        }
    }
}
