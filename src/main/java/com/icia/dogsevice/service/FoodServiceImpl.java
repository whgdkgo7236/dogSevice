package com.icia.dogsevice.service;

import com.icia.dogsevice.dto.FoodDetailDTO;
import com.icia.dogsevice.dto.FoodPagingDTO;
import com.icia.dogsevice.dto.FoodSaveDTO;

import com.icia.dogsevice.entity.FoodEntity;
import com.icia.dogsevice.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService{
    private final FoodRepository fr;

    public static final int PAGE_LIMIT =4;
    @Override
    public void save(FoodSaveDTO foodSaveDTO) throws IOException {
        MultipartFile file = foodSaveDTO.getFImagefile();
        foodSaveDTO.setFImagefilename(file.getOriginalFilename());
        foodSaveDTO.setFImagefilename(System.currentTimeMillis()+"_"+foodSaveDTO.getFImagefilename());
        foodSaveDTO.setFImagefilepath("C:\\code\\dogSevice\\src\\main\\resources\\static\\image\\"+foodSaveDTO.getFImagefilename());

        System.out.println(" service foodSaveDTO = " + foodSaveDTO);
        if(!file.isEmpty()){
            file.transferTo(new File(foodSaveDTO.getFImagefilepath()));
        }

        fr.save(FoodEntity.toFoodSaveEntity(foodSaveDTO));

    }

    @Override
    public Page<FoodPagingDTO> paging(Pageable pageable) {
        int page = pageable.getPageNumber();
        page = (page==1)? 0:(page-1);
        Page<FoodEntity> foodEntities = fr.findAll(PageRequest.of(page,PAGE_LIMIT,Sort.by(Sort.Direction.DESC,"fIdnum")));
        Page<FoodPagingDTO> foodList = foodEntities.map(
                food -> new FoodPagingDTO(food.getFIdnum(),
                        food.getFTitle(),
                        food.getFContents(),
                        food.getFCost(),
                        food.getFImagefilename(),
                        food.getFImagefilepath())
        );
        return foodList;
    }

    @Override
    public FoodDetailDTO findByIdnum(Long fIdnum) {
        FoodEntity entityDTO = fr.findById(fIdnum).get();

        return FoodDetailDTO.toDetailDTO(entityDTO);
    }

    @Override
    public void deleteByIdnum(Long fIdnum) {
        fr.deleteById(fIdnum);
    }
}
