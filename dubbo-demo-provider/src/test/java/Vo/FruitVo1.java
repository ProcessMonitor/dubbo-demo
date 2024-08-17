package Vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 模拟不同Dto、Vo数据库entity的测试类
 */
@Data
public class FruitVo1 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long fruitId;
    private String fruitName;
    private Integer fruitSale;
    private String localIcon;
    private String spareIcon;


    private Date updateTime;
}
