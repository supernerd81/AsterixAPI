package de.supernerd.asterixapi;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AsterixService {

    private final AsterixCharacterRepository asterixCharacterRepository;

    public List<Character> getAllCharacters() {

        return asterixCharacterRepository.findAll();

    }

    public Character save(@RequestBody Character character) {

        String uuid = UUID.randomUUID().toString();
        Character characterToSave = character.withId(uuid);

        return asterixCharacterRepository.save(characterToSave);
    }
}
