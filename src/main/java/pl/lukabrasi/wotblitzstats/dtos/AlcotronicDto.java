package pl.lukabrasi.wotblitzstats.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import sun.util.calendar.LocalGregorianCalendar;

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
    private long lastBattleTime;

/*    public String getLastBattleDate() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String strDate = formatter.format(lastBattleTime.getTime());
        System.out.println(strDate);
        return strDate;
    }*/

    public String getLastBattleDate() {

        Date d = new Date((long) lastBattleTime * 1000);
        DateFormat f = new SimpleDateFormat("dd-MM-yyyy' 'HH:mm:ss");
        return f.format(d);
    }

}
