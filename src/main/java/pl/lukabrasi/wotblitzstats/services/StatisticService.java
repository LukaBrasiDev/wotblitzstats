package pl.lukabrasi.wotblitzstats.services;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.lukabrasi.wotblitzstats.dtos.PlayerDto;
import pl.lukabrasi.wotblitzstats.dtos.StatisticDto;

@Service
public class StatisticService {


    public PlayerDto getStatistic() {
        RestTemplate restTemplate = getRestTemplate();
        PlayerDto playerDto = restTemplate.getForObject("https://api.worldoftanks.eu/wot/account/list/?application_id=93fa062a128b405d638d4649f2cca564&search=alcotronic", PlayerDto.class);


              return playerDto;
    }


    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
