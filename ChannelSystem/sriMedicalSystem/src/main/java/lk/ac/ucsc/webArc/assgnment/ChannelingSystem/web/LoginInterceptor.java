package lk.ac.ucsc.webArc.assgnment.ChannelingSystem.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginInterceptor implements HandlerInterceptor {
    private static final String ERROR_HANDLING_REQUEST = "Error handling request";
    private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        try {
            String uri = request.getRequestURI();
            if (!uri.endsWith("/staffLogin")&&!uri.endsWith("/doctorLogin")&&!uri.endsWith("/selectUser")&&!uri.endsWith("/adminLogin")&& !uri.endsWith("/register")&& !uri.endsWith("/ChannelSystem/")&& !uri.endsWith("/login") && !uri.endsWith("/logout") && !uri.contains("/resources/") && !uri.endsWith("/invalidSession")) {
                if ((request.getSession().getAttribute("isAuthenticated") == null) || ((request.getSession().getAttribute("isAuthenticated") != null) && (!"true".equals(request.getSession().getAttribute("isAuthenticated"))))) {
                    response.sendRedirect("/ChannelSystem");
                    return false;
                }
            }

        } catch (Exception e) {
            throw new Exception(ERROR_HANDLING_REQUEST, e);

        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        logger.info("empty postHandle method was called");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        logger.info("empty afterCompletion method was called");
    }
}