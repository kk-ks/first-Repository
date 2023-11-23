package kk_framework.service;

import com.baomidou.mybatisplus.extension.service.IService;
import kk_framework.entity.Link;
import kk_framework.response.ResponseResult;


/**
 * ????(Link)表服务接口
 *
 * @author makejava
 * @since 2023-07-30 22:31:08
 */
public interface LinkService extends IService<Link> {


    ResponseResult getAllLink();
}


