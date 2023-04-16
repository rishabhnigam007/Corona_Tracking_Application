package com.virus.corona_tracker.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class CoronaData {

    private String state;
    private String country;
    private int latestTotalCases;
    private int diffFromPrevDay;
}
