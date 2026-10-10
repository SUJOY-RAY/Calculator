
public class ParseNumber {

    static class NumberResult {
        int number;
        int pos;

        NumberResult(int number, int pos) {
            this.number = number;
            this.pos = pos;
        }
    }

    static NumberResult parseNumber(String expression, int pos) {
        pos = SkipSpaces.skipSpaces(expression, pos);

        if (pos < expression.length() && expression.charAt(pos) == '(') {
            pos++;

            NumberResult result = Evaluator.evaluator(expression, pos);
            pos = SkipSpaces.skipSpaces(expression, result.pos);

            if (pos >= expression.length() || expression.charAt(pos) != ')') {
                throw new IllegalArgumentException(
                    "Missing closing parenthesis at position " + pos
                );
            }

            return new NumberResult(result.number, pos + 1);
        }

        if (pos >= expression.length()
                || !Character.isDigit(expression.charAt(pos))) {
            throw new IllegalArgumentException(
                "Expected a number at position " + pos
            );
        }

        int number = 0;

        while (pos < expression.length()
                && Character.isDigit(expression.charAt(pos))) {
            number = number * 10 + expression.charAt(pos) - '0';
            pos++;
        }

        return new NumberResult(number, pos);
    }
}
