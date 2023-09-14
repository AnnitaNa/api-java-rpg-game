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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/character")
@RequiredArgsConstructor

@Slf4j
public class CharacterController {

    @Autowired
    private CharacterService characterService;


    @PostMapping(path = "", produces = "application/json" )
    public Character create(@RequestBody CharacterCreateRequest req) {
       return this.characterService.create(req);
    }

    @PostMapping(path = "/all", produces = "application/json" )
    public List<Character> create(@RequestBody CharacterCreateAllRequest req) {
        return this.characterService.createAll(req);
    }

    @GetMapping(path = "", produces = "application/json" )
    public List<Character>  getAll() {
        return this.characterService.getAll();
    }

    @GetMapping(path = "/{id}", produces = "application/json" )
    public Optional<Character> getById(@PathVariable("id") String id) {
        return this.characterService.getById(id);
    }

    @GetMapping(path = "/name/{name}", produces = "application/json" )
    public Optional<Character> getByName(@PathVariable("name") CharacterName name) {
        return this.characterService.getByName(name);
    }

    @DeleteMapping(path = "/{id}", produces = "application/json" )
    public void delete(@PathVariable("id") String id) {
        this.characterService.delete(id);
    }

    @PutMapping(path = "/{id}", produces = "application/json" )
    public Character update(@PathVariable("id") String id, @RequestBody CharacterCreateRequest req) {
      return this.characterService.update(id, req);
    }

}
