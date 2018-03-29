package com.codependent.cryptomarket.ui.web

import com.codependent.cryptomarket.ui.dto.Character
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@RestController
class StarWarsApiController {

    @GetMapping("/api/people/{id}")
    fun getCharacter(@PathVariable id: Int): Mono<Character> {
        val webClient = WebClient.builder()
        return webClient.baseUrl("https://swapi.co/api/").build()
                .get().uri("/people/$id")
                .header("Content-Type", APPLICATION_JSON_VALUE)
                .accept(APPLICATION_JSON).retrieve()
                .bodyToMono(Character::class.java)
    }

}