package kk_framework.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ?û??(User)表实体类
 *
 * @author makejava
 * @since 2023-08-06 19:54:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_user")
public class User  implements Serializable {

    @TableId
    private Long id;

    private String userName;

    private String nickName;
    

    private String password;
    

    private String type;

    private String status;

    private String email;
    

    private String phonenumber;

    private String sex;
    

    private String avatar;
    

    private Date createTime;

    private Long updateBy;
    

    private Date updateTime;

    private Integer delFlag;
    
        }


