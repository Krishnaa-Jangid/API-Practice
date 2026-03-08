package com.coco.app.controller;

import com.coco.app.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    public Map<Long,JournalEntry> journalEntries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntries.values());

    }

    @PostMapping
    public void createEntry(@RequestBody JournalEntry myEntry){
        journalEntries.put(myEntry.getId() , myEntry);
    }

    @GetMapping("/id/{myId}")
    public JournalEntry findEntry(@PathVariable Long myId){
        return journalEntries.get(myId);
    }

    @DeleteMapping("/id/{myId}")
    public JournalEntry deleteEntry(@PathVariable Long myId){
        return journalEntries.remove(myId);
    }

    @PutMapping("/id/{myId}")
    public JournalEntry updateEntry(@PathVariable Long myId , @RequestBody JournalEntry myEntry){
        return journalEntries.put(myId,myEntry);
    }
}
