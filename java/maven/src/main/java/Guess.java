
/**
 * Created by zhl on 15/2/6.
 */
public class Guess {
    public String guessNumber(String input, AnswerGenerator answerGenerator) {
        GuessNumber guessNumber = new GuessNumber();
        return guessNumber.getTips(input, answerGenerator.generate());
    }
}
