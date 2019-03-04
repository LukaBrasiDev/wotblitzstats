package pl.lukabrasi.wotblitzstats.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class AccountDto {

    @JsonProperty("data")
    private List<PlayerDataDto> playerDataDtoList;
    @JsonProperty("meta")
    private MetaDto metaDto;
}
