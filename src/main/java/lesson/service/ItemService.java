package lesson.service;

import lesson.entity.Item;
import lesson.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private ItemMapper itemMapper;



}
