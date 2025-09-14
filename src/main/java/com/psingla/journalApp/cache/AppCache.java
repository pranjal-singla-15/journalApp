package com.psingla.journalApp.cache;

import com.psingla.journalApp.entity.ConfigJournalAppEntity;
import com.psingla.journalApp.repository.ConfigJournalAppRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppCache {

    @Autowired
    private ConfigJournalAppRepository configJournalAppRepository;

    public Map<String, String> APP_CACHE = new HashMap<>();


    @PostConstruct
    public void init(){
        List< ConfigJournalAppEntity> all = configJournalAppRepository.findAll();
        for(ConfigJournalAppEntity entity : all){
            APP_CACHE.put(entity.getKey(),entity.getValue());
        }
    }
}
