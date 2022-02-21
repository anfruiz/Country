package co.com.bancolombia.model.log;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class Log {

    private Timestamp id;
    private Integer numberOfCountries;
}
