package com.epam.jtc.calculator.model;

import com.epam.jtc.calculator.model.calculatorEngine.CalculatorEngine;
import com.epam.jtc.calculator.model.calculatorEngine.DecimalLongCalculator;
import com.epam.jtc.calculator.model.calculatorEngine.HexadecimalLongCalculator;

public class CalculatorConfigurator {

    private final static String UNSUPPORTED_RADIX = "Unsupported radix: %s. ";

    private CalculatorEngine calculationEngine = null;

    public CalculatorEngine getCalculationEngine() {
        return calculationEngine;
    }

    public void selectCalculationEngine(String inputedRadix) {
        NumberSystems radix = NumberSystems.UNSUPPORTED;

        for (NumberSystems supportedRadix :
                NumberSystems
                        .values()) {
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
    }

}



