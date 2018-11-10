package ug.gauss.algorithm;

import ug.gauss.ChoiceType;
import ug.gauss.MyMatrix;
import ug.gauss.Randomizer;
import ug.gauss.Swapper;
import ug.gauss.datatypes.MatrixCompatible;
import ug.gauss.datatypes.MatrixCompatibleFactory;
import ug.gauss.operations.DataOperation;


import java.math.BigInteger;

public class GaussImpl {

    public MyMatrix myMatrix;
    final MatrixCompatibleFactory matrixCompatibleFactory;
    final Randomizer rand;
    final DataOperation dataOperation;
    final ChoiceType choiceType;

    public GaussImpl(MyMatrix myMatrix, MatrixCompatibleFactory matrixCompatibleFactory, DataOperation dataOperation, ChoiceType choiceType) {
        this.myMatrix = myMatrix;
        this.matrixCompatibleFactory = matrixCompatibleFactory;
        this.rand = new Randomizer();
        this.dataOperation = dataOperation;
        this.choiceType = choiceType;
    }

    //tutaj oskar sie starał ale mu nie wyszło :(
    //znaczy wyszło ale częściowo
    @SuppressWarnings("unchecked")
    public MatrixCompatible[] gauss() {
        int n = myMatrix.rows.length;
        MatrixCompatible[] resultVector = matrixCompatibleFactory.createArray(n);
        MatrixCompatible m;
        System.out.println(myMatrix);
        for (int i = 1; i < n; i++) {
//            switchRowOrColumn(i+1,i+1);
            for (int j = i + 1; j < n + 1; j++) {
                m = dataOperation.divide(myMatrix.getValue(j, i), myMatrix.getValue(i, i));
                m = dataOperation.multiply(m, matrixCompatibleFactory.createWithDenominator(new BigInteger("-1"), new BigInteger("1")));
                for (int k = i + 1; k <= n + 1; k++) {
                    myMatrix.setValue(j, k, dataOperation.add(
                            dataOperation.multiply(myMatrix.getValue(i, k), m), myMatrix.getValue(j, k))
                    );
                    System.out.println(myMatrix);
                }
            }
        }
        MatrixCompatible s = null;
        MatrixCompatible temp;
        for (int i = n; i >= 1; i--) {
            s = myMatrix.getValue(i,n+1);
            for (int j = n; j >= i + 1; j--) {
                temp = dataOperation.multiply(myMatrix.getValue(i, j), resultVector[myMatrix.columns[j-1]-1]);
                s = dataOperation.subtract(s, temp);
            }
            temp = myMatrix.getValue(i, i);
            s = dataOperation.divide(s, temp);
//            resultVector[i - 1] = s;
            resultVector[myMatrix.columns[i-1]-1] = s;
        }
        return resultVector;
    }

    @SuppressWarnings("unchecked")
    public MatrixCompatible[] binkus(MatrixCompatible[] vectorB){
        int n = vectorB.length;
        for(int p = 0; p<n; p++){

            //find row/column and swap
            switchRowOrColumn(p,p,vectorB);
            for(int i = p+1; i<n; i++){
                MatrixCompatible alpha = dataOperation.divide(myMatrix.getValue(i,p),myMatrix.getValue(p,p));
                vectorB[i] = dataOperation.subtract(vectorB[i],dataOperation.multiply(alpha,vectorB[p]));
                for (int j=p; j<n; j++){
                    myMatrix.setValue(i,j,dataOperation.subtract(myMatrix.getValue(i,j),dataOperation.multiply(alpha,myMatrix.getValue(p,j))));
                }
            }


        }

        MatrixCompatible[] vectorX = matrixCompatibleFactory.createArray(n);
        for (int i =n-1; i>=0; i--){
            MatrixCompatible sum = matrixCompatibleFactory.createWithDenominator(BigInteger.ZERO,BigInteger.ONE);
            for(int j = i+1; j<n; j++){
                sum = dataOperation.add(sum,dataOperation.multiply(myMatrix.getValue(i,j),vectorX[myMatrix.columns[j]]));
            }
            vectorX[myMatrix.columns[i]] = dataOperation.divide(dataOperation.subtract(vectorB[i],sum),myMatrix.getValue(i,i));
        }
        for(int i =0; i<vectorX.length; i++){
            vectorX[myMatrix.columns[i]].setValue(vectorX[myMatrix.columns[i]].getValue());
        }
        return vectorX;

    }

    @SuppressWarnings("unchecked")
    public MatrixCompatible[] switchRowOrColumn(int startX, int startY, MatrixCompatible[] vectorB){


        if(choiceType == ChoiceType.NONE)
            return vectorB;

        else if (choiceType == ChoiceType.PARTIAL)
        {
            int rowToSwitch = startX;
            for (int i=startX; i < myMatrix.rows.length; i++)
            {
                if ( dataOperation.abs(myMatrix.getValue(i,startY)).compareTo(dataOperation.abs(myMatrix.getValue(rowToSwitch,startY))) > 0)
                    rowToSwitch = i;

            }

            myMatrix.swap(startX,rowToSwitch, Swapper.ROW);
            MatrixCompatible temp = vectorB[startX];
            vectorB[startX] = vectorB[rowToSwitch];
            vectorB[rowToSwitch] = temp;

            return vectorB;

        } else if (choiceType == ChoiceType.FULL)
        {
            int rowToSwitch = startY;
            int columnToSwitch = startX;
            for (int i=startY; i < myMatrix.rows.length; i++)
            {
                for (int o=startX; o < myMatrix.columns.length; o++) {

                    if (dataOperation.abs(myMatrix.getValue(i, o)).compareTo(dataOperation.abs(myMatrix.getValue(rowToSwitch, columnToSwitch))) > 0) {
                        rowToSwitch = i;
                        columnToSwitch = o;
                    }
                }

            }
            myMatrix.swap(startX,rowToSwitch, Swapper.ROW);
            myMatrix.swap(startY,columnToSwitch, Swapper.COLUMN);
            MatrixCompatible temp = vectorB[startX];
            vectorB[startX] = vectorB[rowToSwitch];
            vectorB[rowToSwitch] = temp;

            return vectorB;

        }
        return vectorB;

    }

    @SuppressWarnings("unchecked")
    public MatrixCompatible[] multiplyMatrixWithVector(MyMatrix a, MatrixCompatible[] vector)
    {
        if (a.columns.length != vector.length)
            return null;
        MatrixCompatible[] result = matrixCompatibleFactory.createArray(vector.length);

        for (int i=0; i < vector.length; i++)
            result[i] = matrixCompatibleFactory.createWithNominator(new BigInteger("0"));

        for (int x = 0; x < vector.length; x++)
        {
            for (int y = 0; y < vector.length; y++)
            {
                result[x] = dataOperation.add(result[x], dataOperation.multiply(a.getValue(x, y), vector[y]));

            }

        }


        return result;
    }


}