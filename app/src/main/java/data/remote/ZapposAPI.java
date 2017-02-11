package data.remote;

import android.media.Image;

import java.util.List;

import data.model.FindImage;
import data.model.Lookup;
import data.model.LookupSpecificProduct;
import data.model.Product;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static data.remote.ZapposAPI.KEY;

/**
 * Created by helenZhang on 2/6/17.
 */

public interface ZapposAPI {

    //String BASE_URL = "http://api.zappos.com";
    String KEY = "key=b743e26728e16b81da139182bb2094357c31d331";

    @GET("Search?" + KEY)
   // Call<List<Product>> GetProduct();
    Call<Product> getProducts(@Query("term") String term);
    //void getProducts(Callback<List<Product>> response);

    @GET("Search?" + KEY)
    Call<Lookup> getInfo(@Query("term") String term);

    @GET("Product/{id}?" + KEY)
    Call<LookupSpecificProduct> findProdObject(@Path("id") String id);



}
