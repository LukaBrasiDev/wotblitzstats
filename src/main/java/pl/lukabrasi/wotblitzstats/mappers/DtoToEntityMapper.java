package pl.lukabrasi.wotblitzstats.mappers;

import pl.lukabrasi.wotblitzstats.dtos.PersonalDto;
import pl.lukabrasi.wotblitzstats.entities.PlayerEntity;

import java.time.LocalDateTime;

public class DtoToEntityMapper {

    public static PlayerEntity convert(PersonalDto personalDto) {

        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setNickname(personalDto.getDataDto().getAlcotronicDto().getNickname());
        playerEntity.setAccount(personalDto.getDataDto().getAlcotronicDto().getAccountId());
        playerEntity.setResetTime(LocalDateTime.now());
        playerEntity.setBattlesCount(personalDto.getDataDto().getAlcotronicDto().getStatisticDto().getAllDto().getBattles());
        playerEntity.setWinsCount(personalDto.getDataDto().getAlcotronicDto().getStatisticDto().getAllDto().getWins());

        return playerEntity;
    }


}
