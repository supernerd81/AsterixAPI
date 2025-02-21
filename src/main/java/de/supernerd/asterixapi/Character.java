package de.supernerd.asterixapi;

import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("asterixcharacters")
@With
public record Character(
        @Id
        String id,
        String name,
        int age,
        String role
) {
}
