package com.epam.jtc.calculator.model.calculatorEngine.factory;

import com.epam.jtc.calculator.model.calculatorEngine.CalculatorEngine;
import com.epam.jtc.calculator.model.calculatorEngine.DecimalLongCalculator;
import com.epam.jtc.calculator.model.calculatorEngine.HexadecimalLongCalculator;

public class EngineFactory {

    private final static String UNSUPPORTED_RADIX = "Unsupported radix: %s. ";

    private EngineFactory() {
    }

    public static CalculatorEngine getCalculationEngine(
            String inputedRadix) {
        CalculatorEngine calculationEngine;
        NumberSystems radix = NumberSystems.UNSUPPORTED;

        for (NumberSystems supportedRadix : NumberSystems.values()) {
            if (supportedRadix.getRadix().equals(inputedRadix)) {
                radix = supportedRadix;
                break;
            }
        }

        switch (radix) {
            case HEXADECIMAL:
                calculationEngine = new HexadecimalLongCalculator();
                break;
            case DECIMAL:
                calculationEngine = new DecimalLongCalculator();
                break;
            default:
                throw new IllegalArgumentException(
                        String.format(UNSUPPORTED_RADIX, inputedRadix));
        }


        return calculationEngine;
    }

}



