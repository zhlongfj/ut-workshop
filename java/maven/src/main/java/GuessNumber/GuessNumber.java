package GuessNumber;

/**
 * Created by zhl on 15/2/2.
 */
public class GuessNumber {
    public String getTips(String input, String answer) {
        if (input.equals(answer)) {
            return "4A0B";
        } else {
            return null;
        }
    }
}
