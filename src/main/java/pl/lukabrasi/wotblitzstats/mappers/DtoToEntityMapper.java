package pl.lukabrasi.wotblitzstats.mappers;

import pl.lukabrasi.wotblitzstats.dtos.PersonalDto;
import pl.lukabrasi.wotblitzstats.entities.PlayerLogEntity;

import java.time.LocalDateTime;

public class DtoToEntityMapper {

    public static PlayerLogEntity convert(PersonalDto personalDto) {

        PlayerLogEntity playerLogEntity = new PlayerLogEntity();
        playerLogEntity.setNickname(personalDto.getDataDto().getAlcotronicDto().getNickname());
        playerLogEntity.setAccount(personalDto.getDataDto().getAlcotronicDto().getAccountId());
        playerLogEntity.setResetTime(LocalDateTime.now());
        playerLogEntity.setBattlesCount(personalDto.getDataDto().getAlcotronicDto().getStatisticDto().getAllDto().getBattles());
        playerLogEntity.setWinsCount(personalDto.getDataDto().getAlcotronicDto().getStatisticDto().getAllDto().getWins());

        return playerLogEntity;
    }


}
