package co.com.bancolombia.jpa.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@Table(name = "country_log")
public class LogsEntity {

    @Id
    private Timestamp id;

    @Column(name = "number_of_countries")
    private Integer numberOfCountries;
}
