package cn.yupcd.web.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginHandlerInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Object user = request.getSession().getAttribute("loginUser");
		if (user == null) {
			request.setAttribute("msg", "No permission, please login");
			request.getRequestDispatcher("/").forward(request, response);
			return false;
		} else {
			return true;
		}
	}
}
