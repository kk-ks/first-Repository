package kk_framework.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleListVO {

    private Long id;
    //???
    private String title;
    //???????

    //????ժҪ
    private String summary;
    //????????id
    private String categoryName;
    //????ͼ
    private String thumbnail;
    //?Ƿ??ö???0????1?ǣ?
    private String isTop;
    //״̬??0?ѷ?????1?ݸ壩

    //??????
    private Long viewCount;
    //?Ƿ????????? 1?ǣ?0?

    private Date createTime;



    private Date updateTime;

}
