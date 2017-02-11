package com.example.helenzhang.ilovezappos;

import android.databinding.DataBindingUtil;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.helenzhang.ilovezappos.databinding.ActivityResultBinding;

import java.util.List;

import data.model.ImageViewModel;
import data.model.Lookup;
import data.model.LookupSpecificProduct;
import data.model.Product;
import data.model.ProductDetails;
import data.remote.ZapposAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ResultActivity extends AppCompatActivity {
    public static final String BASE_URL ="http://api.zappos.com";

    ActivityResultBinding bind;
    FloatingActionButton fab;
    Animation FabOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = DataBindingUtil.setContentView(this, R.layout.activity_result);
        String s = getIntent().getStringExtra(MainActivity.K);
        fab = (FloatingActionButton)findViewById(R.id.fab);
        FabOpen = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_pressed);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(true){
                    fab.startAnimation(FabOpen);
                }
            }
        });
        requestData(s);
    }



    private void requestData(final String term){

        Retrofit adapter = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final ZapposAPI api = adapter.create(ZapposAPI.class);

        Call<Lookup> item = api.getInfo(term);
        item.enqueue(new Callback<Lookup>() {
            @Override
            public void onResponse(Call<Lookup> call, Response<Lookup> response) {
                List<Product> l = response.body().getResults();

                // data-binding
                bind.setItem(l.get(0));

                // variables for first result to show from search

                String prodID = l.get(0).getProductId();
                String styleID = l.get(0).getStyleId();
                String price = l.get(0).getPrice();
                String prodName = l.get(0).getProductName();
                //test.setText("Product ID = " + l.get(0).getProductId());

                // locate the product object and get the imageURL

                Call<LookupSpecificProduct> p = api.findProdObject(prodID);
                p.enqueue(new Callback<LookupSpecificProduct>() {
                    @Override
                    public void onResponse(Call<LookupSpecificProduct> call, Response<LookupSpecificProduct> response) {
                        List<ProductDetails> p = response.body().getProduct();
                        bind.setPic(new ImageViewModel(p.get(0).getDefaultImageUrl()));
                        //test.setText(p.get(0).getDefaultImageUrl());
                    }

                    @Override
                    public void onFailure(Call<LookupSpecificProduct> call, Throwable t) {

                    }
                });

            }

            @Override
            public void onFailure(Call<Lookup> call, Throwable t) {}
        });

    }
}
