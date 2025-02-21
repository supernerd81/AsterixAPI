package de.supernerd.asterixapi;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AsterixCharacterRepository extends MongoRepository<Character, String> {
}
