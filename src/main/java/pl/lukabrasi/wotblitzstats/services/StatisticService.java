package pl.lukabrasi.wotblitzstats.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.lukabrasi.wotblitzstats.dtos.AccountDto;
import pl.lukabrasi.wotblitzstats.dtos.PersonalDto;



@Service
public class StatisticService {


    @Value("${api.wotblitzapplicationid.key}")
    public String applicationId;


    public AccountDto getAccountId(String nickname) {
        RestTemplate restTemplate = getRestTemplate();
        String url = "https://api.wotblitz.eu/wotb/account/list/?application_id=" + applicationId + "&search=" + nickname;

        AccountDto accountDto = restTemplate.getForObject(url, AccountDto.class);
        System.out.println(accountDto);
        return accountDto;
    }

    public PersonalDto getStats(String accountId){
        RestTemplate restTemplate = getRestTemplate();
        String JSON = restTemplate.getForObject("https://api.wotblitz.eu/wotb/account/info/?account_id=502174053&application_id=93fa062a128b405d638d4649f2cca564&fields=statistics.all.battles", String.class);
                                                   //   https://api.wotblitz.eu/wotb/account/info/?account_id=502174053&application_id=93fa062a128b405d638d4649f2cca564&fields=statistics.all.wins%2Cstatistics.all.battles%2Clast_battle_time
        System.out.println(JSON);
        Gson gson = new Gson();
        PersonalDto myObj  = gson.fromJson(JSON,
                new TypeToken<PersonalDto>(){}.getType());
        System.out.println(myObj);
        return myObj;

    }

/*    public PersonalDto getStats(String accountId){
       RestTemplate restTemplate = getRestTemplate();
       PersonalDto personalDto = restTemplate.getForObject("https://api.wotblitz.eu/wotb/account/info/?application_id=" + applicationId + "&account_id=" + accountId+"&fields=statistics.all.wins%2Cstatistics.all.battles%2Clast_battle_time", PersonalDto.class);
            return personalDto;
    }*/

/*    public void updatePlayerLogEntity(int account, PlayerLogForm playerLogForm) {
        Optional<PlayerLogEntity> optionalPlayerLogEntity = playerLogRepository.findByAccountExists(account);
        optionalPlayerLogEntity.get().setBattlesCount(playerLogForm.getBattlesCount());
        optionalPlayerLogEntity.get().setWinsCount(playerLogForm.getWinsCount());
        optionalPlayerLogEntity.get().setResetTime(playerLogForm.getResetTime());
        playerLogRepository.save(optionalPlayerLogEntity.get());
    }//todo*/


    @Bean
    public RestTemplate getRestTemplate() {

        return new RestTemplate();
    }
}
