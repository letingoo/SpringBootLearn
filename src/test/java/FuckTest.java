import lesson.SpringApplication;
import lesson.entity.Item;
import lesson.service.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = SpringApplication.class)
@RunWith(SpringRunner.class)
public class FuckTest {

    @Autowired
    private ItemService itemService;


    @Test
    public void test() {
        Item item = itemService.getItemById(1);
        System.out.println(item);
    }
}
