package kk_framework.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoVO {
        /**
         * 主键
         */
        private Long id;

        /**
         * 昵称
         */
        private String nickName;

        /**
         * 头像
         */
        private String avatar;

        private String sex;

        private String email;
}