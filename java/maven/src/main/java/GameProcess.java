import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by zhl on 15/2/8.
 */
public class GameProcess {
    private PrintStream out;
    private final BufferedReader read;
    private final AnswerGenerator answerGenerator;
    private final GuessNumber guessNumber;
    private String answer;
    private int roundCount;


    public GameProcess(PrintStream out, BufferedReader read, AnswerGenerator answerGenerator, GuessNumber guessNumber) {

        this.out = out;
        this.read = read;
        this.answerGenerator = answerGenerator;
        this.guessNumber = guessNumber;
    }

    public void start() throws IOException {
        initForStart();
        printBegin();
        printEnd(play());
    }

    private void initForStart() {
        roundCount = 6;
        answer = answerGenerator.generate();
    }

    private void printBegin() {
        out.println("Welcome!");
    }

    private String play() throws IOException {
        String tips = "";
        while (roundCount > 0 && !guessNumber.isTipsAllRight(tips)) {
            out.println("Please input your number(" + roundCount + "): ");
            String input = read.readLine();
            if (!isLegal(input)) {
                continue;
            }
            tips = playOnce(input);
        }
        return  tips;
    }

    private String playOnce(String input) {
        String tips = guessNumber.getTips(input, answer);

        if (!guessNumber.isTipsAllRight(tips)) {
            out.println(tips);
            roundCount--;
        }
        return tips;
    }

    private boolean isLegal(String input) {
        if (input.length() != 4 || !isDigitString(input)) {
            out.println("Must input 4 digits String!");
            return false;
        }

        if (isDuplicated(input)) {
            out.println("Cannot input duplicate numbers!");
            return false;
        }

        return true;
    }

    private boolean isDuplicated(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.indexOf(input.charAt(i)) != input.lastIndexOf(input.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean isDigitString(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private void printEnd(String tips) {
        if (guessNumber.isTipsAllRight(tips)) {
            out.println("Congratulations!");
        } else {
            out.println("Game Over");
        }
    }
}
