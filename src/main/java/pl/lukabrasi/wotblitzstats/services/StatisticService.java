package pl.lukabrasi.wotblitzstats.services;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.lukabrasi.wotblitzstats.dtos.PersonalDto;


@Service
public class StatisticService {


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
