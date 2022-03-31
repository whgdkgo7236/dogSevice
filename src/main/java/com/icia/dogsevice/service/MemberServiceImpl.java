package com.icia.dogsevice.service;

import com.icia.dogsevice.dto.MemberDetailDTO;
import com.icia.dogsevice.dto.MemberLoginDTO;
import com.icia.dogsevice.dto.MemberSaveDTO;
import com.icia.dogsevice.entity.MemberEntity;
import com.icia.dogsevice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    private final HttpSession session;
    private final MemberRepository mr;

    @Override
    public Long save(MemberSaveDTO memberSaveDTO) {
        System.out.println("memberSaveDTO = " + memberSaveDTO.toString());

        return mr.save(MemberEntity.toSaveEntity(memberSaveDTO)).getMIdnum();
    }

    @Override
    public String getSessionId() {

        return (String)session.getAttribute("id");
    }

    @Override
    public String findBymId(MemberLoginDTO memberLoginDTO) {
        String result;
        MemberEntity memberEntity = mr.findBymId(memberLoginDTO.getMId());
        MemberLoginDTO loginDTO =MemberLoginDTO.toLoginDTO(memberEntity);
        System.out.println("LoginDTO = " +loginDTO );
        if((memberLoginDTO.getMId().equals(loginDTO.getMId()))&&(memberLoginDTO.getMPassword().equals(loginDTO.getMPassword()))){
            System.out.println("login  성공");
            session.setAttribute("id",memberLoginDTO.getMId());
            session.setAttribute("password",memberLoginDTO.getMPassword());
            result = "index";
        }else{
            result = "login";
        }
        System.out.println("id = " +loginDTO.getMId() + "     " + memberLoginDTO.getMId()+" 비밀번호    " +memberLoginDTO.getMPassword()+ "   " +loginDTO.getMPassword());
        return result;
    }

    @Override
    public MemberDetailDTO findBySessionid() {
        MemberEntity memberEntity = mr.findBymId((String)session.getAttribute("id"));
        MemberDetailDTO memberDetailDTO = MemberDetailDTO.todetailDTO(memberEntity);
        System.out.println(memberDetailDTO);
        return memberDetailDTO;
    }

    @Override
    public Long saveDetail(MemberDetailDTO detailDTO) {
        return mr.save(MemberEntity.toDetailEntity(detailDTO)).getMIdnum();
    }

    @Override
    public void logout() {
        session.removeAttribute("id");
    }
}
