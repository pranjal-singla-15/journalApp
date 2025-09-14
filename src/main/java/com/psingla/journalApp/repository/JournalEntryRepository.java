package com.psingla.journalApp.repository;

import com.psingla.journalApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RestController;

public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId>{

}