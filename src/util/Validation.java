package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static boolean testCode(String code) {
        String regex = "^(HR)\\d{5}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(code);
        return matcher.matches();
    }
}
