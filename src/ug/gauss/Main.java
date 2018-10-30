package ug.gauss;

import java.math.BigInteger;

import ug.gauss.algorithm.GaussImpl;
import ug.gauss.datatypes.*;
import ug.gauss.operations.FractionOperation;

public class Main {


    public static void main(String[] args) {

        int seed = 1;
        int size = 20;
        Randomizer rand = new Randomizer(seed);
//        DoubleComp[][] doubleComps = new DoubleComp[50][51];
//        for (int i =0; i<doubleComps.length; i++){
//            for(int j =0; j<doubleComps[i].length; j++)
//                doubleComps[i][j]=new DoubleComp(rand.randomNumber());
//        }

        DoubleComp[][] doubleComps = {{new DoubleComp(4*65536),new DoubleComp(-2*65536),new DoubleComp(4*65536),new DoubleComp(-2*65536)},
                {new DoubleComp(3*65536),new DoubleComp(1*65536),new DoubleComp(4*65536),new DoubleComp(2*65536)},
                {new DoubleComp(2*65536),new DoubleComp(4*65536),new DoubleComp(2*65536),new DoubleComp(1*65536)},
                {new DoubleComp(2*65536),new DoubleComp(-2*65536),new DoubleComp(4*65536),new DoubleComp(2*65536)}};

        MyMatrix<DoubleComp> compMyMatrix = new MyMatrix<>(doubleComps);
        System.out.println(compMyMatrix);

        GaussImpl fractionCompGauss = new GaussImpl(compMyMatrix,new MatrixCompatibleFactory(DataType.DOUBLE),new FractionOperation());

        /*
        DoubleComp[] result = (DoubleComp[]) fractionCompGauss.gauss();
        for (int i =0; i< result.length;i++) {
            System.out.println(result[i]);
        }
        */

        DoubleComp[][] testingVector = {{new DoubleComp(4*65536)},{new DoubleComp(1*65536)},{new DoubleComp(3*65536)},{new DoubleComp(5*65536)},};

//        MyMatrix<DoubleComp> vec = new MyMatrix<>(testingVector);
//        MyMatrix test2 = fractionCompGauss.multiplyMatrices(compMyMatrix, vec);
//        System.out.println(test2);



    }
}
