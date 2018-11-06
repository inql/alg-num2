package ug.gauss.algorithm;

import ug.gauss.ChoiceType;
import ug.gauss.MyMatrix;
import ug.gauss.Randomizer;
import ug.gauss.Swapper;
import ug.gauss.datatypes.DataType;
import ug.gauss.datatypes.MatrixCompatible;
import ug.gauss.datatypes.MatrixCompatibleFactory;
import ug.gauss.operations.DataOperation;

import java.math.BigInteger;
import java.util.Arrays;

public class ResultGenerator<T extends MatrixCompatible> {

    private Randomizer randomizer;
    private int matrixSize;
    private ChoiceType choiceType;
    private DataType dataType;
    private final MatrixCompatibleFactory matrixCompatibleFactory;
    private MyMatrix<T> myMatrix;
    private MatrixCompatible[] vectorX;
    private DataOperation dataOperation;
    private GaussImpl gauss;

    public ResultGenerator(int seed, int matrixSize, ChoiceType choiceType, DataType dataType, DataOperation dataOperation) {
        this.randomizer = new Randomizer(seed);
        this.matrixSize = matrixSize;
        this.choiceType = choiceType;
        this.dataType = dataType;
        this.matrixCompatibleFactory = new MatrixCompatibleFactory(dataType);
        this.dataOperation = dataOperation;
        this.gauss = new GaussImpl(myMatrix,matrixCompatibleFactory,dataOperation);
    }

    public MyMatrix<T> generateMatrix(int size){
        MatrixCompatible[][] matrix = matrixCompatibleFactory.createMatrix(size,size+1);
        for (int i =0; i<matrix.length; i++){
            for(int j =0; j<matrix[i].length-1; j++){
                matrix[i][j] = matrixCompatibleFactory.createWithNominator(new BigInteger(String.valueOf(randomizer.randomNumber())));
//                matrix[i][j] = matrixCompatibleFactory.createWithDenominator(new BigInteger(i+j+""),BigInteger.ONE);
            }
        }



        this.vectorX = matrixCompatibleFactory.createArray(size);
        for (int i =0; i<vectorX.length; i++){
            vectorX[i] = matrixCompatibleFactory.createWithNominator(new BigInteger(String.valueOf(randomizer.randomNumber())));
//            vectorX[i]= matrixCompatibleFactory.createWithDenominator(new BigInteger(i+""),BigInteger.ONE);
        }
        //tutaj mnożenie
        //temporary xd
        myMatrix = new MyMatrix<T>((T[][]) matrix);


        MatrixCompatible[] vectorB = gauss.MultiplyMatrixWithVector(this.myMatrix,vectorX);
        for (int i=0; i<matrix.length;i++){
            matrix[i][matrix[i].length-1] = vectorB[i];
        }
        MyMatrix<T> result = new MyMatrix<>((T[][]) matrix);

        // swapowanie
        // Wyswietla stan macierzy przed i po zmianie
        System.out.println(result);
        if (choiceType == ChoiceType.PARTIAL)
        {
            int rowToSwitch = 1;
            for (int i=1; i <= result.rows.length; i++)
            {
                if ( result.getValue(i,1).compareTo(result.getValue(rowToSwitch,1)) > 0)
                    rowToSwitch = i;

            }

            result.swap(1,rowToSwitch, Swapper.ROW);

        } else if (choiceType == ChoiceType.FULL)
        {
            int rowToSwitch = 1;
            int columnToSwitch = 1;
            for (int i=1; i <= result.rows.length; i++)
            {
                for (int o=1; o < result.columns.length; o++) {

                    if (result.getValue(i, o).compareTo(result.getValue(rowToSwitch, columnToSwitch)) > 0) {
                        rowToSwitch = i;
                        columnToSwitch = o;
                    }
                }

            }
            result.swap(1,rowToSwitch, Swapper.ROW);
            result.swap(1,columnToSwitch, Swapper.COLUMN);

        }


        return result;
    }

    public void doTests(){
        this.myMatrix = generateMatrix(matrixSize);
        System.out.println(myMatrix);
        System.out.println(Arrays.deepToString(vectorX));

    }


}
