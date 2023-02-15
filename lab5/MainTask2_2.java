import java.util.ArrayList;

import task2.CSVReader;
import task2.City;
import task2.Country;

/**
 * InnerMainTask2_2
 */
abstract class InnerMainTask2_2 {
    static Integer highestPop = 0;
    static String cityName = "";
    static String countryName = "";

}

public class MainTask2_2 {
    // Find the highest populated capital city
    public static void main(String[] args) {
        String countryPathName = "./docs/Countries.csv";
        String cityPathName = "./docs/Cities.csv";
        CSVReader r = new CSVReader();
        ArrayList<Country> countryList = r.readCountry(countryPathName);
        ArrayList<City> cityList = r.readCity(cityPathName);

        countryList.forEach((country) -> {
            Object capital = country.getValues().get("capital").toString();
            cityList.forEach((city) -> {
                Integer population = Integer.parseInt(city.getValues().get("population").toString());
                boolean isCapital = city.getValues().get("population").toString().equals(capital);
                if (isCapital & population > InnerMainTask2_2.highestPop) {
                    InnerMainTask2_2.highestPop = population;
                    InnerMainTask2_2.countryName = city.getValues().get("name").toString();
                    InnerMainTask2_2.cityName = country.getValues().get("name").toString();
                }
            });

        });

        System.out.println("Country " + InnerMainTask2_2.countryName + " Capital " + InnerMainTask2_2.cityName
                + " population " + InnerMainTask2_2.highestPop);
    }
}
