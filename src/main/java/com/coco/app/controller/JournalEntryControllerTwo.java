package com.coco.app.controller;

import com.coco.app.entity.JournalEntry;
import com.coco.app.services.JournalEntryServices;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerTwo {

    @Autowired
    private JournalEntryServices journalEntryServices;

    @GetMapping
    public List<JournalEntry> getAll(){
        return journalEntryServices.getAll();
    }

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry){
        myEntry.setDate(LocalDateTime.now());
        return journalEntryServices.saveEntry(myEntry);
    }

    @GetMapping("/id/{myId}")
    public JournalEntry findEntry(@PathVariable ObjectId myId){

        return journalEntryServices.findById(myId).orElse(null);
    }

    @DeleteMapping("/id/{myId}")
    public boolean deleteEntry(@PathVariable ObjectId myId){
        journalEntryServices.deleteById(myId);
        return true;
    }

    @PutMapping("/id/{myId}")
    public JournalEntry updateEntry(@PathVariable ObjectId myId , @RequestBody JournalEntry myEntry){
        return journalEntryServices.updateById(myId,myEntry);
    }
}
