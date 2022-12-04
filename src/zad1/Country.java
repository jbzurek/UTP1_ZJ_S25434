/**
 *
 *  @author Żurek Jakub S25434
 *
 */

package zad1;

public class Country {

    private final String flag;
    private final String country;
    private final String capital;
    private final int population;

    public Country(String country, String capital, int population) {
        this.flag = "BaH.png";
        this.country = country;
        this.capital = capital;
        this.population = population;
    }

    public String getFlag() {
        return flag;
    }

    public String getCountry() {
        return country;
    }

    public String getCapital() {
        return capital;
    }

    public int getPopulation() {
        return population;
    }
}
