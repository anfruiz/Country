package co.com.bancolombia.model.country;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    private String countryName;
    private Integer population;
    private Double area;
    private Double populationDensity;
}
