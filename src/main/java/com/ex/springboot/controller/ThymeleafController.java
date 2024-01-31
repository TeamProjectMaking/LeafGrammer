package com.ex.springboot.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ex.springboot.dto.ItemDto;

@Controller
@RequestMapping /*실행확인 후 프로젝트 복제하여 leafGrammer로 바꾸고 8)로컬호스트:8085로 가면 바로 메인페이지 나오도록 리퀘스트 맵핑 수정 =>com.ex.springboot.dto패키지 생성하고 ItemDto 생성*/
public class ThymeleafController {
	
//	10)header.html에서 메인 링크 수정하고 오기
	@GetMapping("/") 
    public String main(Model model){
        return "thymeleaf/main";
    }
    
	@GetMapping("board")
    public String board(Model model){
        return "thymeleaf/board";
    }
    
	/* 11)베스트 상세 페이지로 이동하는 매퍼 생성 => best.html 생성*/
	@GetMapping(value = "best")
    public String bestPage(Model model){
        ItemDto itemDto = new ItemDto();
        itemDto.setItemDetail("베스트 상품 상세 설명");
        itemDto.setItemNm("베스트 상품1");
        itemDto.setPrice(10000);
        itemDto.setRegTime(LocalDateTime.now());

        model.addAttribute("itemDto", itemDto);
        return "thymeleaf/best";
    }
	
	/* 12)loop 테스트를 위한 bestProducts 생성하고 매퍼 생성  => bestProducts.html 생성*/
    @GetMapping(value = "bestProducts")
    public String bestProductsPage(Model model){
    List<ItemDto> itemDtoList = new ArrayList<>();

        for (int i = 1; i <=10; i++) {

            ItemDto itemDto = new ItemDto();
            itemDto.setItemDetail("베스트 상품 상세 설명"+i);
            itemDto.setItemNm("베스트 상품"+i);
            itemDto.setPrice(1000*i);
            itemDto.setRegTime(LocalDateTime.now());

            itemDtoList.add(itemDto);
        }
        model.addAttribute("itemDtoList", itemDtoList);
        return "thymeleaf/bestProducts";
    }    
    
	/* 17)login 매퍼 생성후 실행 확인 */
    @GetMapping(value = "login")
    public String login(@RequestParam(value="param1") String param1, @RequestParam(value="param2") String param2, Model model){
        model.addAttribute("param1", param1);
        model.addAttribute("param2", param2);
        return "thymeleaf/login";
    }

}

