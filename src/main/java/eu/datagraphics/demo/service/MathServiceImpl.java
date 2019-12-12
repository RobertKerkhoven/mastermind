package eu.datagraphics.demo.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MathServiceImpl implements MathService {

    public static String rgbw = "RGBW";

    @Override
    public List<String> getShuffledCombinations(String initial) {

        List<String> combinations = new ArrayList<>();
        combinations.add("123");
        return combinations;
    }

    @Override
    public Integer getGuessScore(String guess) {
        int score = 0;

        for (int i=0;i<4;i++){
            if (guess.charAt(i) == rgbw.charAt(i)){
                score++;
            }
        }

        return score;
    }
}
