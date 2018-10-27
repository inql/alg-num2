package ug.gauss.datatypes;

public class DoubleComp implements MatrixCompatible<DoubleComp,Double> {

    private double value;

    public DoubleComp(double value) {
        this.value = value/65536;
    }

    @Override
    public Double getValue() {
        return value;
    }

    @Override
    public void setValue(Double value) {
        this.value = value/65536;
    }

    @Override
    public void add(DoubleComp doubleComp) {
        this.value+=doubleComp.getValue();
    }

    @Override
    public void substract(DoubleComp doubleComp) {
        this.value-=doubleComp.getValue();
    }

    @Override
    public void multiply(DoubleComp doubleComp) {
        this.value*=doubleComp.getValue();
    }

    @Override
    public void divide(DoubleComp doubleComp) {
        this.value/=doubleComp.getValue();
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
