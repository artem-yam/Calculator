package com.epam.jtc.calculator;

import com.epam.jtc.calculator.model.calculatorOperations.OperationData;
import com.epam.jtc.calculator.model.calculatorEngine.CalculatorEngine;
import com.epam.jtc.calculator.model.calculatorEngine.factory.EngineFactory;
import com.epam.jtc.calculator.model.calculatorOperations.ExpressionReformer;
import com.epam.jtc.calculator.model.calculatorOperations.OperationExecutor;
import com.epam.jtc.calculator.utils.input.ConsoleInfoInput;
import com.epam.jtc.calculator.utils.input.InfoInput;
import com.epam.jtc.calculator.utils.output.ConsoleInfoOutput;
import com.epam.jtc.calculator.utils.output.InfoOutput;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private InfoOutput infoOutput = new ConsoleInfoOutput();
    private InfoInput infoInput = new ConsoleInfoInput();

    private CalculatorEngine calculationEngine = null;

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

                    infoOutput.showOperationsResults(
                            getExpressionResults(expression));

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


    private List<String> getExpressionResults(String expression) {

        List<String> results = new ArrayList<>();
        OperationExecutor executor = new OperationExecutor(calculationEngine);

        List<OperationData> operations =
                ExpressionReformer.formOperationsList(expression,
                        executor);

        for (OperationData operation : operations) {
            results.add(executor.calculate(operation));
        }

        return results;
    }
}
