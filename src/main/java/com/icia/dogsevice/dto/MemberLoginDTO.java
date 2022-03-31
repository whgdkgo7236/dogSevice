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
public class MemberLoginDTO {

    private Long mIdnum;
    private String mId;
    private String mPassword;

    public static MemberLoginDTO toLoginDTO(MemberEntity me){
        MemberLoginDTO memberLoginDTO = new MemberLoginDTO();
        memberLoginDTO.setMIdnum(me.getMIdnum());
        memberLoginDTO.setMId(me.getMId());
        memberLoginDTO.setMPassword(me.getMPassword());
        return memberLoginDTO;
    }

}
