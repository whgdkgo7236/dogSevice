package com.icia.dogsevice.service;

import com.icia.dogsevice.dto.TradePagingDTO;
import com.icia.dogsevice.dto.TradeSaveDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TradeService {
    void save(TradeSaveDTO toDTOChange);

    Page<TradePagingDTO> paging(Pageable pageable);

    void deleteId(Long tIdnum);
}
