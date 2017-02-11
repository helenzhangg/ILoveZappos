package data.model;

/**
 * Created by helenZhang on 2/7/17.
 */
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LookupSpecificProduct {

    @SerializedName("product")
    @Expose
    private List<ProductDetails> product = null;
    @SerializedName("statusCode")
    @Expose
    private String statusCode;

    public List<ProductDetails> getProduct() {
        return product;
    }

    public void setProduct(List<ProductDetails> product) {
        this.product = product;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

}