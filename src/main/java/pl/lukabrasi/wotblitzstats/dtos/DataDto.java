package pl.lukabrasi.wotblitzstats.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.Map;

@Data
public class DataDto {


    @SerializedName("statistics")
    @Expose
    private Map<String,StatisticDto> statisticDtoMap;


}
