package eu.datagraphics.demo.controller;

import eu.datagraphics.demo.dto.MasterMindDTO;
import eu.datagraphics.demo.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/mastermind")
public class CombinationsController {

    @Autowired
    private MathService mathService;

    @PostMapping(value="/getcombinations", consumes = "application/json", produces = "application/json")
    ResponseEntity<Object> postCombinations(@Valid @RequestBody MasterMindDTO masterMind) {

        return ResponseEntity.ok(mathService.getShuffledCombinations(masterMind.getChellange()));
    }

    @PostMapping(value="/guess", consumes = "application/json", produces = "application/json")
    ResponseEntity<Integer> postGuess(@Valid @RequestBody MasterMindDTO masterMind) {

        return ResponseEntity.ok(mathService.getGuessScore(masterMind.getChellange()));
    }

    @GetMapping(value="/guess/{combination}", produces = "application/json")
    ResponseEntity<Integer> getGuess(@PathVariable(required = true) String combination) {

        return ResponseEntity.ok(mathService.getGuessScore(combination));
    }

}
