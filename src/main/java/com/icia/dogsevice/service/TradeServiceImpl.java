package com.icia.dogsevice.service;

import com.icia.dogsevice.dto.TradeSaveDTO;
import com.icia.dogsevice.entity.MemberEntity;
import com.icia.dogsevice.entity.TradeEntity;
import com.icia.dogsevice.repository.MemberRepository;
import com.icia.dogsevice.repository.TradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TradeServiceImpl implements TradeService{
    private final TradeRepository tr;
    private final MemberService ms;
    @Override
    public void save(TradeSaveDTO toDTOChange) {
        toDTOChange.setMMemberentity(MemberEntity.toDetailEntity(ms.findBySessionid()));
        tr.save(TradeEntity.toTradeSaveEntity(toDTOChange));
    }
}
