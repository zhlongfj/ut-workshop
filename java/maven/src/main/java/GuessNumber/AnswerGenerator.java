package GuessNumber;

import java.util.Random;

/**
 * Created by zhl on 15/2/2.
 */
public class AnswerGenerator {
    public String generateARandomDigitWithoutRepeat() {
        StringBuffer randomDigit = new StringBuffer();
        String sampling = "0123456789";
        for (int i = 0; i < 4; i++) {
            String digit = getDigitStringFromSampling(sampling);
            randomDigit.append(digit);
            sampling = sampling.replace((digit), "");
        }

        return randomDigit.toString();
    }

    private  String getDigitStringFromSampling(String sampling) {
        Random r = new Random();
        int num = r.nextInt(sampling.length());
        String digit = String.valueOf(sampling.charAt(num));
        return digit;
    }
}
