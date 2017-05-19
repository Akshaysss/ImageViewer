package com.imageviewer.internet;

import retrofit2.Retrofit;

/**
 * Created by Pavan on 4/2/2017.
 */

public class InternetSetting {


    public static InternetService client() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://akshay.eoneservices.in/")
                .build();

        InternetService service = retrofit.create(InternetService.class);

        return service;
    }


}
