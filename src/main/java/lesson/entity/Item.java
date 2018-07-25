package lesson.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 商品
 */
@ToString
public class Item {

    //id
    @Getter @Setter
    private Integer itemId;

    // 价格
    @Getter @Setter
    private Double price;

    // 数量
    @Getter @Setter
    private int numbers;

    // 名字
    @Getter @Setter
    private String title;



}
