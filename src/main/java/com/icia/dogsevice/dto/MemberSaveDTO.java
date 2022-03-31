package com.icia.dogsevice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MemberSaveDTO {
    private Long mIdnum;
    private String mId;
    private String mPassword;
    private String mName;
    private String mAddress;
    private String mEmail;
    private String mPhonenum;

}
