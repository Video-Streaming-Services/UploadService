package com.videostreaming.uploadservice.service;


import com.videostreaming.uploadservice.Auth.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class AccountService {
    private final WebClient webClient;

    @Value("${authentication}")
    private String authenticationUrl;
    @Value("${authentication.port}")
    private String authenticationPort;

    @Autowired
    public AccountService(WebClient.Builder webClient) {
        this.webClient = webClient.baseUrl("http://"+authenticationUrl+":"+authenticationPort).build();
    }

    public boolean auth(Account account) {
        Boolean response = webClient.post().uri("/").accept(MediaType.APPLICATION_JSON).body(Mono.just(account), Account.class).retrieve().bodyToMono(Boolean.class).block();
        return Boolean.TRUE.equals(response);
    }

}
