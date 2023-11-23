package kk_framework.response.utils;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class BeanCopyUtils {
    private BeanCopyUtils(){

    }
    public static <V>V copyBean(Object source,Class<V> clazz){
        //创建目标对象
        V v=null;
       try{
            v = clazz.newInstance();

           BeanUtils.copyProperties(source,v);
       }catch (Exception e){
           e.printStackTrace();
       }
        //返回目标结果
        return v;
    }

    public static<V,O>List<V> copyBeanList(List<O> list, Class<V>clazz){
        return  list.stream()
                .map(o -> copyBean(o, clazz))
                .collect(Collectors.toList());
    }
}
