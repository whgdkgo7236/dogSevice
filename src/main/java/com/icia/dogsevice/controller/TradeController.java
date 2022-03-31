package com.icia.dogsevice.controller;

import com.icia.dogsevice.dto.FoodDetailDTO;
import com.icia.dogsevice.dto.TradeSaveDTO;
import com.icia.dogsevice.service.FoodService;
import com.icia.dogsevice.service.TradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/trade/*")
public class TradeController {
    private final TradeService ts;
    private final FoodService fs;

    @PostMapping("save")
    public String save(@RequestParam(value = "FIdnum") Long FIdnum){
        System.out.println("fIdnum = " + FIdnum);
        FoodDetailDTO foodDTO =fs.findByIdnum(FIdnum);
        System.out.println("TradeController food = "+ foodDTO);
        ts.save(TradeSaveDTO.toDTOChange(foodDTO));
        return "redirect:/food/main";
    }
}
