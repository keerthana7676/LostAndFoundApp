package com.example.found;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LostItemAdapter extends RecyclerView.Adapter<LostItemAdapter.ViewHolder> {

    private List<LostItem> itemList;

    public LostItemAdapter(List<LostItem> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public LostItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lost_found, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LostItemAdapter.ViewHolder holder, int position) {
        LostItem item = itemList.get(position);

        holder.tvItemName.setText(item.getItemName());
        holder.tvLocation.setText("Location: " + item.getLocation());
        holder.tvDescription.setText(item.getDescription());
        holder.tvContact.setText("Contact: " + item.getContact());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvItemName, tvLocation, tvDescription, tvContact;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItemName = itemView.findViewById(R.id.tvItemName);
            tvLocation = itemView.findViewById(R.id.tvLocation);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvContact = itemView.findViewById(R.id.tvContact);
        }
    }
}
