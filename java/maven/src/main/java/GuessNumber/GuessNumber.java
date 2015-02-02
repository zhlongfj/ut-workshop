package GuessNumber;

/**
 * Created by zhl on 15/2/2.
 */
public class GuessNumber {
    public String getTips(String input, String answer) {
        int countsOfCotain = 0;
        int countsOfEuqal = 0;
        for (int i = 0; i < answer.length(); i++) {
            if (input.contains(String.valueOf(answer.charAt(i)))) {
                countsOfCotain++;
                if (input.charAt(i) == answer.charAt(i)) {
                    countsOfEuqal++;
                }
            }
        }

        return getTipsFromCountsOfContainAndCountsOfEuqal(countsOfCotain, countsOfEuqal);
    }

    private String getTipsFromCountsOfContainAndCountsOfEuqal(int countsOfContain, int countsOfEqual) {
        int countsOfContainWithoutEqual = countsOfContain - countsOfEqual;
        String tips = countsOfEqual + "A" + countsOfContainWithoutEqual + "B";
        return tips;
    }
}
