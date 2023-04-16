package com.virus.corona_tracker.controller;

import com.virus.corona_tracker.model.CoronaData;
import com.virus.corona_tracker.service.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CoronaTrackerController {

    @Autowired
    private CoronaVirusDataService coronaVirusDataService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getCoronaVirusData(Model model) {
        List<CoronaData> allStats = coronaVirusDataService.getAllStats();
        int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
        int totalNewCases = allStats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();
        model.addAttribute("locationStats", allStats);
        model.addAttribute("totalReportedCases", totalReportedCases);
        model.addAttribute("totalNewCases", totalNewCases);
        return "home";
    }

}
