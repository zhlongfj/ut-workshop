
/**
 * Created by zhl on 15/2/6.
 */
public class Guess {
    public String guessNumber(String input, AnswerGenerator answerGenerator) {
        GuessNumber guessNumber = new GuessNumber();
        String result = guessNumber.getTips(input, answerGenerator.generate());
        if (result.equals("4A0B")) {
            result = "Congratulations!";
        }

        return result;
    }
}
