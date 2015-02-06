import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by zhl on 15/2/2.
 */
public class AnswerGenerator {
    private Random random;
    private List<String> historyGeneratedStrings;
    public AnswerGenerator(Random random) {
        this.random = random;
        historyGeneratedStrings = new ArrayList<String>();
    }

    public String generate() {
        String result = generateOnce();
        while (historyGeneratedStrings.contains(result)) {
            result = generateOnce();
        }

        if (historyGeneratedStrings.size() == 2) {
            historyGeneratedStrings.remove(0);
        }

        historyGeneratedStrings.add(result);

        return result;
    }

    public String generateOnce() {
        StringBuffer result = new StringBuffer();

        while (result.length() < 4) {
            String digit = String.valueOf(random.nextInt(10));
            if (result.indexOf(digit) == -1) {
                result.append(digit);
            }
        }

        return result.toString();
    }

}

