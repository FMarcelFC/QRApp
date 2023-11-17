package com.example.qrapp.adapter;

import android.widget.TextView;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qrapp.R;

public class ScanHolder extends RecyclerView.ViewHolder {
    TextView title, info;
    public ScanHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.scan_item_title);
        info = itemView.findViewById(R.id.scan_item_info);
    }
}
