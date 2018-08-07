package lesson.controller;

import lesson.entity.Item;
import lesson.service.ItemService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ItemController {

    @RequestMapping("/test")
    public String test() {
        return "hello, world";
    }


    @Resource
    private ItemService itemService;

    @RequestMapping("/test2/{itemId}/{number}")
    public String test2(@PathVariable("itemId") int itemId, @PathVariable("number") int number) {
        return itemService.buyItems(itemId, number);
    }

}
