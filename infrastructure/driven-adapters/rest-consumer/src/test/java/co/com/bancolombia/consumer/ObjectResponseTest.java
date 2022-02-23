package co.com.bancolombia.consumer;

import co.com.bancolombia.model.country.Country;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ObjectResponseTest {

    @Test
    void shouldGetObjectResponse() {
        JsonElement jsonElement = JsonParser.parseString("[{\"name\":{\"common\":\"Country 1\",\"official\":\"Mock Country 1\"},\"area\": 40.0,\"population\": 20},{\"name\":{\"common\":\"Country 2\",\"official\":\"Mock Country 2\"},\"area\": 10.0,\"population\": 20}]");
        List<Country> countriesResponse = ObjectResponse.toCountries(jsonElement);
        List<Country> countriesExpected = new ArrayList<>();
        countriesExpected.add(new Country("Mock Country 1", 20, 40.0, 0.5));
        countriesExpected.add(new Country("Mock Country 2", 20, 10.0, 2.0));
        Assertions.assertEquals(countriesExpected, countriesResponse);
    }
}
