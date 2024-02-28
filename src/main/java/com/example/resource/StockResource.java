package com.example.resource;

import com.example.AlphaVantageResource;
import com.example.model.StockDataResponse;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/api/stocks")
public class StockResource {
    @Inject
    @RestClient
    AlphaVantageResource alphaVantageResource;

    @GET
    @Path("/intraday")
    @Produces(MediaType.APPLICATION_JSON)
    public StockDataResponse get(
            @QueryParam("function") String function,
            @QueryParam("symbol") String symbol,
            @QueryParam("interval") String interval,
            @QueryParam("apikey") String apiKey
    ) {
        StockDataResponse stockDataResponse = alphaVantageResource.getData(function, symbol, interval, apiKey);

//        //Logging meta data
//        MetaData metaData = stockDataResponse.getMetaData();
//        System.out.println("Information: " + metaData.getInformation());
//        System.out.println("Symbol: " + metaData.getSymbol());
//        System.out.println("Last Refreshed: " + metaData.getLastRefreshed());
//        System.out.println(metaData);
//
//        //Logging time series
//        Map<String, MinuteData> timeSeries = stockDataResponse.getTimeSeries();
//        System.out.println(timeSeries);
//        timeSeries.forEach((timestamp, minuteData) -> {
//            System.out.println("Timestamp: " + timestamp);
//            System.out.println("Open: " + minuteData.getOpen());
//            System.out.println("High: " + minuteData.getHigh());
//            System.out.println("Low: " + minuteData.getLow());
//            System.out.println("Close: " + minuteData.getClose());
//            System.out.println("Volume: " + minuteData.getVolume());
//        });

        return stockDataResponse;
    }
}
