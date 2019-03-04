package pl.lukabrasi.wotblitzstats.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.lukabrasi.wotblitzstats.dtos.PersonalDto;
import pl.lukabrasi.wotblitzstats.entities.PlayerLogEntity;
import pl.lukabrasi.wotblitzstats.services.StatisticService;

import java.util.Optional;

@Controller
public class StatisticController {

    final StatisticService statisticService;

    @Autowired
    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping("/")
    public String index(Model model) {
        //    model.addAttribute("stats", statisticService.getStats());

        return "index";
    }

    @PostMapping("/")
    public String searchNick(@RequestParam("nickname") String nickname,
                             Model model) {
        model.addAttribute("nick", statisticService.getAccountId(nickname));

        return "index";
    }

    @GetMapping("/{nickname}") //todo
    public String getStats(@PathVariable(value = "nickname") String nickname, Model model) {
      String accountNb = statisticService.getAccountId(nickname).getPlayerDataDtoList().get(0).getAccountId();
        System.out.println(accountNb);
            model.addAttribute("stats", statisticService.getStats(accountNb));

        return "index";
    }


}
