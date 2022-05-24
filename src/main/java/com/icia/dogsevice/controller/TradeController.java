package com.icia.dogsevice.controller;

import com.icia.dogsevice.dto.FoodDetailDTO;
import com.icia.dogsevice.dto.TradePagingDTO;
import com.icia.dogsevice.dto.TradeSaveDTO;
import com.icia.dogsevice.service.FoodService;
import com.icia.dogsevice.service.MemberService;
import com.icia.dogsevice.service.TradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/trade/*")
public class TradeController {
    private final TradeService ts;
    private final FoodService fs;
    private final MemberService ms;

    @PostMapping("save")
    public String save(@RequestParam(value = "FIdnum") Long FIdnum){
        System.out.println("fIdnum = " + FIdnum);
        FoodDetailDTO foodDTO =fs.findByIdnum(FIdnum);
        System.out.println("TradeController food = "+ foodDTO);
        ts.save(TradeSaveDTO.toDTOChange(foodDTO));
        return "redirect:/food/main";
    }
    @GetMapping("")
    public String mainForm(Model model, @PageableDefault(page =1) Pageable pageable){
        String sessionid=ms.getSessionId();
        model.addAttribute("sessionid",sessionid);

        Page<TradePagingDTO> pagingList =ts.paging(pageable);
        System.out.println("trade들어옴");
        model.addAttribute("pagingList",pagingList);
        return "/trade/main";
    }
    @GetMapping("delete/{tIdnum}")
    public String delete(@PathVariable Long tIdnum){
        System.out.println("tid = "+tIdnum);
        ts.deleteId(tIdnum);
        return "redirect:/trade/main";
    }
}
