package pl.lukabrasi.wotblitzstats.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "wotb_player")
public class PlayerEntity {

    private @Id @GeneratedValue
    int id;
    private String nickname;
    @Column(name = "account_id")
    private int account;



}
