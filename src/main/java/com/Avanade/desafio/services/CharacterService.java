package com.Avanade.desafio.services;

import com.Avanade.desafio.entities.Character;
import com.Avanade.desafio.enums.CharacterName;
import com.Avanade.desafio.payloads.CharacterCreateAllRequest;
import com.Avanade.desafio.payloads.CharacterCreateRequest;
import com.Avanade.desafio.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    public Character create(CharacterCreateRequest character) {
        Optional <Character> alreadyExists = this.characterRepository.findCharacterByName(character.getName());
        if (alreadyExists.isPresent()) {
            throw  new Error("Already has a character with that name");
        }
        Character car = new Character(character);
        return this.characterRepository.save(car);

    }

    public List<Character> createAll(CharacterCreateAllRequest character) {
        List<Character> created = new ArrayList<>();
       for (int i=0; i < character.getCharacters().size(); i++) {
           Optional <Character> alreadyExists = this.characterRepository.findCharacterByName(character.getCharacters().get(i).getName());
           if (alreadyExists.isPresent()) {
               throw  new Error("Already has a character with that name");
           }
           Character car = new Character(character.getCharacters().get(i));
          created.add(this.characterRepository.save(car));
       }
        return created;

    }

    public List<Character> getAll() {
        return this.characterRepository.findAll();

    }

    public Optional<Character> getById(String id) {
        return this.characterRepository.findById(id);

    }

    public Optional<Character> getByName(CharacterName name) {
        return this.characterRepository.findCharacterByName(name);

    }

    public void delete(String id) {
       this.characterRepository.deleteById(id);
    }


    public Character update(String id, CharacterCreateRequest c) {
        Character updated = new Character(c);
        updated.setId(id);
       return  this.characterRepository.save(updated);
    }
}
