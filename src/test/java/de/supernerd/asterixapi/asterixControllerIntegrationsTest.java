package de.supernerd.asterixapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class asterixControllerIntegrationsTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    AsterixCharacterRepository asterixCharacterRepository;

    @Test
    @DirtiesContext
    public void getCharacters() throws Exception {
        //GIVEN
        Character c1 = new Character("1", "Asterix", 66, "Chef");
        asterixCharacterRepository.save(c1);

        //WHEN
        mockMvc.perform(get("/asterix/characters"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                      [
                          {
                              "name": "Asterix",
                              "age": 66,
                              "role": "Chef"
                          }
                      ]
                """));

        //THEN
    }
}
