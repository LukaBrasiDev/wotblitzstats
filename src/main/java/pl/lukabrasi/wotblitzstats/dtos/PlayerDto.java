package pl.lukabrasi.wotblitzstats.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PlayerDto {

    @JsonProperty("data")
    private List<DataDto> dataDtoList;


}