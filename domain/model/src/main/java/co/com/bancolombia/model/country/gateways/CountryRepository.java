package co.com.bancolombia.model.country.gateways;

import co.com.bancolombia.model.country.Country;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface CountryRepository {

     Optional<List<Country>> getCountries(int quantity) throws IOException;
}
