package co.com.bancolombia.countries;

import com.intuit.karate.junit5.Karate;

public class CountryRunner {

    @Karate.Test
    Karate demo() {
        return Karate.run("classpath:co/com/bancolombia/countries/countries.feature").relativeTo(getClass());
    }
}
