package ug.gauss.algorithm;

import ug.gauss.ChoiceType;
import ug.gauss.datatypes.DataType;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvGenerator {

    private int[] matrixScope;

    public CsvGenerator(int[] matrixScope) {
        this.matrixScope = matrixScope;
    }

    public void writeCsv(){
        String filename = "wynik.csv";

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename));
            bufferedWriter.write("Raport\n\n");
            DataType[] dataTypes = {DataType.FLOAT,DataType.DOUBLE,DataType.FRACTION};
            ChoiceType[] choiceTypes = {ChoiceType.NONE,ChoiceType.PARTIAL,ChoiceType.FULL};
            for(DataType dataType : dataTypes){
                bufferedWriter.write(dataType.toString()+"\n\n");
                for(ChoiceType choiceType : choiceTypes){
                    bufferedWriter.write(choiceType.toString()+"\n"+"n;błąd;\n");
                    for(int matrixSize : matrixScope){
                        bufferedWriter.write(matrixSize+";");
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void getCalculations(int matrixSize){

    }
}
