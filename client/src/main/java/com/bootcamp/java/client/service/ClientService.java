package com.bootcamp.java.client.service;

import com.bootcamp.java.client.DTO.ClientTypeEnum;
import com.bootcamp.java.client.Exceptions.InvalidClientTypeException;
import com.bootcamp.java.client.domain.Client;
import com.bootcamp.java.client.repository.ClientRepository;
import com.bootcamp.java.client.web.mapper.ClientMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional

public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientMapper clientMapper;

    //Llama a los méodos que están en el repositoey
    public Flux<Client> findAll(){
        log.debug("findAll executed");
        return clientRepository.findAll();
    }

    public Mono<Client> findById(String customerId){
        log.debug("findById executed {}", customerId);
        return clientRepository.findById(customerId);
    }
    //Se guarda en el repositorio
    public Mono<Client> create(Client client){
        log.debug("create executed {}", client);
        if (client.getType().trim().equals(ClientTypeEnum.BUSINESS.getValue()) ||
                client.getType().trim().equals(ClientTypeEnum.PERSONNEL.getValue())) {
            return clientRepository.save(client);
        }
        else {
            return Mono.error(new InvalidClientTypeException());
        }
        //return clientRepository.save(client);
    }
    public Mono<Client> update(String customerId, Client customer){
        log.debug("update executed {}:{}", customerId, customer);
        //Se busca por ID is existe se actualiza
        return clientRepository.findById(customerId)
                .flatMap(dbCustomer -> {
                    clientMapper.update(dbCustomer, customer);
                    return clientRepository.save(dbCustomer);
                });
    }

    public Mono<Client> delete(String customerId){
        log.debug("delete executed {}", customerId);
        return clientRepository.findById(customerId)
                .flatMap(existingCustomer -> clientRepository.delete(existingCustomer)
                        .then(Mono.just(existingCustomer)));
    }
    }
