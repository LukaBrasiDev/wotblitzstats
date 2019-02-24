package pl.lukabrasi.wotblitzstats.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class AlcotronicDto {

    @JsonProperty("statistics")
    private StatisticDto statisticDto;
    private String nickname;
    @JsonProperty("last_battle_time")
    Timestamp lastBattleTime;


    public String getLastBattleDate() {

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String strDate = format.format(lastBattleTime.getTime());
        return strDate;

    }

}
