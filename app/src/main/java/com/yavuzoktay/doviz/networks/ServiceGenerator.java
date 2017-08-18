package com.yavuzoktay.doviz.networks;

import com.yavuzoktay.doviz.models.DovizModel;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Yavuz on 12.8.2017.
 */

public interface ServiceGenerator {
    @GET("/latest?base=TRY")
    Call<DovizModel> dovizModel() ;



}
