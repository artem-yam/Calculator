package com.epam.jtc.calculator;

import com.epam.jtc.calculator.model.OperationData;
import com.epam.jtc.calculator.model.calculatorEngine.CalculatorEngine;
import com.epam.jtc.calculator.model.calculatorEngine.factory.EngineFactory;
import com.epam.jtc.calculator.utils.ExpressionReformer;
import com.epam.jtc.calculator.utils.input.ConsoleInfoInput;
import com.epam.jtc.calculator.utils.input.InfoInput;
import com.epam.jtc.calculator.utils.output.ConsoleInfoOutput;
import com.epam.jtc.calculator.utils.output.InfoOutput;

import java.util.List;

public class Calculator {

    private InfoOutput infoOutput = new ConsoleInfoOutput();
    private InfoInput infoInput = new ConsoleInfoInput();

    private CalculatorEngine calculationEngine = null;

    private ExpressionReformer expressionReformer = new ExpressionReformer();

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        calculator.startCalculations();

    }

    public void startCalculations() {

        do {
            infoOutput.showRadixRequest();

            try {
                calculationEngine = EngineFactory.getCalculationEngine(
                        infoInput.getNextLine());

            } catch (IllegalArgumentException illegalArgumentException) {
                infoOutput.showError(illegalArgumentException);
            }

        } while (calculationEngine == null);

        infoOutput.showExpressionRequest();

        do {

            String expression = infoInput.getNextLine();

            if (!expression.isEmpty()) {
                try {
                    List<OperationData> operations =
                            expressionReformer.formOperationsList(expression,
                                    calculationEngine);

                    infoOutput.showOperationsResults(operations);

                } catch (IllegalArgumentException illegalArgumentException) {
                    infoOutput.showError(illegalArgumentException);
                }

            } else {
                infoOutput.showEmptyInputWarning();
            }

            infoOutput.showExpressionRequest();

        } while (infoInput.canRead());

        infoInput.closeResource();
    }

}
