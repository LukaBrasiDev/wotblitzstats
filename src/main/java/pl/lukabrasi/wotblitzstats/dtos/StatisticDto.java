package pl.lukabrasi.wotblitzstats.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;


@Data
public class StatisticDto {

    @SerializedName("all")
    @Expose
    private AllDto allDto;
}
