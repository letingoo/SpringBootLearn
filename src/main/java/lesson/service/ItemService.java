package lesson.service;

import lesson.entity.Item;
import lesson.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private ItemMapper itemMapper;


    public Item getItemById(int itemId) {
        return itemMapper.getItemById(itemId);
    }



    public String buyItems(int itemId, int number) {
        itemMapper.decreaseItem(itemId, number);
        return "1";
    }

}
