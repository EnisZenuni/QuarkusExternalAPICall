package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class MetaData {
    @JsonProperty("1. Information")
    private String information;

    @JsonProperty("2. Symbol")
    private String symbol;

    @JsonProperty("3. Last Refreshed")
    private String lastRefreshed;
}
