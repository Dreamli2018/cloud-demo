package cn.itcast.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
@Component
public class LoginFilter extends ZuulFilter {
    @Override
    public String filterType() {
        // 过滤的类型，在什么时候过滤，总共四种类型，pre，routing，post，error
        return "pre";
    }

    @Override
    public int filterOrder() {
        // 过滤执行的级别，正整数，值越低，级别越高
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        // 是否要执行过滤，ture表示过滤
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        // 过滤器实际过滤的内容
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String aClass = request.getParameter("class");
        if(aClass==null || aClass.trim().equals("")){
            // 请求参数中没有aClass，登陆校验失败，拦截
            currentContext.setSendZuulResponse(false);
            // 返回401状态码
            currentContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        return null;
    }
}
