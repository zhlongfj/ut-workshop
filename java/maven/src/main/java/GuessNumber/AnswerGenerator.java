package GuessNumber;

import java.util.Random;

/**
 * Created by zhl on 15/2/2.
 */
public class AnswerGenerator {
    private final String sampling = "0123456789";
    public String generateARandomDigitWithoutRepeat() {
        return getDigitFromSamplingWithoutChecked(samplingWithoutChecked());
    }

    private String samplingWithoutChecked() {
        String samplingWithoutChecked = sampling;
        for (int i = 0; i < 4; i++) {
            String checked = getDigitStringFromSampling(samplingWithoutChecked);
            samplingWithoutChecked = samplingWithoutChecked.replace(checked, "");
        }
        return samplingWithoutChecked;
    }

    private String getDigitFromSamplingWithoutChecked(String samplingWithoutChecked) {
        String digit = new String();
        for (int i = 0; i < sampling.length(); i++) {
            if (samplingWithoutChecked.contains(String.valueOf(sampling.charAt(i)))) {
                digit += sampling.charAt(i);
            }
        }
        return digit;
    }

    private  String getDigitStringFromSampling(String sampling) {
        Random r = new Random();
        int num = r.nextInt(sampling.length());
        String digit = String.valueOf(sampling.charAt(num));
        return digit;
    }
}
