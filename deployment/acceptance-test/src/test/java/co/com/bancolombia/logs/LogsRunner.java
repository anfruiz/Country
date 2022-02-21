package co.com.bancolombia.logs;

import com.intuit.karate.junit5.Karate;

public class LogsRunner {
    @Karate.Test
    Karate demo() {
        return Karate.run("classpath:co/com/bancolombia/logs/logs.feature").relativeTo(getClass());
    }

}
