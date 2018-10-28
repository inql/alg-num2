package ug.gauss.datatypes;

public class FloatComp implements MatrixCompatible<FloatComp,Float> {


    private float value;

    public FloatComp(int nominator, int denominator) {this.value = (float)nominator/denominator;}

    public FloatComp(int value) {
        this(value,65536);
    }


    @Override
    public Float getValue() {
        return value;
    }

    @Override
    public void setValue(int value) {
        this.value = (float)value/65536;
    }

    public void setValue(float value) {this.value = value;}


    @Override
    public void add(FloatComp floatComp) {
        this.value+=floatComp.getValue();
    }

    @Override
    public void substract(FloatComp floatComp) {
        this.value-=floatComp.getValue();
    }

    @Override
    public void multiply(FloatComp floatComp) {
        this.value*=floatComp.getValue();
    }

    @Override
    public void divide(FloatComp floatComp) {
        this.value/=floatComp.getValue();
    }

    @Override
    public String toString() {
        return Float.toString(value);
    }
}
