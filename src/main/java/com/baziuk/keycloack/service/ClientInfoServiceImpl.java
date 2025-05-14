package com.baziuk.keycloack.service;

import com.baziuk.keycloack.entitys.ClientInfoEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ClientInfoServiceImpl {

    ClientInfoEntity save(ClientInfoEntity clientInfoEntity);

    //ClientInfoEntity update(ClientInfoEntity clientInfoEntity);

    List<ClientInfoEntity> findAll();

    Optional<ClientInfoEntity> findById(Integer id);

    void deleteById(Integer clientId);
}
