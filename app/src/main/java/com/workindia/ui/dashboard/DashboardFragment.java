package com.workindia.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.workindia.R;
import com.workindia.ui.home.Client;
import com.workindia.ui.home.CustomAdapter;
import com.workindia.ui.home.Interface;
import com.workindia.ui.home.Item;
import com.workindia.ui.home.ItemDetail;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    RecyclerView recyclerView;
    List<ItemDetail> items=new ArrayList<>();
    CustomAdapter2 adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        recyclerView=root.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        fetchJson();
        return root;
    }

    private void fetchJson() {
        Interface call1= Client.getRetrofitInstance().getApi();
        Call<Item> call=call1.get();
        call.enqueue(new Callback<Item>() {
            @Override
            public void onResponse(Call<Item> call, Response<Item> response) {
                if (response.isSuccessful() && response.body()!=null){
                    items=response.body().getItems().getitems();
                    adapter =new CustomAdapter2(getActivity(), items);
                    recyclerView.setAdapter(adapter);

                }
                else{

                }
            }

            @Override
            public void onFailure(Call<Item> call, Throwable t) {


            }
        });
    }
}