package co.com.bancolombia.consumer;

import co.com.bancolombia.model.country.Country;
import okhttp3.*;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@ExtendWith({SpringExtension.class})
@SpringBootTest(classes = {RestConsumer.class})
public class RestConsumerTest {

    private Response countriesResponse;
    private List<Country> countries;

    @InjectMocks
    private RestConsumer restConsumer;

    @Mock
    private OkHttpClient client;

    @Mock
    private Call call;

    @Before
    public void initializate() {


        countriesResponse = new Response.Builder()
                .request(new Request.Builder().url("").build())
                .protocol(Protocol.HTTP_2)
                .code(200)
                .body(ResponseBody.create(MediaType.get("application/json"), "{}"))
                .build();

        countries.add(new Country("Mock Country 1", 20, 10.0, 2.0));
        countries.add(new Country("Mock Country 2", 30, 30.0, 1.0));
        countries.add(new Country("Mock Country 3", 40, 80.0, 0.5));
    }

    @Test
    public void validateRequest200() throws IOException {
        Mockito.when(client.newCall(ArgumentMatchers.any())).thenReturn(call);
        Mockito.when(client.newCall(ArgumentMatchers.any()).execute()).thenReturn(countriesResponse);
        Mockito.when(ObjectResponse.toCountries(ArgumentMatchers.any())).thenReturn(countries);

        Optional<List<Country>> countryList = restConsumer.getCountries(1);

        Assertions.assertEquals(countryList, Optional.of(countries.get(0)));
    }
}
