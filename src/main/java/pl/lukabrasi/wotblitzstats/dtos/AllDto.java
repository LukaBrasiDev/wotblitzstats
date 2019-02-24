package pl.lukabrasi.wotblitzstats.dtos;

import lombok.Data;

@Data
public class AllDto {

    private int wins;
    private int losses;
    private double winrate;

    public double getWinrate() {
        double total = wins + losses;
        double result = wins * 100 / total;
        result *= 100;
        result = Math.round(result);
        result /=100;
        return result;
    }


}
