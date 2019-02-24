package pl.lukabrasi.wotblitzstats.dtos;

import lombok.Data;

@Data
public class AllDto {

    private double wins;
    private double losses;
    private int battles;
    private double winrate;

    public double getWinrate() {

        double result = (wins  / battles)*100;
        result *= 1000;
        result = Math.round(result);
        result /=1000;
        return result;
    }


}
