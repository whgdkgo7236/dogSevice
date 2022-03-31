package com.icia.dogsevice.service;

import com.icia.dogsevice.dto.MemberDetailDTO;
import com.icia.dogsevice.dto.MemberLoginDTO;
import com.icia.dogsevice.dto.MemberSaveDTO;

public interface MemberService {
    Long save(MemberSaveDTO memberSaveDTO);

    String getSessionId();

    String findBymId(MemberLoginDTO memberLoginDTO);

    MemberDetailDTO findBySessionid();

    Long saveDetail(MemberDetailDTO detailDTO);

    void logout();
}
