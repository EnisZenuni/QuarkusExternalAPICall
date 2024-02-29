package com.example;

import com.example.model.StockDataResponse;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "https://www.alphavantage.co")
@RegisterClientHeaders
public interface AlphaVantageResource {

    @GET
    @Path("/query")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<String> getData(
            @QueryParam("function") String function,
            @QueryParam("symbol") String symbol,
            @QueryParam("interval") String interval,
            @QueryParam("apikey") String apiKey
    );
}