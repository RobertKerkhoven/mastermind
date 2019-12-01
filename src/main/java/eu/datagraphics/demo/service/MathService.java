package eu.datagraphics.demo.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MathService {

    List<String> getShuffledCombinations(String initial);
}
