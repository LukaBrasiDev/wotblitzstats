package pl.lukabrasi.wotblitzstats.dtos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class AllDto {



   @SerializedName("battles")
   @Expose
    private int battles;


/*
    public double getWinrate() {

        double result = (wins  / battles)*100;
        result *= 1000;
        result = Math.round(result);
        result /=1000;
        return result;
    }
*/


}
