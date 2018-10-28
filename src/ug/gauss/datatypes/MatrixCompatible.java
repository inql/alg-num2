package ug.gauss.datatypes;

public interface MatrixCompatible<T1,T2> {

    T2 getValue();
    T1 setValue(int value);
    T1 add(T1 t1);
    T1 substract(T1 t1);
    T1 multiply(T1 t1);
    T1 divide(T1 t1);
    T1 clonexD();

}
