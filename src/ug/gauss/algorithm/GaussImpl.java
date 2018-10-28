package ug.gauss.algorithm;

import ug.gauss.MyMatrix;
import ug.gauss.Randomizer;
import ug.gauss.datatypes.MatrixCompatible;
import ug.gauss.datatypes.MatrixCompatibleFactory;

import java.math.BigInteger;

public class GaussImpl {

    final MyMatrix myMatrix;
    final MatrixCompatibleFactory matrixCompatibleFactory;
    final Randomizer rand;

    public GaussImpl(MyMatrix myMatrix, MatrixCompatibleFactory matrixCompatibleFactory) {
        this.myMatrix = myMatrix;
        this.matrixCompatibleFactory = matrixCompatibleFactory;
        this.rand = new Randomizer();
    }

    public MatrixCompatible[] gauss() {
        int n = 10;
        MatrixCompatible[] resultVector = matrixCompatibleFactory.createArray(n);
        MatrixCompatible m = matrixCompatibleFactory.createWithNominator(new BigInteger("0"));


        //todo: oskar zrub
        for (int i =0; i<n; i++){
            resultVector[i] = matrixCompatibleFactory.createWithNominator(new BigInteger(String.valueOf(rand.randomNumber())));
        }
        System.out.println(m);
        return resultVector;
    }

}