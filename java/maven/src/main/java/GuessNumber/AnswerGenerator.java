package GuessNumber;

import java.util.Random;

/**
 * Created by zhl on 15/2/2.
 */
public class AnswerGenerator {
    public String generateARandomDigitWithoutRepeat() {
        StringBuffer randomDigit = new StringBuffer();
        String str = "0123456789";
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            int num = r.nextInt(str.length());
            randomDigit.append(str.charAt(num));
            str = str.replace((str.charAt(num)+""), "");
        }

        return randomDigit.toString();
    }
}
