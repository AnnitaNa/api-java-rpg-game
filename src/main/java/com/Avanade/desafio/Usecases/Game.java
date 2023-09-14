package com.Avanade.desafio.Usecases;

import com.Avanade.desafio.entities.Character;
import com.Avanade.desafio.enums.CharacterName;
import com.Avanade.desafio.services.CharacterService;
import com.Avanade.desafio.services.DiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@Slf4j
public class Game {

    @Autowired
    private DiceService diceService;

    @Autowired
    private CharacterService characterService;

    public Character characterStatus(CharacterName name)  {
        Optional<Character> character = this.characterService.getByName(name);
        if (!character.isPresent()) {
        }
        log.info("Character: {}", character.get());
        return character.get();
    }
    public long attack(Character character) {
        Long diceNumber = this.diceService.throwDice(12);
        Long totalAttack  = diceNumber + character.getAttack() + character.getAgility();
        log.info("ATTACK: {} rolls {}, total attack is {}", character.getName(), diceNumber, totalAttack);
        return  totalAttack;
    }

    public long Defense(Character character) {
        Long diceNumber = this.diceService.throwDice(12);
        Long totalDefense = diceNumber + character.getDefense() + character.getAgility();
        log.info("DEFENSE: {} rolls {}, total defense is {}", character.getName(), diceNumber, totalDefense);
        return  totalDefense;
    }


    public void play(CharacterName nameA, CharacterName nameB) {

        Character a = this.characterStatus(nameA);
        Character b = this.characterStatus(nameB);

        log.info("\n ");
        log.info("------------------- GAME STARTS --------------------");

        Character attacker, defender, odd, even;

        Long diceNumberA = this.diceService.throwDice(20);
        Long diceNumberB = this.diceService.throwDice(20);


        int count = 0;

        if (diceNumberA > diceNumberB) {
            even = a;
            odd = b;
        } else {
            even = b;
            odd = a;
        }
        Boolean isAlive;

        log.info("{} rolled {}, {} rolled {}, {} starts!", a.getName(), diceNumberA, b.getName(), diceNumberB, even.getName());

        do {

            log.info("\n ");
            log.info("--- ROUND {}: ", count+1);
            if (count%2 == 0) {
                attacker = even;
                defender = odd;
            } else {
                attacker = odd;
                defender = even;
            }

            isAlive = this.playersTurn(attacker, defender);
            count = count +1;
        } while(isAlive);

        log.info("------------------- GAME ENDS --------------------");
        log.info("winner: {}", attacker.getName());
        log.info("\n ");

    }


    public Boolean playersTurn(Character attacker, Character defender) {
        long totalAttack = this.attack(attacker);
        long totalDefense = this.Defense(defender);

        if (totalAttack > totalDefense) {
            Long damage = this.calculateDamage(attacker);
            defender.ReceivesDamage(damage);
        } else {
            log.info("{} received no damage!", defender.getName());
        }


        return defender.isPlayerAlive();
    }

    public Long calculateDamage (Character attacker) {
        Long dice = this.diceService.throwAllDices(attacker.getDiceNr(), attacker.getDiceFaces());
        return dice + attacker.getAttack();
    }

}
