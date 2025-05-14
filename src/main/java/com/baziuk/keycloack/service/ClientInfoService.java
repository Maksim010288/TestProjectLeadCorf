package com.baziuk.keycloack.service;

import com.baziuk.keycloack.entitys.ClientInfoEntity;
import com.baziuk.keycloack.repositorys.ClientInfoRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class ClientInfoService implements ClientInfoServiceImpl {
    private ClientInfoRepository clientInfoRepository;

    @Autowired
    public ClientInfoService(ClientInfoRepository clientInfoRepository) {
        this.clientInfoRepository = clientInfoRepository;
    }

    @Override
    public ClientInfoEntity save(ClientInfoEntity clientInfoEntity) {
        clientInfoRepository.save(clientInfoEntity);
        return clientInfoEntity;
    }

//    @Override
//    public ClientInfoEntity update(ClientInfoEntity clientInfoEntity) {
//        for (ClientInfoEntity entity : findAll()){
//            if(entity.getId().equals(clientInfoEntity.getId())){
//                entity.setName(clientInfoEntity.getName());
//                entity.setEmail(clientInfoEntity.getEmail());
//                entity.setLocation(clientInfoEntity.getLocation());
//                entity.setTaxNumber(clientInfoEntity.getTaxNumber());
//                entity.setUserId(clientInfoEntity.getUserId());
//            }
//            clientInfoRepository.saveAndFlush(entity);
//        }
//        return clientInfoEntity;
//    }

    @Override
    public List<ClientInfoEntity> findAll() {
       return clientInfoRepository.findAll();
    }

    @Override
    public Optional<ClientInfoEntity> findById(Integer id) {
        return clientInfoRepository.findById(id.longValue());
    }

    @Override
    public void deleteById(Integer clientId) {
        clientInfoRepository.deleteById(clientId.longValue());
    }
}
