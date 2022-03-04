package com.example.springbootmyselectshop.controller;

import com.example.springbootmyselectshop.models.ItemDto;
import com.example.springbootmyselectshop.utils.NaverShopSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor // final 로 선언된 클래스를 자동으로 생성합니다.
@RestController // JSON으로 응답함을 선언합니다.
public class SearchRequestController {

    private final NaverShopSearch naverShopSearch;

    @RequestMapping(value = "/api/search", method = RequestMethod.GET)
    public List<ItemDto> getItems(@RequestParam String query) {
        String resultString = naverShopSearch.search(query);
        return naverShopSearch.fromJSONtoItems(resultString);
    }
}
