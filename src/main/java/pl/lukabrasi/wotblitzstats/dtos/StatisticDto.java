package pl.lukabrasi.wotblitzstats.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;


@Data
public class StatisticDto {

    @JsonProperty("all")
    private AllDto allDto;
}
