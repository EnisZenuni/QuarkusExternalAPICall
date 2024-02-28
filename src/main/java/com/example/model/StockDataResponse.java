package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Map;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StockDataResponse {
    @JsonProperty("Meta Data")
    private MetaData metaData;

    @JsonProperty("Time Series (1min)")
    private Map<String, MinuteData> timeSeries;

}
