package eu.datagraphics.demo.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MathServiceImpl implements MathService {

    @Override
    public List<String> getShuffledCombinations(String initial) {

        List<String> combinations = new ArrayList<>();
        combinations.add("123");
        return combinations;
    }
}
