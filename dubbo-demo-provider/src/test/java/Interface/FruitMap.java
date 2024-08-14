package Interface;

import Vo.FruitVo1;
import Vo.FruitVo2;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MapperFruit {

    MapperFruit mapper = Mappers.getMapper(MapperFruit.class);

    @Mappings({
            @Mapping(source = "fruitId", target = "fruitId"),
            @Mapping(source = "fruitName", target = "fruitName"),
            @Mapping(source = "fruitSale", target = "fruitSale"),
            @Mapping(source = "localIcon", target = "localIcon"),
            @Mapping(source = "spareIcon", target = "spareIcon"),
            @Mapping(source = "updateTime", target = "updateTime")
    })
    FruitVo1 pojo2vo1(FruitDataEntityT fruit);
    FruitDataEntityT vo2pojo1(FruitVo1 FruitVo1);

    @Mappings({
            @Mapping(source = "fruitId", target = "id"),
            @Mapping(source = "fruitName", target = "name"),
            @Mapping(source = "fruitSale", target = "sale")
    })
    FruitVo2 pojo2vo2(FruitDataEntityT fruit);

    List<FruitVo1> pojoList2vo(List<FruitDataEntityT> fruits);

    List<FruitVo2> pojoList2vo2(List<FruitDataEntityT> fruits);

//    @Mappings({
//            @Mapping(source = "updateTime", target = "orderId", qualifiedByName = "setOrderIdByUpdateTime"),
//            @Mapping(source = "fruitId", target = "shortage.id"),
//            @Mapping(source = "fruitSale", target = "shortage.lackNum")
//    })
//    PurchaseList pojo2PurchaseList(FruitDataEntityT fruit);

//    @Named("setOrderIdByUpdateTime")
//    default Long setOrderIdByUpdateTime(Date updateTime) {
//        return System.currentTimeMillis() - updateTime.getTime();
//    }
}
