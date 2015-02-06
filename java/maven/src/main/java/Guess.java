
/**
 * Created by zhl on 15/2/6.
 */
public class Guess {
    public String guessNumber(String input, AnswerGenerator answerGenerator) {
        if (input.length() != 4) {
            return "Please input 4 digits String!";
        }

        for (int i = 0; i < input.length(); i++) {
            if (input.indexOf(input.charAt(i)) != input.lastIndexOf(input.charAt(i))) {
                return "Cannot input duplicate numbers!";
            }
        }

        GuessNumber guessNumber = new GuessNumber();
        String result = guessNumber.getTips(input, answerGenerator.generate());
        if (result.equals("4A0B")) {
            result = "Congratulations!";
        }

        return result;
    }
}
