package com.icia.dogsevice.controller;

import com.icia.dogsevice.dto.MemberDetailDTO;
import com.icia.dogsevice.dto.MemberLoginDTO;
import com.icia.dogsevice.dto.MemberSaveDTO;
import com.icia.dogsevice.dto.TradeListDTO;
import com.icia.dogsevice.service.FoodService;
import com.icia.dogsevice.service.MemberService;
import com.icia.dogsevice.service.TradeService;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member/*")
public class MemberController {
    private final MemberService ms;
    private final TradeService ts;

    public static final int BLOCK_LIMIT =4;

    @GetMapping("save")
    public String saveForm(){
        return "/member/save";
    }

    @PostMapping("save")
    public String saveMember(@ModelAttribute MemberSaveDTO memberSaveDTO, HttpSession session, RedirectAttributes redirectAttributes){
        System.out.println("memberSaveDTO = " + memberSaveDTO );
        Long memberid=ms.save(memberSaveDTO);
        return "/member/login";
    }
    @GetMapping("login")
    public String loginForm(){return "/member/login"; }

    @PostMapping("login")
    public String login(@ModelAttribute MemberLoginDTO memberLoginDTO,Model model) {
        System.out.println("로그인들어옴 " + memberLoginDTO);
        String address = ms.findBymId(memberLoginDTO);
        System.out.println("address = " + address);
        if(address == "index"){
            model.addAttribute("sessionid",ms.getSessionId());
            return "index";
        }else{
            return "/member/login";
        }
    }
    @GetMapping("logout")
    public String logout(Model model){
        ms.logout();
        model.addAttribute("sessionid",ms.getSessionId());
        return "index";
    }
    @GetMapping("detail")
    public String detailForm(Model model){
        MemberDetailDTO DTO=ms.findBySessionid();
        model.addAttribute("detailDTO",DTO);

        System.out.println("들어옴");
        return "/member/detail";
    }
    @PostMapping("detail")
    public String detailSave(@ModelAttribute MemberDetailDTO detailDTO,Model model){
        model.addAttribute("sessionid",ms.getSessionId());
        Long memberId = ms.saveDetail(detailDTO);


        return "index";
    }

    @GetMapping("trade")
    public String myfood(Model model){
        System.out.println("맴버컨트롤 ");
        List<TradeListDTO> tList= ts.findAllListbyId();
        System.out.println("tList = "+tList);
        model.addAttribute("tList",tList);



        //List<TradeListDTO> list= ts.findAllListbyId(ms.getSessionId());
        //System.out.println(list);
        return "/member/myfood";
    }


}


