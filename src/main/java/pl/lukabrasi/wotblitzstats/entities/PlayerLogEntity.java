package pl.lukabrasi.wotblitzstats.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "wotb_player")
public class PlayerLogEntity {

    private @Id @GeneratedValue
    int id;
    private String nickname;
    @Column(name = "account_id")
    private int account;
    @Column(name = "reset_time")
    private LocalDateTime resetTime;
    @Column(name = "battles_count")
    private int battlesCount;
    @Column(name = "wins_count")
    private double winsCount;




}
