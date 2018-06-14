package com.liuxun.cloud;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class PreZuulFilter extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(PreZuulFilter.class);

    @Override
    public String filterType() { // filter的具体类型pre、routing、post、error
        return "pre";
    }

    @Override
    public int filterOrder() { // 设置过滤器的顺序，数字越大越靠后
        return 1;
    }

    @Override
    public boolean shouldFilter() { // 设置是否启用该过滤器，设置为true才能起作用
        return true;
    }

    @Override
    public Object run() { //
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        String host = request.getRemoteHost();
        logger.info("请求的host：{}",host);
        return null;
    }
}