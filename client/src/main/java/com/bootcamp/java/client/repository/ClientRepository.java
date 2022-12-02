package com.bootcamp.java.client.repository;

import com.bootcamp.java.client.domain.Client;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ClientRepository extends ReactiveMongoRepository<Client, String> {
    Mono<Client> findByIdentityNumber(String identityNumber);
}
