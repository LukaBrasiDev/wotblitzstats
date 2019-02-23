package pl.lukabrasi.wotblitzstats.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PersonalDto {

    @JsonProperty("data")
    private DataDto dataDto;
}
