package com.sgitg.app.core.oauth2.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.filter.OncePerRequestFilter;

/**
 * 基于OAuth2.0协议的登录拦截过滤器实现,支持会话注销功能
 * 
 * @author xkxu
 */
public abstract class BaseAuthenticationFilter extends OncePerRequestFilter {

	public BaseAuthenticationFilter() {
		
	}

	@Override
	protected String getAlreadyFilteredAttributeName() {
		return BaseAuthenticationFilter.class.getName() + OncePerRequestFilter.ALREADY_FILTERED_SUFFIX;
	}

	@Override
	protected void initFilterBean() throws ServletException {
		super.initFilterBean();
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		filterChain.doFilter(request, response);
	}

	public static String getAccessToken(HttpServletRequest request, String accessTokenAttrName) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			return (String) session.getAttribute(accessTokenAttrName);
		}
		return null;
	}
	
	public enum AuthType {
		
		ISC_SSO(1, "统一权限单点登录"), 
		ISC_AUTHAPI(2, "统一权限接口认证"),
		WX_QRCODE(3, "企业微信扫码登录"), 
		PL_QRCODE(4, "融合平台扫码登录");

		private final int type;

		private final String desc;

		private AuthType(int type, String desc) {
			this.type = type;
			this.desc = desc;
		}

		public int getType() {
			return type;
		}

		public String getDesc() {
			return desc;
		}
	}
}
