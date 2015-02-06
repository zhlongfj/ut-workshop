import java.util.Random;
import java.util.Scanner;

/**
 * Created by zhl on 15/2/6.
 */
public class Guess {
    private int times = 6;

    public static void main(String[] args) {
        Guess guess = new Guess();
        System.out.print("Welcome!\n");
        String result = null;
        while (result != "Game Over" && guess.getTimes() > 0) {

            String tips = String.format("\n1Please input your number(%d):", guess.getTimes());
            System.out.print(tips);
            Scanner sc = new Scanner( System.in );
            result = guess.guessNumber(sc.next(), new AnswerGenerator(new Random()));
            System.out.print(result);
        }
    }
     
    public String guessNumber(String input, AnswerGenerator answerGenerator) {
        if (input.length() != 4) {
            return "Must input 4 digits String!";
        }

        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return "Must input 4 digits String!";
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

        times--;
        if (!result.equals("Congratulations") && times == 0) {
            result = "Game Over";
        }

        return result;
    }

    public int getTimes() {
        return times;
    }
}
