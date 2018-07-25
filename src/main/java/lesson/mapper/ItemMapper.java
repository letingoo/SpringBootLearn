package lesson.mapper;

import lesson.annotation.Cache;
import lesson.entity.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ItemMapper {

    @Cache(type = "read")
    @Select("SELECT * FROM item where itemID = #{itemID}")
    Item getItemById(@Param("itemID") int itemId);


    Item increaseItem(@Param("itemID") int itemId, int number);
}
