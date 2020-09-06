package com.iprice.service.impl;

import com.iprice.service.DataExport;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.iprice.util.Constant.*;

public class DataExportImpl implements DataExport {

    /**
     * Method to generate CSV file
     *
     * @param s1- This is the parameter to pass the string to method
     */
    @Override
    public void generateCsvFile(String s1) {
        File file = new File(CSV_FILE_PATH);
        try {

            FileWriter outfile = new FileWriter(file);

            CSVWriter writer = new CSVWriter(outfile, ',');

            List<String[]> data = new ArrayList<String[]>();

            String[] splitedByChar = s1.split("");
            data.add(splitedByChar);

            writer.writeAll(data);
            writer.flush();
            writer.close();
            System.out.println(CSV_OUTPUT_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
