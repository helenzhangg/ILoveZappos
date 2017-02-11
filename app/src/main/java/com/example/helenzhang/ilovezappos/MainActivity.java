package com.example.helenzhang.ilovezappos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

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

public class MainActivity extends AppCompatActivity{

    public static final String BASE_URL ="http://api.zappos.com";
    private EditText entry;
    public static String K = "K";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entry = (EditText) findViewById(R.id.searchEntry);

        entry.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEARCH){
                    search(entry);
                    return true;
                }
                return false;
            }
        });
    }

    public void search(View v){
        String searchTerm = entry.getText().toString();

        Intent findProduct = new Intent(this, ResultActivity.class);
        findProduct.putExtra(K, searchTerm);
        startActivity(findProduct);
    }


}
