package eu.datagraphics.demo.controller;

import eu.datagraphics.demo.dto.MasterMindDTO;
import eu.datagraphics.demo.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/math")
public class CombinationsController {

    @Autowired
    private MathService mathService;

    @PostMapping(value="/getcombinations", consumes = "application/json", produces = "application/json")
    ResponseEntity<Object> getCombinations(@Valid @RequestBody MasterMindDTO masterMind) {

        return ResponseEntity.ok(mathService.getShuffledCombinations(masterMind.getChellange()));
    }
}
