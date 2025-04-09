package API.Auth;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class base_token {
    protected static final String BASE_URL = "https://gorest.co.in/public/v2/";
    protected static final String TOKEN = "e4fd387df83adbf8f17a9ec7a7e1edac5b13ec51ed1c2d99ad958191a51df3cc"; // Store

    protected RequestSpecification requestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .addHeader("Authorization", "Bearer " + TOKEN)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
    }
}
