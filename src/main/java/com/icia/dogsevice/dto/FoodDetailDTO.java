package com.icia.dogsevice.dto;

import com.icia.dogsevice.entity.FoodEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FoodDetailDTO {
    private Long fIdnum;
    private String fTitle;
    private String fContents;
    private String fCost;
    private String fPhonenum;
    private String fImagefilename;
    private String fImagefilepath;

    public static FoodDetailDTO toDetailDTO(FoodEntity entity){
        FoodDetailDTO detail = new FoodDetailDTO();
        detail.setFIdnum(entity.getFIdnum());
        detail.setFTitle(entity.getFTitle());
        detail.setFContents(entity.getFContents());
        detail.setFCost(entity.getFCost());
        detail.setFPhonenum(entity.getFPhonenum());
        detail.setFImagefilename(entity.getFImagefilename());
        detail.setFImagefilepath(entity.getFImagefilepath());

        return detail;
    }
}
