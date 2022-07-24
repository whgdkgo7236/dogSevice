package com.icia.dogsevice.dto;

import com.icia.dogsevice.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TradePagingDTO {
    private Long tIdnum;
    private Long fIdnum;
    private String fTitle;
    private String fContents;
    private String fCost;
    private String fPhonenum;

    private String fImagefilename;
    private String fImagefilepath;
    private MemberEntity mMemberEntity;
}
