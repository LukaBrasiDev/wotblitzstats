package pl.lukabrasi.wotblitzstats.dtos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@lombok.Data
public class Data {

    @SerializedName("statistics")
    @Expose
    private StatisticDto statisticsDto ;

}
