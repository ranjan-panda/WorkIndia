package com.workindia.ui.home;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Interface {
    @GET("b6a30bb0-140f-4966-8608-1dc35fa1fadc")
    Call<Item> get();
}

