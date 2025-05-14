package com.baziuk.keycloack.repositorys;

import com.baziuk.keycloack.entitys.ClientInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientInfoRepository extends JpaRepository<ClientInfoEntity, Long> {
}
