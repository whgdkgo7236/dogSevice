package com.icia.dogsevice.entity;

import com.icia.dogsevice.dto.FoodDetailDTO;
import com.icia.dogsevice.dto.FoodSaveDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="food_table")
public class FoodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long fIdnum;

    private String fTitle;

    private String fContents;

    private String fCost;

    private String fPhonenum;

    private String fImagefilename;

    private String fImagefilepath;


    public static FoodEntity toFoodSaveEntity(FoodSaveDTO saveDTO){
        FoodEntity foodEntity=new FoodEntity();
        foodEntity.setFIdnum(saveDTO.getFIdnum());
        foodEntity.setFContents(saveDTO.getFContents());
        foodEntity.setFCost(saveDTO.getFCost());
        foodEntity.setFPhonenum(saveDTO.getFPhonenum());
        foodEntity.setFTitle(saveDTO.getFTitle());
        foodEntity.setFImagefilename(saveDTO.getFImagefilename());
        foodEntity.setFImagefilepath(saveDTO.getFImagefilepath());

        return foodEntity;
    }
    public static FoodEntity toFoodDetailEntity(FoodDetailDTO detailDTO){
        FoodEntity foodEntity=new FoodEntity();
        foodEntity.setFIdnum(detailDTO.getFIdnum());
        foodEntity.setFContents(detailDTO.getFContents());
        foodEntity.setFCost(detailDTO.getFCost());
        foodEntity.setFPhonenum(detailDTO.getFPhonenum());
        foodEntity.setFTitle(detailDTO.getFTitle());
        foodEntity.setFImagefilename(detailDTO.getFImagefilename());
        foodEntity.setFImagefilepath(detailDTO.getFImagefilepath());

        return foodEntity;
    }

}
