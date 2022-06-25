package com.icia.dogsevice.dto;

import com.icia.dogsevice.entity.MemberEntity;
import com.icia.dogsevice.entity.TradeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TradeListDTO {
    private Long tIdnum;
    private Long fIdnum;
    private String fTitle;
    private String fContents;
    private String fCost;
    private String fPhonenum;

    private String fImagefilename;
    private String fImagefilepath;
    private MemberEntity mMemberentity;
/*
    public static TradeSaveDTO toDTOChange(TradeEntity tradeDTO) {
        TradeSaveDTO DTO = new TradeSaveDTO();
        DTO.setFIdnum(tradeDTO.getFIdnum());
        DTO.setFTitle(tradeDTO.getFTitle());
        DTO.setFContents(tradeDTO.getFContents());
        DTO.setFCost(tradeDTO.getFCost());
        DTO.setFPhonenum(tradeDTO.getFPhonenum());
        DTO.setFImagefilename(tradeDTO.getFImagefilename());
        DTO.setFImagefilepath(tradeDTO.getFImagefilepath());

        return DTO;

    }

 */
}
