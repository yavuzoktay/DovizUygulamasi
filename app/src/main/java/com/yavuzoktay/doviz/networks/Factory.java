package com.yavuzoktay.doviz.networks;


import com.yavuzoktay.doviz.utils.Constant;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Yavuz on 8.8.2017.
 */

public class Factory {
    public static ServiceGenerator serviceGenerator;

    public static ServiceGenerator getInstance(){
        if (serviceGenerator  == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            serviceGenerator = retrofit.create(ServiceGenerator.class);
            return serviceGenerator;
        }else{
            return serviceGenerator;
        }
    }
}
