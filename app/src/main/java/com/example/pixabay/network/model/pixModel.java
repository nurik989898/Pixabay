
package com.example.pixabay.network.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class pixModel {

    @SerializedName("total")
    
    private Integer total;
    @SerializedName("totalHits")
   
    private Integer totalHits;
    @SerializedName("hits")
  
    private List<Hit> hits = null;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(Integer totalHits) {
        this.totalHits = totalHits;
    }

    public List<Hit> getHits() {
        return hits;
    }

    public void setHits(List<Hit> hits) {
        this.hits = hits;
    }

}
