package co.com.bancolombia.usecase.country;

import co.com.bancolombia.model.country.Country;
import co.com.bancolombia.model.country.gateways.CountryRepository;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CountryUseCase {

    private final CountryRepository countryRepository;

    public Optional<List<Country>> getCountries (int quantity) {
        try {
            return countryRepository.getCountries(quantity);
        } catch (IOException e) {
            return Optional.empty();
        }
    }

}
