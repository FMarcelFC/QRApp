package com.example.qrapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.qrapp.adapter.ScanAdapter;
import com.example.qrapp.retrofit.RetrofitService;
import com.example.qrapp.retrofit.ScanApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Locations} factory method to
 * create an instance of this fragment.
 */
public class Locations extends Fragment {
    private RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_locations, container, false);
        recyclerView = view.findViewById(R.id.locations_rview);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        if (savedInstanceState == null) {
            // Load data only if it's not already loaded (e.g., on initial creation)
            loadScans();
        }
        return view;
    }

    private void loadScans() {
        RetrofitService retrofitService = new RetrofitService();
        ScanApi scanApi = retrofitService.getRetrofit().create(ScanApi.class);
        scanApi.getUrls().enqueue(new Callback<List<ScanModel>>() {
            @Override
            public void onResponse(Call<List<ScanModel>> call, Response<List<ScanModel>> response) {
                if (response.isSuccessful()) {
                    populateListView(response.body());
                } else {
                    showError("Failed to load data. Server returned " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<ScanModel>> call, Throwable t) {
                showError("Failed loading data. " + t.getMessage());
            }
        });
    }

    private void populateListView(List<ScanModel> scanList) {
        ScanAdapter scanAdapter = new ScanAdapter(scanList);
        recyclerView.setAdapter(scanAdapter);
    }

    private void showError(String message) {
        System.out.println(message);
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show();
    }
}
