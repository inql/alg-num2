package ug.gauss;

import java.math.BigInteger;

import ug.gauss.algorithm.GaussImpl;
import ug.gauss.datatypes.*;
import ug.gauss.operations.DataOperation;
import ug.gauss.operations.DoubleOperation;
import ug.gauss.operations.FractionOperation;

public class Main {


    public static void main(String[] args) {

        int seed = 1;
        int size = 20;
        Randomizer rand = new Randomizer(seed);

        DoubleComp[][] doubleComps = {
                {new DoubleComp(4*65536),new DoubleComp(-2*65536),new DoubleComp(4*65536),new DoubleComp(-2*65536),new DoubleComp(-2*65536)},
                {new DoubleComp(3*65536),new DoubleComp(1*65536),new DoubleComp(4*65536),new DoubleComp(2*65536),new DoubleComp(-2*65536)},
                {new DoubleComp(2*65536),new DoubleComp(4*65536),new DoubleComp(2*65536),new DoubleComp(1*65536),new DoubleComp(-2*65536)},
                {new DoubleComp(2*65536),new DoubleComp(-2*65536),new DoubleComp(4*65536),new DoubleComp(2*65536),new DoubleComp(-2*65536)}
        };

        MyMatrix<DoubleComp> compMyMatrix = new MyMatrix<>(doubleComps);
        System.out.println(compMyMatrix);

        GaussImpl dGauss = new GaussImpl(compMyMatrix,new MatrixCompatibleFactory(DataType.DOUBLE), new DoubleOperation());
        DoubleComp[] dResult = (DoubleComp[]) dGauss.gauss();
        for ( int i = 0; i < dResult.length; i++)
        {
            System.out.println(dResult[i] + ", ");
        }

        FractionComp[][] fractionComps = {
                {new FractionComp(4*65536), new FractionComp(-2*65536),new FractionComp(4*65536),new FractionComp(-2*65536),new FractionComp(-2*65536) },
                {new FractionComp(3*65536), new FractionComp(1*65536),new FractionComp(4*65536),new FractionComp(2*65536),new FractionComp(-2*65536) },
                {new FractionComp(2*65536), new FractionComp(4*65536),new FractionComp(2*65536),new FractionComp(1*65536),new FractionComp(-2*65536) },
                {new FractionComp(2*65536), new FractionComp(-2*65536),new FractionComp(4*65536),new FractionComp(2*65536),new FractionComp(-2*65536) },
        };

        MyMatrix<FractionComp> frMatrix = new MyMatrix<>(fractionComps);

        System.out.println(frMatrix);

        GaussImpl fractionCompGauss = new GaussImpl(frMatrix,new MatrixCompatibleFactory(DataType.FRACTION), new FractionOperation());
        FractionComp[] fResult = (FractionComp[]) fractionCompGauss.gauss();
        for ( int i = 0; i < fResult.length; i++)
        {

            System.out.println(fResult[i] + ", ");
        }





    }
}
