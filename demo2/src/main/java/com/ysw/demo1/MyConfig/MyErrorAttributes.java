package com.ysw.demo1.MyConfig;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by ysw on 2019/4/9.
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = new LinkedHashMap();
        Map map = (Map) requestAttributes.getAttribute("ext1", 0);
        errorAttributes.put("ext1", map);
        return errorAttributes;
    }
}
