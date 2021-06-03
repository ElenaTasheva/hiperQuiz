package util;


import model.User;
import model.enums.Gender;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {

    public static boolean validateString(String string, int min, int max) {
        return  string.trim().length() >= min && string.trim().length() <= max;

    }

    public static boolean validateNumber(int number, int min, int max) {
        int cnt = 1;
        int tmp = number;
        while (tmp != 0) {
            tmp /= 10;
            cnt++;
        }
        if (cnt >= min && cnt <= max) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validateGender(User user, String s) {
        String upper=s.toUpperCase(Locale.ROOT);
        if (upper.equals("M")|| upper.equals("MALE")) {
            user.setGender(Gender.MALE);
            return true;
        } else if(upper.equals("F")||upper.equals("FEMALE")){
            user.setGender(Gender.FEMALE);
            return true;
        } else{
            return false;
        }
    }

    public static boolean validateEmail(String email) {
        String regex = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean validateInt(String points) {
        try {
            int result = Integer.parseInt(points);
        }
        catch (NumberFormatException e){
            return false;
        }
        return true;
    }
}
