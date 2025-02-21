package de.supernerd.asterixapi;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsterixCharacterRepository extends MongoRepository<Character, String> {
}
