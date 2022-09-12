package com.parking.service;
// not required
 public class GeneratorService {
    static int DEFAULT_INITIAL_VALUE=1;
    static int  generatorNum=DEFAULT_INITIAL_VALUE;
     public static void setInitialGenerateNumValue(int generatorNumber)
    {
       generatorNum=generatorNumber;
    }
     public static int generate(){
        generatorNum++;
        return generatorNum-1;
    }
}
