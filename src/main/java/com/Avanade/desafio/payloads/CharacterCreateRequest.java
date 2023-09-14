package com.Avanade.desafio.payloads;

import com.Avanade.desafio.enums.CharacterName;
import com.Avanade.desafio.enums.CharacterType;
import lombok.Data;

@Data

public class CharacterCreateRequest {
    private CharacterName name;

    private Long life;
    private Long attack;
    private Long defense;
    private Long agility;

    private CharacterType characterType;

    private Long diceNr;
    private Long diceFaces;
}
