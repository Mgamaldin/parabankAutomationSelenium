package com.parabank.Utils;

import java.util.Random;

public class Randomizer {


    public static String generateRandomizedNumber(){
        Random r = new Random();
        int low = 1;
        int high = 1000;
        int result = r.nextInt(high-low)+low;
        return String.valueOf(result);
    }

}
