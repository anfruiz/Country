package co.com.bancolombia.consumer;

import co.com.bancolombia.model.country.Country;
import co.com.bancolombia.model.country.gateways.CountryRepository;
import com.google.gson.JsonParser;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestConsumer implements CountryRepository
{

    @Value("${adapter.restconsumer.url}")
    private String url;
    private final OkHttpClient client;

    @Override
    public Optional<List<Country>> getCountries(int quantity) throws IOException {
        List<Country> countries;
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
            Response response = client.newCall(request).execute();
            countries = ObjectResponse.toCountries(JsonParser.parseString(response.body().string()));
            countries.sort(Comparator.comparing(Country::getPopulationDensity).reversed());
        return Optional.of(countries.subList(0, quantity));
    }

}