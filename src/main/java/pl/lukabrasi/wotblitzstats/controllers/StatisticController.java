package pl.lukabrasi.wotblitzstats.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.lukabrasi.wotblitzstats.dtos.PersonalDto;
import pl.lukabrasi.wotblitzstats.entities.PlayerLogEntity;
import pl.lukabrasi.wotblitzstats.services.StatisticService;

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

/*    @PostMapping("/")
    public String index(@RequestParam("cityName") String cityName,
                        Model model) {
        if (!userSession.isLogin()) {
            return "redirect:/login";
        }
        model.addAttribute("weather", weatherLogService.getCurrentWeather(cityName));
        model.addAttribute("forecast", weatherLogService.getWeatherForecast(cityName));
        return "index";
    }*/


}
