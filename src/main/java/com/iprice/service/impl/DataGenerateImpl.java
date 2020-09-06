package com.iprice.service.impl;

import com.iprice.service.DataGenerate;

public class DataGenerateImpl implements DataGenerate {

    /**
     * Method to get uppercase of string
     *
     * @param s1- This is the parameter to pass the string to method
     */
    @Override
    public String convertToUpperCase(String s1) {
        return s1.toUpperCase();
    }

    /**
     * Method to get alternative upper and lower case of string
     *
     * @param s1- This is the parameter to pass the string to method
     */
    @Override
    public String convertToAlternateCase(String s1) {
        s1 = s1.toLowerCase();
        char[] ch = s1.toCharArray();
        for (int i = 1; i < ch.length; i = i + 2) {
            ch[i] = Character.toUpperCase(ch[i]);
        }
        return new String(ch);
    }
}
