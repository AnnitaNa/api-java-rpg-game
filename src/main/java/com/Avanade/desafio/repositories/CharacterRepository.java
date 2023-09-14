package com.Avanade.desafio.repositories;

import com.Avanade.desafio.entities.Character;
import com.Avanade.desafio.enums.CharacterName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CharacterRepository extends JpaRepository<Character, String> {
    Optional<Character> findCharacterByName(CharacterName name);
}
