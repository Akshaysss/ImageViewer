package com.imageviewer.internet;

import com.imageviewer.models.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Pavan on 4/2/2017.
 */

public interface InternetService {

    @GET("array.php")
    Call<List<Users>> getUsers();


    @GET("pavan.php")
    Call<List<Users>> getNames();
}
