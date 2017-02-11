package data.model;

import com.google.gson.annotations.SerializedName;


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Lookup {

    @SerializedName("originalTerm") @Expose private String originalTerm;
    @SerializedName("currentResultCount") @Expose private String currentResultCount;
    @SerializedName("totalResultCount") @Expose private String totalResultCount;
    @SerializedName("term") @Expose private String term;
    @SerializedName("results") @Expose private List<Product> results = null;
    @SerializedName("statusCode") @Expose private String statusCode;

    public String getOriginalTerm() {
        return originalTerm;
    }

    public void setOriginalTerm(String originalTerm) {
        this.originalTerm = originalTerm;
    }

    public String getCurrentResultCount() {
        return currentResultCount;
    }

    public void setCurrentResultCount(String currentResultCount) {
        this.currentResultCount = currentResultCount;
    }

    public String getTotalResultCount() {
        return totalResultCount;
    }

    public void setTotalResultCount(String totalResultCount) {
        this.totalResultCount = totalResultCount;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public List<Product> getResults() {
        return results;
    }

    public void setResults(List<Product> results) {
        this.results = results;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return "Lookup{" +
                "originalTerm='" + originalTerm + '\'' +
                ", currentResultCount='" + currentResultCount + '\'' +
                ", totalResultCount='" + totalResultCount + '\'' +
                ", term='" + term + '\'' +
                ", results=" + results +
                ", statusCode='" + statusCode + '\'' +
                '}';
    }
}