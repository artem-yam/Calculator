package com.epam.jtc.calculator.model;

import com.epam.jtc.calculator.model.calculatorEngine.CalculatorEngine;
import com.epam.jtc.calculator.model.calculatorEngine.DecimalLongCalculator;
import com.epam.jtc.calculator.model.calculatorEngine.HexadecimalLongCalculator;

public class CalculatorConfigurator {

    private CalculatorEngine calculationEngine = null;

    public CalculatorEngine getCalculationEngine() {
        return calculationEngine;
    }

    public void selectCalculationEngine(String inputedRadix) {
        SupportedNumberSystemEnum radix = null;

        for (SupportedNumberSystemEnum supportedRadix :
                SupportedNumberSystemEnum
                .values()) {
            if (inputedRadix.equals(supportedRadix.getRadix())) {
                radix = supportedRadix;
                break;
            }
        }

        if (radix == null) {
            throw new IllegalArgumentException(inputedRadix);
        } else {
            switch (radix) {
                case HEXADECIMAL:
                    calculationEngine = new HexadecimalLongCalculator();
                    break;
                case DECIMAL:
                    calculationEngine = new DecimalLongCalculator();
                    break;
            }
        }

    }


}
