
public class MainConvertStringToCamelCase {
    public static void main(String[] args) {
        System.out.println(toCamelCaseByIteration("   THIS     STrING SHOULD 12124 _ BE IN  + CAMEL CASE! !?! "));
        System.out.println(toCamelCaseByIteration(" MY   NAme is           242 FaBIANO   !!! "));
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    private static String toCamelCaseByIteration(String string) {
        StringBuilder sb = new StringBuilder();
        boolean shouldBeUpper = false;
        boolean firstCharAppended = false;
        for (char c : string.toCharArray()) {
            if (isChar(c)) {
                if (shouldBeUpper) {
                    sb.append(toUpper(c));
                    shouldBeUpper = false;
                } else {
                    sb.append(toLower(c));
                }
                firstCharAppended = true;
            } else if (firstCharAppended) {
                shouldBeUpper = true;
            }
        }
        return sb.toString();
    }
    
    public static boolean isChar(char c) {
        return (c >= 65 && c <= 90 || c >= 97 && c <= 122); 
    }
    
    public static char toUpper(char c) {
        if (c >= 97) {
            c -= 32;
        }
        return c;
    }
    
    public static char toLower(char c) {
        if (c <= 90) {
            c += 32;
        }
        return c;
    }
}
