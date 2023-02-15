import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import task2.CSVReader;
import task2.Country;

public class MainTask2_1 {

    // Highest populated country in each continent
    public static void main(String[] args) {
        String countryPathName = "./docs/Countries.csv";
        CSVReader r = new CSVReader();
        ArrayList<Country> countryList = r.readCountry(countryPathName);

        // {continent: {country: population}}
        Map<String, Map<String, Integer>> m = new HashMap<>();

        countryList.forEach((country) -> {

            Integer population = Integer.parseInt(country.getValues().get("population").toString());
            String key2 = country.getValues().get("name").toString();
            String key1 = country.getValues().get("continent").toString();

            if (key1.toString().trim().equals(country.getValues().get("continent").toString())) {

                if (m.get(key1) == null) {
                    Map<String, Integer> subMap = new HashMap<>();
                    subMap.put(key2, population);
                    m.put(key1, subMap);

                } else if (m.get(key1).get(key2) != null
                        & m.get(key1).get(m.get(key1).keySet().toArray()[0]) < population) {

                    Map<String, Integer> subMap = new HashMap<>();
                    subMap.put(key2, population);
                    m.put(key2, subMap);
                }
            }
        });

        for (Object key1 : m.keySet().toArray()) {
            Object key2 = m.get(key1).keySet().toArray()[0];
            Integer population = m.get(key1).get(m.get(key1).keySet().toArray()[0]);
            System.out.println(
                    "continent " + key1 + " most populated country is " + key2 + "with population of  " + population);
        }

    }
}
