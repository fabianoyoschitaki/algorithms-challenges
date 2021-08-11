
public class MainConvertStringToCamelCase {
    public static void main(String[] args) {
        System.out.println(toCamelCaseByIteration("   THIS a a a  STrING SHOULD  _ BE IN  + CAMEL CASE! !?! "));
    }

    private static String toCamelCaseByIteration(String string) {
        StringBuilder sb = new StringBuilder();
        boolean shouldBeUpper = false;
        boolean firstCharAppended = false;
        for (char c : string.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                if (shouldBeUpper) {
                    sb.append(Character.toUpperCase(c));
                    shouldBeUpper = false;
                } else {
                    sb.append(Character.toLowerCase(c));
                }
                firstCharAppended = true;
            } else {
                if (firstCharAppended)
                    shouldBeUpper = true;
            }
        }
        return sb.toString();
    }
}
