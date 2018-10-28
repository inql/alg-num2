package ug.gauss;

import java.math.BigInteger;

import ug.gauss.algorithm.GaussImpl;
import ug.gauss.datatypes.DataType;
import ug.gauss.datatypes.DoubleComp;
import ug.gauss.datatypes.FractionComp;
import ug.gauss.datatypes.MatrixCompatibleFactory;

public class Main {


    public static void main(String[] args) {

        int seed = 1;
        int size = 20;
        Randomizer rand = new Randomizer(seed);
        FractionComp[][] fractionComps = new FractionComp[10][11];
        FractionComp[] fractionComps1 = new FractionComp[11];
        for (int i =0; i<fractionComps.length; i++){
            for(int j =0; j<fractionComps[i].length; j++)
                fractionComps[i][j]=new FractionComp(new BigInteger(String.valueOf(rand.randomNumber())));
        }
        MyMatrix<FractionComp> compMyMatrix = new MyMatrix<>(fractionComps);
        System.out.println(compMyMatrix);

        compMyMatrix.swap(1,11,Swapper.COLUMN);
        System.out.println(compMyMatrix);

        compMyMatrix.swap(1,2,Swapper.ROW);
        System.out.println(compMyMatrix);



        GaussImpl fractionCompGauss = new GaussImpl(compMyMatrix,new MatrixCompatibleFactory(DataType.DOUBLE));
        DoubleComp[] result = (DoubleComp[]) fractionCompGauss.gauss();
        for (DoubleComp v :
                result) {
            System.out.println(v);
        }

    }
}
