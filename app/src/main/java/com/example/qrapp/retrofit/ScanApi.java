package com.example.qrapp.retrofit;

import com.example.qrapp.ScanModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ScanApi {
    @GET("/scan/get_urls")
    Call<List<ScanModel>> getUrls();

    @GET("/scan/get_networks")
    Call<List<ScanModel>> getNetworks();
}
