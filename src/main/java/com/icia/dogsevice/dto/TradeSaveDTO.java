package com.icia.dogsevice.dto;

import com.icia.dogsevice.entity.MemberEntity;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TradeSaveDTO {
    private Long tIdnum;
    private Long fIdnum;
    private String fTitle;
    private String fContents;
    private String fCost;
    private String fPhonenum;

    private String fImagefilename;
    private String fImagefilepath;
    private MemberEntity mMemberentity;

    public static TradeSaveDTO toDTOChange(FoodDetailDTO detailDTO){
        TradeSaveDTO DTO = new TradeSaveDTO();
        DTO.setFIdnum(detailDTO.getFIdnum());
        DTO.setFTitle(detailDTO.getFTitle());
        DTO.setFContents(detailDTO.getFContents());
        DTO.setFCost(detailDTO.getFCost());
        DTO.setFPhonenum(detailDTO.getFPhonenum());
        DTO.setFImagefilename(detailDTO.getFImagefilename());
        DTO.setFImagefilepath(detailDTO.getFImagefilepath());

        return DTO;

    }
}
