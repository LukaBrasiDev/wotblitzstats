package pl.lukabrasi.wotblitzstats.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class PersonalDto {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("meta")
    @Expose
    private MetaDto metaDto;
    @SerializedName("data")
    @Expose
    private DataDto dataDto;



}
