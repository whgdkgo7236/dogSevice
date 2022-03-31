package com.icia.dogsevice.dto;

import com.icia.dogsevice.entity.MemberEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MemberDetailDTO {
    private Long mIdnum;
    private String mId;
    private String mPassword;
    private String mName;
    private String mAddress;
    private String mEmail;
    private String mPhonenum;


    public static MemberDetailDTO todetailDTO(MemberEntity memberEntity){
        MemberDetailDTO memberDetailDTO = new MemberDetailDTO();
        memberDetailDTO.setMIdnum(memberEntity.getMIdnum());
        memberDetailDTO.setMId(memberEntity.getMId());
        memberDetailDTO.setMPassword(memberEntity.getMPassword());
        memberDetailDTO.setMName(memberEntity.getMName());
        memberDetailDTO.setMAddress(memberEntity.getMAddress());
        memberDetailDTO.setMEmail(memberEntity.getMEmail());
        memberDetailDTO.setMPhonenum(memberEntity.getMPhonenum());

        return memberDetailDTO;
    }
}
