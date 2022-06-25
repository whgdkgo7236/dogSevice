package com.icia.dogsevice.repository;

import com.icia.dogsevice.dto.TradeListDTO;
import com.icia.dogsevice.entity.TradeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TradeRepository extends JpaRepository<TradeEntity,Long> {

    List<TradeEntity> findBymemberEntity(Long mId);
}

