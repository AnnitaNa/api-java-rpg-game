package com.Avanade.desafio.payloads;

import com.Avanade.desafio.enums.CharacterName;
import com.Avanade.desafio.enums.CharacterType;
import lombok.Data;

import java.util.List;

@Data

public class CharacterCreateAllRequest {
  private List<CharacterCreateRequest> characters;
}
