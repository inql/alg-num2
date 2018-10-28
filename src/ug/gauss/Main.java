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
//        DoubleComp[][] doubleComps = new DoubleComp[50][51];
//        for (int i =0; i<doubleComps.length; i++){
//            for(int j =0; j<doubleComps[i].length; j++)
//                doubleComps[i][j]=new DoubleComp(rand.randomNumber());
//        }

        DoubleComp[][] doubleComps = {{new DoubleComp(4*65536),new DoubleComp(-2*65536),new DoubleComp(4*65536),new DoubleComp(-2*65536),new DoubleComp(8*65536)},
                {new DoubleComp(3*65536),new DoubleComp(1*65536),new DoubleComp(4*65536),new DoubleComp(2*65536),new DoubleComp(7*65536)},
                {new DoubleComp(2*65536),new DoubleComp(4*65536),new DoubleComp(2*65536),new DoubleComp(1*65536),new DoubleComp(10*65536)},
                {new DoubleComp(2*65536),new DoubleComp(-2*65536),new DoubleComp(4*65536),new DoubleComp(2*65536),new DoubleComp(2*65536)}};

        MyMatrix<DoubleComp> compMyMatrix = new MyMatrix<>(doubleComps);
        System.out.println(compMyMatrix);

        GaussImpl fractionCompGauss = new GaussImpl(compMyMatrix,new MatrixCompatibleFactory(DataType.DOUBLE));
        DoubleComp[] result = (DoubleComp[]) fractionCompGauss.gauss();
        for (int i =0; i< result.length;i++) {
            System.out.println(result[i]);
        }

        //pokazówka jak działa compareTo :D:D

        DoubleComp pierwsza = new DoubleComp(4);
        DoubleComp druga = new DoubleComp(5);
        DoubleComp trzecia = new DoubleComp(4);
        System.out.println(pierwsza.compareTo(druga));
        System.out.println(druga.compareTo(pierwsza));
        System.out.println(pierwsza.compareTo(trzecia));

        // a tu ode

        FractionComp p = new FractionComp(10);
        FractionComp d = new FractionComp(12);
        FractionComp t = new FractionComp(10);

        System.out.println(p.compareTo(d));
        System.out.println(d.compareTo(p));
        System.out.println(p.compareTo(t));


    }
}
