package pl.lukabrasi.wotblitzstats.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
        model.addAttribute("stats", statisticService.getStats());
        return "index";
    }
}
