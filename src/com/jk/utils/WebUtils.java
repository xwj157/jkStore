package com.jk.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author xwj157
 * @create 2020-08-12 22:18
 */
public class WebUtils {
    public static <T> T copyParamToBean(HttpServletRequest request,T t){
        Map map = request.getParameterMap();
        try {
            BeanUtils.populate(t, map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return t;

    }

    public static int parseInt(String strInt,int defaultValue){
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultValue;
    }


}
