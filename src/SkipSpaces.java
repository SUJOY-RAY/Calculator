
public class SkipSpaces {

    static int skipSpaces(String expression, int pos) {
        while (pos < expression.length()
                && Character.isWhitespace(expression.charAt(pos))) {
            pos++;
        }

        return pos;
    }
}
