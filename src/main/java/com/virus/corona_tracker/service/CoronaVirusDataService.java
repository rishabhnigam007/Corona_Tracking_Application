package com.virus.corona_tracker.service;

import com.virus.corona_tracker.model.CoronaData;

import java.util.List;

public interface CoronaVirusDataService {

    List<CoronaData> getAllStats();

    void fetchVirusData() throws Exception;
}
