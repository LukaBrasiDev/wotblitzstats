package pl.lukabrasi.wotblitzstats.services;

import com.google.gson.*;
import net.minidev.json.JSONObject;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.lukabrasi.wotblitzstats.dtos.AccountDto;
import pl.lukabrasi.wotblitzstats.dtos.DataDto;
import pl.lukabrasi.wotblitzstats.dtos.PersonalDto;
import pl.lukabrasi.wotblitzstats.entities.PlayerLogEntity;
import pl.lukabrasi.wotblitzstats.forms.PlayerLogForm;
import pl.lukabrasi.wotblitzstats.mappers.DtoToEntityMapper;
import pl.lukabrasi.wotblitzstats.repositories.PlayerLogRepository;

import javax.ws.rs.client.ClientBuilder;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;


@Service
public class StatisticService {

    final PlayerLogRepository playerLogRepository;


    @Autowired
    public StatisticService(PlayerLogRepository playerLogRepository) {
        this.playerLogRepository = playerLogRepository;
    }


    public boolean savePlayerLogEntity(PersonalDto personalDto) {
        PlayerLogEntity playerLogEntity = DtoToEntityMapper.convert(personalDto);
        // playerLogEntity.setUser(userSession.getUserEntity());
        return playerLogRepository.save(playerLogEntity) != null;

    }



    @Value("${api.wotblitzapplicationid.key}")
    String applicationId;


    public AccountDto getAccountId(String nickname) {
        RestTemplate restTemplate = getRestTemplate();
        String url = "https://api.wotblitz.eu/wotb/account/list/?application_id=" + applicationId + "&search=" + nickname;
        AccountDto accountDto = restTemplate.getForObject(url, AccountDto.class);

        return accountDto;
    }

    public PersonalDto getStats(String accountId){
       RestTemplate restTemplate = getRestTemplate();
       PersonalDto personalDto = restTemplate.getForObject("https://api.wotblitz.eu/wotb/account/info/?application_id=" + applicationId + "&account_id=" + accountId, PersonalDto.class);
       String url = "https://api.wotblitz.eu/wotb/account/info/?application_id=" + applicationId + "&account_id=" + accountId;




        return personalDto;
    }

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
