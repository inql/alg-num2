package ug.gauss.operations;

import ug.gauss.datatypes.Fract;
import ug.gauss.datatypes.FractionComp;

import java.math.BigInteger;

public class FractionOperation implements DataOperation<FractionComp> {
    @Override
    public FractionComp add(FractionComp element1, FractionComp element2) {
        FractionComp result = new FractionComp();
        Fract fract = new Fract();
        BigInteger nww = MathOperations.calculateNww(element1.getValue().denominator,element2.getValue().denominator);
        fract.nominator = element1.getValue().nominator.multiply(nww.divide(element1.getValue().denominator));
        fract.denominator = nww;
        fract.nominator = fract.nominator.add(element2.getValue().nominator.multiply(nww.divide(element2.getValue().denominator)));
        result.setValue(fract);
        return result;
    }

    @Override
    public FractionComp subtract(FractionComp element1, FractionComp element2) {
        FractionComp result = new FractionComp();
        Fract fract = new Fract();
        BigInteger nww = MathOperations.calculateNww(element1.getValue().denominator,element2.getValue().denominator);
        fract.nominator = element1.getValue().nominator.multiply(nww.divide(element1.getValue().denominator));
        fract.denominator = nww;
        fract.nominator = fract.nominator.subtract(element2.getValue().nominator.multiply(nww.divide(element2.getValue().denominator)));
        result.setValue(fract);
        return result;
    }

    @Override
    public FractionComp multiply(FractionComp element1, FractionComp element2) {
        FractionComp result = new FractionComp();
        Fract fract = new Fract();
        fract.nominator = element1.getValue().nominator.multiply(element2.getValue().nominator);
        fract.denominator = element1.getValue().denominator.multiply(element2.getValue().denominator);
        result.setValue(fract);
        return result;
    }

    @Override
    public FractionComp divide(FractionComp element1, FractionComp element2) {
        FractionComp result = new FractionComp();
        Fract fract = new Fract();
        BigInteger pom = element2.getValue().nominator;
        fract.nominator = element2.getValue().denominator;
        fract.denominator = pom;
        result.setValue(fract);
        return this.multiply(element1,result);
    }
}
