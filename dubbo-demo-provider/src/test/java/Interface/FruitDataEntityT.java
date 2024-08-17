package Interface;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * 模拟数据库entity的测试类
 */
@Data
@Builder
public class FruitDataEntityT {
    /**
     * 主键id
     */
    private Long fruitId;

    /**
     * 水果名称
     */
    private String fruitName;

    /**
     * 水果销量
     */
    private Integer fruitSale;

    /**
     * 本地图标地址
     */
    private String localIcon;

    /**
     * 备用的网络图标地址
     */
    private String spareIcon;

    /**
     * 逻辑删除 0 未删除，1 被删除
     */
    private Byte isDeleted;

    /**
     * 修改更新时间
     */

    private Date updateTime;

    /**
     * 乐观锁标识，用于控制唯一的修改操作
     */
    private Integer version;
}

