package com.icia.dogsevice.service;

import com.icia.dogsevice.dto.FoodDetailDTO;
import com.icia.dogsevice.dto.FoodPagingDTO;
import com.icia.dogsevice.dto.FoodSaveDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FoodService {
    void save(FoodSaveDTO foodSaveDTO)throws IOException;

    Page<FoodPagingDTO> paging(Pageable pageable);


    FoodDetailDTO findByIdnum(Long fIdnum);

    void deleteByIdnum(Long fIdnum);
}
