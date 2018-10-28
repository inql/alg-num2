package ug.gauss.datatypes;

public class FloatComp implements MatrixCompatible<FloatComp,Float> {


    private float value;

    public FloatComp(int nominator, int denominator) {this.value = (float)nominator/denominator;}

    public FloatComp(int value) {
        this(value,65536);
    }

    public FloatComp(){

    }

    public FloatComp clonexD(){
        FloatComp  cloned = new FloatComp();
        cloned.setValue(this.getValue());
        return cloned;
    }


    @Override
    public Float getValue() {
        return value;
    }

    @Override
    public FloatComp setValue(int value) {
        this.value = (float)value/65536;
        return this;
    }

    public void setValue(float value) {this.value = value;}


    @Override
    public FloatComp add(FloatComp floatComp) {
        this.value+=floatComp.getValue();
        return this;
    }

    @Override
    public FloatComp substract(FloatComp floatComp) {
        this.value-=floatComp.getValue();
        return this;
    }

    @Override
    public FloatComp multiply(FloatComp floatComp) {
        this.value*=floatComp.getValue();
        return this;
    }

    @Override
    public FloatComp divide(FloatComp floatComp) {
        this.value/=floatComp.getValue();
        return this;
    }

    @Override
    public String toString() {
        return Float.toString(value);
    }
}
