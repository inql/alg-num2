package ug.gauss.algorithm;

import ug.gauss.ChoiceType;
import ug.gauss.MyMatrix;
import ug.gauss.Randomizer;
import ug.gauss.datatypes.DataType;
import ug.gauss.datatypes.MatrixCompatible;
import ug.gauss.datatypes.MatrixCompatibleFactory;

import java.math.BigInteger;

public class ResultGenerator<T extends MatrixCompatible> {

    private Randomizer randomizer;
    private int matrixSize;
    private ChoiceType choiceType;
    private DataType dataType;
    private final MatrixCompatibleFactory matrixCompatibleFactory;
    private MyMatrix<T> myMatrix;
    private MatrixCompatible[] vectorX;
   // private final GaussImpl gauss;

    public ResultGenerator(int seed, ChoiceType choiceType, DataType dataType) {
        this.randomizer = new Randomizer(seed);
        this.choiceType = choiceType;
        this.dataType = dataType;
        this.matrixCompatibleFactory = new MatrixCompatibleFactory(dataType);
    }

    public MyMatrix<T> generateMatrix(int size){
        MatrixCompatible[][] matrix = matrixCompatibleFactory.createMatrix(size,size+1);
        for (int i =0; i<matrix.length; i++){
            for(int j =0; j<matrix[i].length-1; j++){
                matrix[i][j] = matrixCompatibleFactory.createWithNominator(new BigInteger(String.valueOf(randomizer.randomNumber())));
            }
        }
        this.vectorX = matrixCompatibleFactory.createArray(size);
        for (int i =0; i<vectorX.length; i++){
            vectorX[i] = matrixCompatibleFactory.createWithNominator(new BigInteger(String.valueOf(randomizer.randomNumber())));
        }
        //tutaj mnożenie
        //temporary xd
        MatrixCompatible[] vectorB = new MatrixCompatible[size];
        for (int i=0; i<matrix.length;i++){
            matrix[i][matrix[i].length-1] = vectorB[i];
        }
        MyMatrix<T> result = new MyMatrix<>((T[][]) matrix);
        return result;
    }

    public void doTests(){
        this.myMatrix = generateMatrix(matrixSize);

    }





}
