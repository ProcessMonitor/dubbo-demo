import Interface.FruitDataEntityT;
import Interface.FruitMap;
import Vo.FruitVo1;
import com.codeforce.provider.ProviderApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


/**
 * 使用教程
 * https://juejin.cn/post/7015131549750263844#heading-5
 */
@SpringBootTest(classes = ProviderApplication.class)
public class MapStructTest {

//    @Resource
//    private FruitMap fruitMapper;

    // 使用 MapStruct 工具，将实体类转 VO 对象，VO 中的字段和 pojo 字段一致的情况
    @Test
    void pojo_to_vo_field_same() {
        // FruitDataEntityT fruit = fruitMapper.selectById(1L);
        FruitDataEntityT fruit = FruitDataEntityT.builder().fruitId(11L).fruitName("apple").build();
        FruitVo1 fruitVo1 = FruitMap.INSTANCE.pojo2vo1(fruit);
        FruitVo1 fruitVo1_2 = FruitMap.INSTANCE.pojo2vo1(fruit);
        System.out.println(fruitVo1);
        System.out.println(fruitVo1_2);
    }

//    @Test
//        // 使用 MapStruct 工具，将实体类转 VO 对象，VO 中的字段和 pojo 字段不一致的情况
//    void pojo_to_vo2_field_different() {
//        FruitDataEntityT fruit = fruitMapper.selectById(15L);
//        // 使用了 @Mappings( { @Mapping(...), ...}) 注解
//        FruitVO2 fruitVO2 = FruitMap.mapper.pojo2vo2(fruit);
//        System.out.println(fruitVO2);
//    }
//
//    @Test
//        // 不仅能实现实体类到 VO 的转换，还能反着来
//    void vo2_to_pojo_field_same() {
//        FruitDataEntityT fruit = fruitMapper.selectById(1L);
//        System.out.println(fruit);
//        FruitVO fruitVO = FruitMap.mapper.pojo2vo(fruitMapper.selectById(2L));
//        System.out.println(fruitVO);
//        FruitDataEntityT fruit1 = FruitMap.mapper.vo2pojo(fruitVO);
//        System.out.println(fruit1);
//    }
//
//    @Test
//        // 基于对象转换的集合转换（字段相同）
//    void pojo_list_to_vo_field_same() {
//        QueryWrapper<FruitDataEntityT> wrapper = new QueryWrapper<>();
//        wrapper.le("fruit_id", 3);
//        List<FruitDataEntityT> fruits = fruitMapper.selectList(wrapper);
//        List<FruitVO> fruitVOs = FruitMap.mapper.pojoList2vo(fruits);
//        fruitVOs.forEach(System.out::println);
//    }
//
//    @Test
//        // 基于对象转换的集合转换（字段不相同）
//    void pojo_list_to_vo2_field_different() {
//        QueryWrapper<FruitDataEntityT> wrapper = new QueryWrapper<>();
//        wrapper.le("fruit_id", 3);
//        List<FruitDataEntityT> fruits = fruitMapper.selectList(wrapper);
//        // pojo -> vo 之间的映射只要写一次即可
//        List<FruitVO2> fruitVO2s = FruitMap.mapper.pojoList2vo2(fruits);
//        for (FruitVO2 fruitVO2 : fruitVO2s) {
//            System.out.println(fruitVO2);
//        }
//    }
}
