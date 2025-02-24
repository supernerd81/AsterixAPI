package de.supernerd.asterixapi;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AsterixService {

    private final AsterixCharacterRepository asterixCharacterRepository;
    private final IdService idService;

    public List<Character> getAllCharacters() {

        return asterixCharacterRepository.findAll();

    }

    public Character save(@RequestBody Character character) {


        String uuid = idService.randomId();
        Character characterToSave = character.withId(uuid);


        return asterixCharacterRepository.save(characterToSave);
    }
}
