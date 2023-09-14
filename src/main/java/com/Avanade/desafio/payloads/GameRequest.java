package com.Avanade.desafio.payloads;

import com.Avanade.desafio.enums.CharacterName;
import lombok.Data;

@Data

public class GameRequest {
    private CharacterName name1;
    private CharacterName name2;

}
