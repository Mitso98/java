package task2;

import java.util.HashMap;
import java.util.Map;

public class Country {
    private String code;
    private String name;
    private String continent;
    private double surfaceArea;
    private int population;
    private double gnp;
    private int capital;

    public Country(String code, String name, String continent, double surfaceArea, int population, double gnp,
            int capital) {
        this.setValues(code, name, continent, surfaceArea, population, gnp, capital);
    }

    public Map<String, Object> getValues() {

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("code", this.code);
        map.put("name", this.name);
        map.put("continent", this.continent);
        map.put("surfaceArea", this.surfaceArea);
        map.put("population", this.population);
        map.put("gnp", this.gnp);
        map.put("capital", this.capital);

        return map;
    }

    public void setValues(String code, String name, String continent, double surfaceArea, int population, double gnp,
            int capital) {

        this.code = code;
        this.name = name;
        this.continent = continent;
        this.surfaceArea = surfaceArea;
        this.population = population;
        this.gnp = gnp;
        this.capital = capital;

    }

}
