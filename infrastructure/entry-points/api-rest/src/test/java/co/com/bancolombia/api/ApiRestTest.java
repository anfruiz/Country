package co.com.bancolombia.api;

import co.com.bancolombia.model.country.Country;
import co.com.bancolombia.model.log.Log;
import co.com.bancolombia.usecase.country.CountryUseCase;
import co.com.bancolombia.usecase.log.LogUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = {ApiRest.class})
public class ApiRestTest {

    private List<Country> countries = new ArrayList<>();
    private List<Log> logs = new ArrayList<>();
    private ApiRest apiRest;

    @MockBean
    private CountryUseCase countryUseCase;

    @MockBean
    private LogUseCase logUseCase;

    @BeforeEach
    void initializa() {
        countries.add(new Country("Mock Country 1", 20, 10.0, 2.0));
        countries.add(new Country("Mock Country 2", 30, 30.0, 1.0));
        countries.add(new Country("Mock Country 3", 40, 80.0, 0.5));
        logs.add(new Log(Timestamp.valueOf(LocalDateTime.now()), 9));
        logs.add(new Log(Timestamp.valueOf(LocalDateTime.now()), 10));
        apiRest = new ApiRest(countryUseCase, logUseCase);
    }

    @Test
    void get_countries_with_httpStatus_OK() {
        Mockito.when(countryUseCase.getCountries(ArgumentMatchers.anyInt())).thenReturn(Optional.of(countries));
        ResponseEntity<List<Country>> httpResponse = apiRest.getCountries(3);
        Assertions.assertEquals(httpResponse.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(countries, httpResponse.getBody());
    }

    @Test
    void get_countries_with_httpStatus_NOTFOUND() {
        Mockito.when(countryUseCase.getCountries(ArgumentMatchers.anyInt())).thenReturn(Optional.empty());
        ResponseEntity<List<Country>> httpResponse = apiRest.getCountries(2);
        Assertions.assertEquals(httpResponse.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Test
    void call_logUseCase_save_when_get_countries() {
        Mockito.doNothing().when(logUseCase).save(ArgumentMatchers.anyInt());
        Mockito.when(countryUseCase.getCountries(ArgumentMatchers.anyInt())).thenReturn(Optional.of(countries));
        ResponseEntity<List<Country>> httpResponse = apiRest.getCountries(3);
        Mockito.verify(logUseCase, Mockito.times(1)).save(ArgumentMatchers.anyInt());
    }

    @Test
    void get_logs_with_httpStatus_OK() {
        Mockito.when(logUseCase.getLogs()).thenReturn(logs);
        ResponseEntity<List<Log>> httpResponse = apiRest.getLogs();
        Assertions.assertEquals(httpResponse.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(logs, httpResponse.getBody());
    }
}
