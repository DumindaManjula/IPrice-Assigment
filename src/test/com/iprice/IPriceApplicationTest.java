package com.iprice;

import com.iprice.service.DataExport;
import com.iprice.service.DataGenerate;
import com.iprice.service.impl.DataExportImpl;
import com.iprice.service.impl.DataGenerateImpl;
import org.junit.After;
import org.junit.jupiter.api.Test;


import java.io.File;

import static org.junit.jupiter.api.Assertions.*;
import static com.iprice.util.Constant.*;

class IPriceApplicationTest {

    // This test case is used to test convertToUpperCase method
    @Test
    void convertToUpperCase() {
        DataGenerate dataGenerate = new DataGenerateImpl();
        String str = dataGenerate.convertToUpperCase("hello world");
        assertEquals("HELLO WORLD", str);
    }

    // This test case is used to test convertToUpperCase method with mixed uppercase and lowercase
    @Test
    void convertToUpperCaseMixedUpperCaseChar() {
        DataGenerate dataGenerate = new DataGenerateImpl();
        String str = dataGenerate.convertToUpperCase("hElLO woRlD");
        assertEquals("HELLO WORLD", str);
    }

    // This test case is used to test convertToUpperCase method with mixed numbers, letters and symbols
    @Test
    void convertToUpperMixedWithNumbersAndSymbols() {
        DataGenerate dataGenerate = new DataGenerateImpl();
        String str = dataGenerate.convertToUpperCase("hElLO123456<>||");
        assertEquals("HELLO123456<>||", str);
    }

    // This test case is used to test convertToAlternateCase method
    @Test
    void convertToAlternateCase() {
        DataGenerate dataGenerate = new DataGenerateImpl();
        String str = dataGenerate.convertToAlternateCase("hello world");
        assertEquals("hElLo wOrLd", str);
    }

    // This test case is used to test convertToAlternateCase method with mixed uppercase and lowercase
    @Test
    void convertToAlternateCaseMixedUpperCaseChar() {
        DataGenerate dataGenerate = new DataGenerateImpl();
        String str = dataGenerate.convertToAlternateCase("heLLo wORld");
        assertEquals("hElLo wOrLd", str);
    }

    // This test case is used to test convertToAlternateCase method with mixed numbers, letters and symbols
    @Test
    void convertToAlternateCaseMixedWithNumbersAndSymbols() {
        DataGenerate dataGenerate = new DataGenerateImpl();
        String str = dataGenerate.convertToAlternateCase("hello12345<>||");
        assertEquals("hElLo12345<>||", str);
    }

    // This test case is used to test check if CSV file generated
    @Test
    void generateCsvFile() {
        DataExport dataExport = new DataExportImpl();
        dataExport.generateCsvFile("hello world");
        File file = new File(CSV_FILE_PATH);
        assertTrue(file.exists());
    }

    // This test case is used to delete generated CSV file in test case execution
    @After
    public void deleteOutputFile() {
        File file = new File(CSV_FILE_PATH);
        if (file.exists()) {
            file.delete();
        }
    }
}