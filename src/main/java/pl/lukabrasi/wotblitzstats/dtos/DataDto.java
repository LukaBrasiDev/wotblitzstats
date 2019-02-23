package pl.lukabrasi.wotblitzstats.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DataDto {
    @JsonProperty("502174053")
    private AlcotronicDto alcotronicDto;
}
