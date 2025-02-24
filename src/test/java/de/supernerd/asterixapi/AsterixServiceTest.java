package de.supernerd.asterixapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

public class AsterixServiceTest {

    IdService mockIdService = mock(IdService.class);
    AsterixCharacterRepository mockAsterixCharacterRepository = mock(AsterixCharacterRepository.class);
    AsterixService asterixService = new AsterixService(mockAsterixCharacterRepository, mockIdService);

    @Test
    void getAllCharactersTest() {
        // GIVEN
        Character character1 = new Character("1", "Asterix", 5, "");
        Character character2 = new Character("2", "Obelix", 3, "");
        when(mockAsterixCharacterRepository.findAll()).thenReturn(List.of(character1, character2));

        // WHEN
        List<Character> actual = asterixService.getAllCharacters();


        // THEN
        verify(mockAsterixCharacterRepository).findAll();
        List<Character> expected = List.of(character1, character2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void saveCharacterTest() {
        // GIVEN
        Character character1 = new Character("17", "Asterix", 5, "");
        when(mockIdService.randomId()).thenReturn("17");
        when(mockAsterixCharacterRepository.save(character1)).thenReturn(character1);

        // WHEN
        Character actual = asterixService.save(character1);

        //THEN
        verify(mockAsterixCharacterRepository).save(character1);
        Character expected = new Character("17", "Asterix", 5, "");
        Assertions.assertEquals(expected, actual);
    }

}
