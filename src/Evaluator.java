
public class Evaluator {

    static ParseNumber.NumberResult evaluator(String expression, int pos) {
        Calculator calculator = new Calculator();

        ParseNumber.NumberResult parsed =
                ParseNumber.parseNumber(expression, pos);

        int result = parsed.number;
        pos = parsed.pos;

        while (pos < expression.length()) {
            pos = SkipSpaces.skipSpaces(expression, pos);

            if (pos >= expression.length() || expression.charAt(pos) == ')') {
                break;
            }

            ParseOperator.OperatorResult operatorResult =
                    ParseOperator.parseOperator(expression, pos);

            String operator = operatorResult.operator;
            pos = operatorResult.pos;

            if (operator.isEmpty()) {
                throw new IllegalArgumentException(
                        "Expected an operator at position " + pos);
            }

            ParseNumber.NumberResult numberResult =
                    ParseNumber.parseNumber(expression, pos);

            int number = numberResult.number;
            pos = numberResult.pos;

            result = calculator.calculate(result, number, operator);
        }

        return new ParseNumber.NumberResult(result, pos);
    }
}
