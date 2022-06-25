package com.icia.dogsevice.controller;


import com.icia.dogsevice.dto.FoodDetailDTO;
import com.icia.dogsevice.dto.FoodPagingDTO;
import com.icia.dogsevice.dto.FoodSaveDTO;
import com.icia.dogsevice.service.FoodService;
import com.icia.dogsevice.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/food/*")
public class FoodController {
    private final FoodService fs;
    private final MemberService ms;

    public static final int BLOCK_LIMIT =4;

    @GetMapping("main")
    public String mainForm(Model model, @PageableDefault(page =1)Pageable pageable){
        String sessionid=ms.getSessionId();
        model.addAttribute("sessionid",sessionid);

        //paging
        Page<FoodPagingDTO> foodList= fs.paging(pageable);
        model.addAttribute("foodList",foodList);
        System.out.println(foodList);

        int startPage=(((int)(Math.ceil((double) pageable.getPageNumber()/BLOCK_LIMIT)))-1)*BLOCK_LIMIT+1;
        int endPage = ((startPage + BLOCK_LIMIT -1)< foodList.getTotalPages()) ? startPage + BLOCK_LIMIT -1 : foodList.getTotalPages();
        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);
        return "/food/main";
    }
    @GetMapping("save")
    public String saveForm(){
        return "/food/save";
    }
    @PostMapping("save")
    public String saveItem(@ModelAttribute FoodSaveDTO foodSaveDTO) throws IOException{
        System.out.println("foodSaveDTO = " + foodSaveDTO);

        fs.save(foodSaveDTO);
        return "redirect:/food/main/";
    }
    @GetMapping("{fIdnum}")
    public String detailForm(@PathVariable Long fIdnum, Model model){
        System.out.println("foodcontroller detail = "+fIdnum);
        FoodDetailDTO dto = fs.findByIdnum(fIdnum);
        System.out.printf("detaile"+dto);
        model.addAttribute("food",dto);
        return "/food/detail";
    }
    @PostMapping("delete")
    public String deleteForm(@RequestParam(value = "FIdnum") Long fIdnum){
        System.out.println(fIdnum);
        fs.deleteByIdnum(fIdnum);
        return "redirect:/food/main";
    }

}
