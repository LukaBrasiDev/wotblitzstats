package pl.lukabrasi.wotblitzstats.dtos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class DemoJson {

    @SerializedName("data")
    @Expose
    private Data data;
}
