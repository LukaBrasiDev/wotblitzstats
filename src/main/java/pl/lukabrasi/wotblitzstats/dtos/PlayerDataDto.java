package pl.lukabrasi.wotblitzstats.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PlayerDataDto {

    private String nickname;
    @JsonProperty("account_id")
    private String accountId;
}
