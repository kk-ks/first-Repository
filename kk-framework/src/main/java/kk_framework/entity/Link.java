package kk_framework.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ????(Link)表实体类
 *
 * @author makejava
 * @since 2023-07-30 22:34:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sg_link")
public class Link {

    @TableId
    private int id;
    private String name;

    private String logo;

    private String description;

    private String address;

    private String status;

    private Date createTime;

    private Long updateBy;

    private Date updateTime;

    private Integer delFlag;
    
}


