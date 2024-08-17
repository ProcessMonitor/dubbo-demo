package Vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 模拟不同Dto、Vo数据库entity的测试类
 */
@Data
public class FruitVo2 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Integer sale;
}
