package com.example.pam_4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {

    private ArrayList<ItemData> dataList;

    public MainAdapter(ArrayList<ItemData> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ItemData currentItem = dataList.get(position);
        holder.textNama.setText(currentItem.getNama());
        holder.textNIM.setText(currentItem.getNim());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textNama, textNIM;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textNama = itemView.findViewById(R.id.TextNama);
            textNIM = itemView.findViewById(R.id.TextNIM);
        }
    }
}
