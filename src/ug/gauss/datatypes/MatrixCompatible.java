package ug.gauss.datatypes;

public interface MatrixCompatible<T1,T2> {

    double estimate();
    T2 getValue();
    void setValue(T2 value);
    void add(T1 t1);
    void substract(T1 t1);
    void multiply(T1 t1);
    void divide(T1 t1);

}
