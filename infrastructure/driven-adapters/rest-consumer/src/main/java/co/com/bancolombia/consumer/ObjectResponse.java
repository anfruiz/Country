package co.com.bancolombia.consumer;

import co.com.bancolombia.model.country.Country;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ObjectResponse {


    public static List<Country> toCountries(JsonElement jsonElement) {
        List<Country> countries = new ArrayList<>();
        Iterator<JsonElement> paises = jsonElement.getAsJsonArray().iterator();
        for (Iterator<JsonElement> it = paises; it.hasNext(); ) {
            JsonElement element = it.next();
            String name = element.getAsJsonObject().get("name").getAsJsonObject().get("official").getAsString();
            Double area = element.getAsJsonObject().get("area").getAsDouble();
            Integer population = element.getAsJsonObject().get("population").getAsInt();
            Double populationDensity = area/population;
            countries.add(new Country(name, population, area, populationDensity));
        }
        return countries;
    }

}