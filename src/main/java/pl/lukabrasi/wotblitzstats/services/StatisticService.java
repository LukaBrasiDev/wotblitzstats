package pl.lukabrasi.wotblitzstats.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.lukabrasi.wotblitzstats.dtos.PersonalDto;
import pl.lukabrasi.wotblitzstats.entities.PlayerLogEntity;
import pl.lukabrasi.wotblitzstats.mappers.DtoToEntityMapper;
import pl.lukabrasi.wotblitzstats.repositories.PlayerLogRepository;


@Service
public class StatisticService {

    final PlayerLogRepository playerLogRepository;


    @Autowired
    public StatisticService(PlayerLogRepository playerLogRepository) {
        this.playerLogRepository = playerLogRepository;
    }

/*    public boolean saveWeatherLog(WeatherDto weatherDto) {
        WeatherLogEntity weatherLogEntity = WeatherDtoToWeatherEntityMapper.convert(weatherDto);
        weatherLogEntity.setUser(userSession.getUserEntity());
        return weatherLogRepository.save(weatherLogEntity) != null;

    }*/

    public boolean savePlayerLog(PersonalDto personalDto) {
        PlayerLogEntity playerLogEntity = DtoToEntityMapper.convert(personalDto);
       // playerLogEntity.setUser(userSession.getUserEntity());
        return playerLogRepository.save(playerLogEntity) != null;

    }


    public PersonalDto getStats() {
        RestTemplate restTemplate = getRestTemplate();
        PersonalDto personalDto = restTemplate.getForObject("https://api.wotblitz.eu/wotb/account/info/?application_id=93fa062a128b405d638d4649f2cca564&account_id=502174053", PersonalDto.class);
        return personalDto;
    }


    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
