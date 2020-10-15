package com.jk.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public class WebUtils {
    public static <T> T copyParamToBean(Map value,T t){
        try {
            BeanUtils.populate(t, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    public static int parseInt(String strInt,int defaultValue){
        try {
            if (strInt != null && !"".equals(strInt)){
                return Integer.parseInt(strInt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultValue;
    }

}
