
public class ParseOperator {

    static class OperatorResult {
        String operator;
        int pos;

        OperatorResult(String operator, int pos) {
            this.operator = operator;
            this.pos = pos;
        }
    }

    static OperatorResult parseOperator(String expression, int pos) {
        pos = SkipSpaces.skipSpaces(expression, pos);

        StringBuilder operator = new StringBuilder();

        while (pos < expression.length()) {
            char ch = expression.charAt(pos);

            if (Character.isDigit(ch) || ch == '(' || ch == ')'
                    || Character.isWhitespace(ch)) {
                break;
            }

            operator.append(ch);
            pos++;
        }

        return new OperatorResult(operator.toString(), pos);
    }
}
