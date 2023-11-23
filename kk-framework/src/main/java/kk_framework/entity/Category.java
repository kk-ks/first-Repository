package kk_framework.entity;
 
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.NoArgsConstructor;

/**
 * ?????(Category)实体类
 *
 * @author makejava
 * @since 2023-07-30 14:08:35
 */
@Data
@TableName(value = "sg_category")
@AllArgsConstructor
@NoArgsConstructor
public class Category {
     
    private Long id;
    /**
     * ?????
     */ 
    private String name;
    /**
     * ??????id??????û?и?????Ϊ-1
     */ 
    private Long pid;
    /**
     * ???
     */ 
    private String description;
    /**
     * ״̬0:????,1?
     */ 
    private String status;
     
    private Long createBy;
     
    private Date createTime;
     
    private Long updateBy;
     
    private Date updateTime;
    /**
     * ɾ????־??0????δɾ????1??????ɾ?
     */ 
    private Integer delFlag;
 
}
