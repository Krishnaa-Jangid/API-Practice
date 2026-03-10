package com.coco.app.repository;

import com.coco.app.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.io.ObjectInput;

@Component
public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId> {

}
