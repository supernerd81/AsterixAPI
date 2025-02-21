package de.supernerd.asterixapi;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/asterix")
public class AsterixController {

    private final AsterixService asterixService;

    @GetMapping("/characters")
    public List<ResponseCharacterDto> getCharacters() {

        return asterixService.getAllCharacters().stream()
                .map(character -> new ResponseCharacterDto(character.name(), character.age(), character.role()))
                .toList();
    }

    @PostMapping("/character")
    public ResponseCharacterDto addCharacter(@RequestBody ResponseCharacterDto character) {
        Character savedCharacter = asterixService.save(new Character(null, character.name(), character.age(), character.role()));
        return new ResponseCharacterDto(savedCharacter.id(), savedCharacter.age(), savedCharacter.role());
    }
}
