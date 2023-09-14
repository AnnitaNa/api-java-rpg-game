package com.Avanade.desafio.entities;

import com.Avanade.desafio.enums.CharacterName;
import com.Avanade.desafio.enums.CharacterType;
import com.Avanade.desafio.payloads.CharacterCreateRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Entity
@Slf4j
@Table(name = "character")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;


    private CharacterName name;

    private Long life;
    private Long attack;
    private Long defense;
    private Long agility;

    private CharacterType characterType;

    private Long diceNr;
    private Long diceFaces;

    private Long remainingLife;

public Character(CharacterCreateRequest c) {
    this.name = c.getName();
    this.life = c.getLife();
    this.attack = c.getAttack();
    this.defense = c.getDefense();
    this.agility = c.getAgility();
    this.characterType = c.getCharacterType();
    this.diceNr = c.getDiceNr();
    this.diceFaces = c.getDiceFaces();
    this.remainingLife = c.getLife();
}

public Character() {
    this.setRemainingLife(this.getLife());
}

public void ReceivesDamage(long i) {
    long remainingLife = this.getRemainingLife() -i;
    if (remainingLife <0) {
        remainingLife = 0;
    }
    this.setRemainingLife(remainingLife);
    log.info("{} received {} damage! Remaining life is: {} ", this.name, i, remainingLife);
}

public void Heal() {
    this.setRemainingLife(this.getLife());
}

public boolean isPlayerAlive() {
    if (this.getRemainingLife() > 0) {
        return true;
    } else {
        return false;
    }
}



}
