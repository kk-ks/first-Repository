package kk_framework.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import kk_framework.constants.SystemConstants;
import kk_framework.mapper.LinkMapper;
import kk_framework.response.ResponseResult;
import kk_framework.service.LinkService;
import kk_framework.response.utils.BeanCopyUtils;
import kk_framework.vo.LinkVO;
import org.springframework.stereotype.Service;
import kk_framework.entity.Link;

import java.util.List;


/**
 * ????(Link)表服务实现类
 *
 * @author makejava
 * @since 2023-07-30 22:31:08
 */
@Service
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {


    @Override
    public ResponseResult getAllLink() {
        LambdaQueryWrapper<Link>lqw=new LambdaQueryWrapper<>();
        lqw.eq(Link::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);
        List<Link> list = list(lqw);
        List<LinkVO> linkVO = BeanCopyUtils.copyBeanList(list, LinkVO.class);
        return ResponseResult.okResult(linkVO);
    }
}


