package data.model;

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FindImage {
    //private Map<String, Image> map;

    @SerializedName("Image") @Expose private List<Image> FindImages = null;
    @SerializedName("statusCode") @Expose private String statusCode;

    public List<Image> FindImage() {
        return FindImages;
    }

    public void setFindImages(List<Image> FindImages) {
        this.FindImages = FindImages;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

}