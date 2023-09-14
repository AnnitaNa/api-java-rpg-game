package com.Avanade.desafio.controllers;

import com.Avanade.desafio.Usecases.Game;
import com.Avanade.desafio.entities.Character;
import com.Avanade.desafio.enums.CharacterName;
import com.Avanade.desafio.payloads.CharacterCreateAllRequest;
import com.Avanade.desafio.payloads.CharacterCreateRequest;
import com.Avanade.desafio.payloads.GameRequest;
import com.Avanade.desafio.services.CharacterService;
import com.Avanade.desafio.services.DiceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/game")
@RequiredArgsConstructor

@Slf4j
public class GameController {

    @Autowired
    private DiceService diceService;
    @Autowired
    private Game game;


    @GetMapping(path = "/dice", produces = "application/json" )
    public Long dice() {
        return this.diceService.throwAllDices(1, 3);
    }


    @PostMapping (path = "/play", produces = "application/json" )
    public void play( @RequestBody GameRequest req) {
        this.game.play(req.getName1(), req.getName2());
    }
}
