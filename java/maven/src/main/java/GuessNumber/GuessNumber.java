package GuessNumber;

/**
 * Created by zhl on 15/2/2.
 */
public class GuessNumber {
    public String getTips(String input, String answer) {
        int containCounts = 0;
        int equalCounts = 0;
        if (input.equals(answer)) {
            return "4A0B";
        } else {
            for (int i = 0; i < answer.length(); i++) {
                if (input.contains(String.valueOf(answer.charAt(i)))) {
                    containCounts ++;
                    if (input.charAt(i) == answer.charAt(i)) {
                        equalCounts ++;
                    }
                }
            }

            String tips = equalCounts + "A" + (containCounts = equalCounts) + "B";
            return tips;
        }
    }
}
