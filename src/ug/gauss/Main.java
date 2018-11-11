package ug.gauss;

import ug.gauss.algorithm.GaussImpl;
import ug.gauss.tests.CsvGenerator;
import ug.gauss.tests.ResultGenerator;
import ug.gauss.datatypes.*;
import ug.gauss.operations.DoubleOperation;
import ug.gauss.operations.FloatOperation;
import ug.gauss.operations.FractionOperation;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {


    public static void main(String[] args) {
        typicalExecution();

    }

    public static void typicalExecution(){
        long startTime = System.nanoTime();

        int[] testScope = new int[2];
//        for(int i = 10; i<=20; i+=10){
//            testScope[(i/10)-1] = i;
//        }
        testScope[0] = 4;
        testScope[1] = 5;
        CsvGenerator csvGenerator = new CsvGenerator(testScope);
        csvGenerator.writeCsv();
        long stopTime = System.nanoTime();
        System.out.println(stopTime-startTime);

    }
}
