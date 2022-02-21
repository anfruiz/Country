package co.com.bancolombia.api;

import co.com.bancolombia.model.country.Country;
import co.com.bancolombia.model.log.Log;
import co.com.bancolombia.usecase.country.CountryUseCase;
import co.com.bancolombia.usecase.log.LogUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/populationDensity/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {

    private final CountryUseCase countryUseCase;
    private final LogUseCase logUseCase;

    @GetMapping(path = "/countries/{quantity}")
    public ResponseEntity<List<Country>> getCountries(@PathVariable("quantity") int quantity) {
        logUseCase.save(quantity);
        return countryUseCase.getCountries(quantity).map(countries -> new ResponseEntity<>(countries, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(path = "/logs")
    public ResponseEntity<List<Log>> commandName() {
        return new ResponseEntity<>(logUseCase.getLogs(), HttpStatus.OK);
    }
}
