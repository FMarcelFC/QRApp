package com.example.qrapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qrapp.R;
import com.example.qrapp.ScanModel;

import java.util.List;

public class ScanAdapter extends RecyclerView.Adapter<ScanHolder> {
    private List<ScanModel> scanModelList;
    public ScanAdapter(List<ScanModel> scanModelList) {
        this.scanModelList = scanModelList;
        System.out.println(this.scanModelList);
    }
    @NonNull
    @Override
    public ScanHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.scan_item, parent, false);
        return new ScanHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScanHolder holder, int position) {
        ScanModel scanModel = scanModelList.get(position);
        holder.title.setText(scanModel.getFormattedId());
        holder.info.setText(scanModel.getInfo());
    }

    @Override
    public int getItemCount() {
        return scanModelList.size();
    }
}
