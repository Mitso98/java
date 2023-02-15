package task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {

    public ArrayList<Country> readCountry(String pathName) {
        String line = "";
        String splitBy = ",";
        ArrayList<Country> cList = new ArrayList<>();
        try {
            try (// parsing a CSV file into BufferedReader class constructor
                    BufferedReader br = new BufferedReader(new FileReader(pathName))) {
                while ((line = br.readLine()) != null)
                // returns a Boolean value
                {
                    String[] country = line.split(splitBy);
                    // use comma as separator

                    try {
                        cList.add(new Country(country[0], country[1], country[2], Double.parseDouble(country[3]),
                                Integer.parseInt(country[4]),
                                Double.parseDouble(country[5]),
                                Integer.parseInt(country[6])));
                    } catch (Exception e) {
                        System.out.println("#########Error#######");
                        System.out.println(e.getMessage());
                        System.out.println("countryID " + country[0] + "countryName " + country[1]);
                        System.out.println("#########Error#######");
                    }

                }
            } catch (NumberFormatException e) {
                System.out.println("#########Error#######");
                e.printStackTrace();
                System.out.println("#########Error#######");
            }
        } catch (IOException e) {
            System.out.println("#########Error#######");
            e.printStackTrace();
            System.out.println("#########Error#######");
        }
        return cList;

    }

    public ArrayList<City> readCity(String pathName) {
        String line = "";
        String splitBy = ",";
        ArrayList<City> cList = new ArrayList<>();
        try {
            try (// parsing a CSV file into BufferedReader class constructor
                    BufferedReader br = new BufferedReader(new FileReader(pathName))) {
                while ((line = br.readLine()) != null)
                // returns a Boolean value
                {
                    String[] city = line.split(splitBy);
                    // use comma as separator

                    cList.add(new City(
                            Integer.parseInt(city[0]), city[1], Integer.parseInt(city[2]), city[3]));

                }
            } catch (NumberFormatException e) {
                System.out.println("#########Error#######");
                e.printStackTrace();
                System.out.println("#########Error#######");
            }
        } catch (IOException e) {
            System.out.println("#########Error#######");
            e.printStackTrace();
            System.out.println("#########Error#######");
        }
        return cList;

    }
}
