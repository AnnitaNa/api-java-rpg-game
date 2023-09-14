package com.Avanade.desafio.payloads;

import lombok.Data;

import java.util.List;

@Data

public class CharacterCreateAllRequest {
  private List<CharacterCreateRequest> characters;
}
