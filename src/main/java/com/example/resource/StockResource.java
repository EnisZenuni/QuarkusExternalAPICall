package com.example.resource;

import com.example.AlphaVantageResource;
import com.example.model.StockDataResponse;
import io.vertx.core.Vertx;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

//@Path("/api/stocks")
//public class StockResource {
//
//    @Inject
//    @RestClient
//    AlphaVantageResource alphaVantageResource;
//
//    @GET
//    @Path("/intraday")
//    @Produces(MediaType.APPLICATION_JSON)
//    public StockDataResponse get(
//            @QueryParam("function") String function,
//            @QueryParam("symbol") String symbol,
//            @QueryParam("interval") String interval,
//            @QueryParam("apikey") String apiKey
//    ) {
//        return alphaVantageResource.getData(function, symbol, interval, apiKey);
//    }
//}
