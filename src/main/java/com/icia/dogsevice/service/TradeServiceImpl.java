package com.icia.dogsevice.service;

import com.icia.dogsevice.dto.*;
import com.icia.dogsevice.entity.MemberEntity;
import com.icia.dogsevice.entity.TradeEntity;
import com.icia.dogsevice.repository.MemberRepository;
import com.icia.dogsevice.repository.TradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class TradeServiceImpl implements TradeService{
    private final TradeRepository tr;
    private final MemberService ms;

    public static final int PAGE_LIMIT =3;
    public static final int PAGE_LIMIT_MYLIST =8;
    @Override
    public void save(TradeSaveDTO toDTOChange) {
        toDTOChange.setMMemberentity(MemberEntity.toDetailEntity(ms.findBySessionid()));
        tr.save(TradeEntity.toTradeSaveEntity(toDTOChange));
    }

    @Override
    public Page<TradePagingDTO> paging(Pageable pageable) {
        int page = pageable.getPageNumber();
        page = (page==1)? 0:(page-1);
        Page<TradeEntity> tradeEntities = tr.findAll(PageRequest.of(page,PAGE_LIMIT,Sort.by(Sort.Direction.DESC,"tIdnum")));
        Page<TradePagingDTO> tradeList = tradeEntities.map(
                trade -> new TradePagingDTO(trade.getTIdnum(),
                        trade.getFIdnum(),
                        trade.getFTitle(),
                        trade.getFContents(),
                        trade.getFCost(),
                        trade.getFPhonenum(),
                        trade.getFImagefilename(),
                        trade.getFImagefilepath(),
                        trade.getMemberEntity())


        );

        return tradeList;
    }

    @Override
    public void deleteId(Long tIdnum) {
        tr.deleteById(tIdnum);
    }

    @Override
    public List<TradeListDTO> findAllListbyId() {


        ArrayList<TradeListDTO> ListDTO = new ArrayList<>();

        List<TradeEntity> tradeEntities =  tr.findBymemberEntity(MemberEntity.toDetailEntity(ms.findBySessionid()));

        for(int i =0;i< tradeEntities.size();i++) {
            TradeListDTO tradeDTO = TradeListDTO.toDTOChange(tradeEntities.get(i));
            ListDTO.add(i,tradeDTO);
        }

        return ListDTO;
    }




}
