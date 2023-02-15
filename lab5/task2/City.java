package task2;

import java.util.HashMap;
import java.util.Map;

public class City {
    private int id;
    private String name;
    private int population;
    private String countryCode;

    public City(int id, String name, int population, String countryCode) {
        this.setValues(id, name, population, countryCode);
    }

    public Map<String, Object> getValues() {

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("id", this.id);
        map.put("name", this.name);
        map.put("population", this.population);
        map.put("countryCode", this.countryCode);

        return map;
    }

    public void setValues(int id, String name, int population, String countryCode) {

        this.name = name;
        this.population = population;
        this.population = population;
        this.countryCode = countryCode;

    }
}
