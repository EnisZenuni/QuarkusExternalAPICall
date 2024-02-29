package com.example.resource;

import com.example.AlphaVantageResource;
import com.example.model.StockDataResponse;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import io.quarkus.vertx.ConsumeEvent;
import io.vertx.core.Vertx;
import io.vertx.core.http.ServerWebSocket;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.io.StringReader;


//TODO maybe add /stocks/live-data/{SYMBOL (IBM, MICROSOFT) etc...}
//TODO maybe add /stocks/live-data/{SYMBOL (IBM, MICROSOFT) etc...}

@ServerEndpoint("/api/stocks/live")
@ApplicationScoped
public class StockWebSocket {

    @Inject
    @RestClient
    AlphaVantageResource alphaVantageResource;

    @OnMessage
    public void onMessage(Session session, String message) {
        JsonObject jsonMessage = Json.createReader(new StringReader(message)).readObject();
        String function = jsonMessage.getString("function");
        String symbol = jsonMessage.getString("symbol");
        String interval = jsonMessage.getString("interval");
        String apiKey = jsonMessage.getString("apiKey");

        // Use Uni to perform the API call in a non-blocking way
        alphaVantageResource.getData(function, symbol, interval, apiKey)
                .subscribe().with(
                        stockDataJson -> {
                            // Send the JSON string directly to the client
                            session.getAsyncRemote().sendText(stockDataJson);
                        },
                        Throwable::printStackTrace);
    }
}