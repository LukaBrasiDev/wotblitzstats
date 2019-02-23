package pl.lukabrasi.wotblitzstats.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AlcotronicDto {

    @JsonProperty("statistics")
   private StatisticDto statisticDto;
   private  String nickname;

}
