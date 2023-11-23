package kk_framework.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ???±(Article)表实体类
 *
 * @author makejava
 * @since 2023-07-26 21:28:03
 */
@SuppressWarnings("serial")
@TableName("sg_article")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article extends Model<Article> {
    @TableId
    private Long id;
    //???
    private String title;
    //???????
    private String content;


    @TableField(exist = false)
    private String categoryName;
    //????ժҪ
    private String summary;
    //????????id
    private Long categoryId;
    //????ͼ
    private String thumbnail;
    //?Ƿ??ö???0????1?ǣ?
    private String isTop;
    //״̬??0?ѷ?????1?ݸ壩
    private String status;
    //??????
    private Long viewCount;
    //?Ƿ????????? 1?ǣ?0?
    private String isComment;
    
    private Long createBy;
    
    private Date createTime;
    
    private Long updateBy;
    
    private Date updateTime;
    //ɾ????־??0????δɾ????1??????ɾ?
    private Integer delFlag;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getIsTop() {
        return isTop;
    }

    public void setIsTop(String isTop) {
        this.isTop = isTop;
    }

    public String getStatus() {
        return status;
    }



    /**
     * 获取主键值
     *
     * @return 主键值
     */
//    @Override
//    protected Serializable pkVal() {
//        return this.id;
//    }
    }

