package eu.datagraphics.demo.service;

import eu.datagraphics.demo.model.Guess;
import eu.datagraphics.demo.repository.GuessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasterMindService {

    @Autowired
    private GuessRepository guessRepository;

    public List<Guess> list() {
        return guessRepository.findAll();
    }

    public Guess saveGuess(String value){
        Guess g = new Guess();
        g.setChellange(value);
        guessRepository.save(g);
        return g;
    }
}
