package pl.lukabrasi.wotblitzstats.forms;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PlayerLogForm {

    private LocalDateTime resetTime;
    private int battlesCount;
    private double winsCount;

}
