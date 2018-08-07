package lesson.mapper;

import lesson.annotation.Cache;
import lesson.entity.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ItemMapper {

    @Cache(type = "read")
    @Select("SELECT * FROM item where itemID = #{itemID}")
    Item getItemById(@Param("itemID") int itemId);


    @Update("update item set number = number - #{decreaseNumber}")
    void decreaseItem(@Param("itemID") int itemId, @Param("decreaseNumber") int number);
}
