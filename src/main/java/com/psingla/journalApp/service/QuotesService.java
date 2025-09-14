package com.psingla.journalApp.service;

import com.psingla.journalApp.response.QuotesResponse;
import com.psingla.journalApp.cache.AppCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class QuotesService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCache appCache;

    public QuotesResponse getQuote(){
        String url = "https://zenquotes.io/api/quotes/";

        QuotesResponse[] quotes = restTemplate.getForObject(url, QuotesResponse[].class);

        if(quotes == null || quotes.length == 0){
            return null;
        }

        Random random = new Random();
        int index = random.nextInt(quotes.length);

        return quotes[index];
    }
}