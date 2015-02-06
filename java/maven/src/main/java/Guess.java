import java.util.Random;
import java.util.Scanner;

/**
 * Created by zhl on 15/2/6.
 */
public class Guess {
    private int times = 6;
    private String answer;
    private GuessNumber guessNumber;
    public static void main(String[] args) {
        Guess guess = new Guess(new AnswerGenerator(new Random()), new GuessNumber());
        guess.play(new Scanner(System.in));
    }

    public Guess(AnswerGenerator answerGenerator, GuessNumber guessNumber) {
        answer = answerGenerator.generate();
        this.guessNumber = guessNumber;

        System.out.print(answer);
    }

    public String play(Scanner scanner) {
        System.out.print("Welcome!\n");

        while (true) {
            String result = playOnce(scanner);
            if (result.equals("Congratulations!")  || result.equals("Game Over")) {
                return result;
            }
        }
    }

    public String guessNumber(String input) {
        if (!isLegal(input)) {
            return "Must input 4 digits String!";
        }

        if (isRepeated(input)) {
            return "Cannot input duplicate numbers!";
        }

        if (isRight(input)) {
            return "Congratulations!";
        }

        if (isGameOver(input)) {
            return "Game Over";
        } else {
            return guessNumber.getTips(input, answer);
        }
    }

    private String playOnce(Scanner scanner) {
        System.out.print(String.format("\nPlease input your number(%d):", getTimes()));
        String result = guessNumber(scanner.next());
        System.out.print(result);
        return result;
    }

    private boolean isLegal(String input) {
        if (input.length() != 4) {
            return false;
        }

        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    private boolean isRepeated(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.indexOf(input.charAt(i)) != input.lastIndexOf(input.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean isRight(String input) {
        String result = guessNumber.getTips(input, answer);
        if (result.equals("4A0B")) {
            return true;
        } else
        {
            return false;
        }
    }

    private boolean isGameOver(String input) {
        times--;
        if (!isRight(input) && times == 0) {
            return true;
        }

        return false;
    }

    private int getTimes() {
        return times;
    }
}
