package ug.gauss;

import java.util.Random;

import ug.gauss.datatypes.FractionComp;

public class Main {

    static int randomNumber(int seed)
    {
        Random random = new Random();
        return random.ints(-65536,(65536)).findFirst().getAsInt();
    }


    public static void main(String[] args) {

        MyMatrix<FractionComp> mm = new MyMatrix<FractionComp>();
        System.out.println(Main.randomNumber(1));

    }
}
