import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import task2.*;

public class MainTask2_0 {

    // Highest populated city in each country.
    public static void main(String[] args) {
        String countryPathName = "./docs/Countries.csv";
        String cityPathName = "./docs/Cities.csv";
        CSVReader r = new CSVReader();
        ArrayList<Country> countryList = r.readCountry(countryPathName);
        ArrayList<City> cityList = r.readCity(cityPathName);

        // {countryCode: {cityName: population}}
        Map<String, Map<String, Integer>> m = new HashMap<>();

        cityList.forEach((city) -> {

            Object cityCode = city.getValues().get("countryCode");

            countryList.forEach((country) -> {

                Integer population = Integer.parseInt(city.getValues().get("population").toString());
                String key = country.getValues().get("code").toString();
                String cityName = city.getValues().get("name").toString();

                if (cityCode.toString().trim().equals(country.getValues().get("code").toString())) {

                    if (m.get(key) == null) {
                        Map<String, Integer> subMap = new HashMap<>();
                        subMap.put(cityName, population);
                        m.put(key, subMap);

                    } else if (m.get(key).get(cityName) != null
                            & m.get(key).get(m.get(key).keySet().toArray()[0]) < population) {

                        Map<String, Integer> subMap = new HashMap<>();
                        subMap.put(cityName, population);
                        m.put(key, subMap);
                    }
                }
            });
        });

        for (Object code : m.keySet().toArray()) {
            Object cityName = m.get(code).keySet().toArray()[0];
            Integer population = m.get(code).get(m.get(code).keySet().toArray()[0]);
            System.out.println("Country code " + code + " most populated city is " + cityName + "with population of  "
                    + population);
        }

    }
}
