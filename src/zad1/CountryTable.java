/**
 *
 *  @author Żurek Jakub S25434
 *
 */

package zad1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CountryTable {

    private final String fileName;
    private final List<Country> countryList = new ArrayList<>();
    private String[] columnsName;

    public CountryTable(String countriesFileName) {
        this.fileName = countriesFileName;
    }

    public JTable create() throws IOException {
        load();
        return new JTable(createRows(countryList), columnsName);
    }

    private void load() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        columnsName = reader.readLine().split("\t");
        String line;
        do {
            line = reader.readLine();
            if (line != null) {
                String[] countryData = line.split("\t");
                countryList.add(new Country(countryData[1], countryData[2], Integer.parseInt(countryData[3])));
            }
        } while (line != null);
    }

    DefaultTableModel model = new DefaultTableModel() {
        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return super.getColumnClass(columnIndex);
        }
    };

    private Object[][] createRows (List<Country> countryList) {
        int listLength = countryList.size();
        Object[][] rows = new Object[listLength][4];
        for (int i = 0; i < listLength; i++) {
            Country country = countryList.get(i);
            rows[i][0] = new ImageIcon(country.getFlag());
            rows[i][1] = country.getCountry();
            rows[i][2] = country.getCapital();
            rows[i][3] = country.getPopulation();
        }
        return rows;
    }






}
