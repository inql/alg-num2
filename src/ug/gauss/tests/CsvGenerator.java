package ug.gauss.tests;

import ug.gauss.ChoiceType;
import ug.gauss.datatypes.DataType;
import ug.gauss.datatypes.DoubleComp;
import ug.gauss.datatypes.FloatComp;
import ug.gauss.datatypes.FractionComp;
import ug.gauss.operations.DoubleOperation;
import ug.gauss.operations.FloatOperation;
import ug.gauss.operations.FractionOperation;
import ug.gauss.tests.ResultGenerator;

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
                        bufferedWriter.write(matrixSize+";"+getCalculations(matrixSize,choiceType,dataType)+"\n");
                    }
                    bufferedWriter.write("\n");

                }
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private AggregatedResults getCalculations(int matrixSize, ChoiceType choiceType, DataType dataType){
        ResultGenerator resultGenerator;
        AggregatedResults aggregatedResults = new AggregatedResults();
        for(int i =0; i<matrixSize%3; i++){
            if(dataType==DataType.FRACTION)
                resultGenerator = new ResultGenerator<FractionComp>(i,matrixSize,choiceType,dataType,new FractionOperation());
            else if(dataType==DataType.FLOAT)
                resultGenerator = new ResultGenerator<FloatComp>(i,matrixSize,choiceType,dataType,new FloatOperation());
            else
                resultGenerator = new ResultGenerator<DoubleComp>(i,matrixSize,choiceType,dataType,new DoubleOperation());
            aggregatedResults.updateAggregatedResults(resultGenerator.doTests());
        }
        aggregatedResults.divideByExecutionCount();

        return aggregatedResults;

    }
}
