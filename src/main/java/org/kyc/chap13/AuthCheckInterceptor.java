package org.kyc.chap13;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;


public class AuthCheckInterceptor implements HandlerInterceptor {

	static final Logger logger = LogManager.getLogger();


	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		HttpSession session = request.getSession();
		Object member = session.getAttribute("MEMBER");
		if (member != null)
			// 세션에 member가 있을 경우 계속 진행
			return true;

		// 세션에 member가 없을 경우 로그인 화면으로
		String requestURL = request.getRequestURL().toString();
		String queryString = request.getQueryString();
		String returnUrl = queryString == null ? requestURL
				: requestURL + "?" + queryString;
		logger.debug("returnUrl = {}", returnUrl);
		response.sendRedirect(request.getContextPath()
				+ "/app/loginForm?returnUrl=" + returnUrl);
		return false;
	}
}