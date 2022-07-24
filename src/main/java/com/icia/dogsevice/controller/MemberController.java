package com.icia.dogsevice.controller;

import com.icia.dogsevice.dto.*;
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

        Long memberid=ms.save(memberSaveDTO);
        return "/member/login";
    }
    @GetMapping("login")
    public String loginForm(){return "/member/login"; }

    @PostMapping("login")
    public String login(@ModelAttribute MemberLoginDTO memberLoginDTO,Model model) {

        String address = ms.findBymId(memberLoginDTO);

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
        model.addAttribute("sessionid",ms.getSessionId());


        return "/member/detail";
    }
    @PostMapping("detail")
    public String detailSave(@ModelAttribute MemberDetailDTO detailDTO,Model model){
        model.addAttribute("sessionid",ms.getSessionId());
        Long memberId = ms.saveDetail(detailDTO);
        model.addAttribute("sessionid",ms.getSessionId());


        return "index";
    }

    @GetMapping("trade")
    public String myfood(Model model,@PageableDefault(page =1)Pageable pageable){
        model.addAttribute("sessionid",ms.getSessionId());
        if(ms.findBySessionid().getMId().equals("admin")){
            Page<TradePagingDTO> tpaging= ts.paging(pageable);

            model.addAttribute("tList",tpaging);
            model.addAttribute("tCost","0");
            model.addAttribute("member",ms.findBySessionid());
            return "/trade/main";

        }
        else{
            List<TradeListDTO> tList= ts.findAllListbyId();
            model.addAttribute("tList",tList);
            int totalCost = 0;
            for(int i=0 ; i<tList.size();i++){
                totalCost+= Integer.parseInt(tList.get(i).getFCost());
            }
            model.addAttribute("tCost",totalCost);

            model.addAttribute("member",ms.findBySessionid());

            return "/member/myfood";
        }


    }


}


