package com.hbst.basessm_1.util.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * fmt字符集过滤器（在web.xml中有配置）
 * @author Dean 20160818
 *
 */
public class SetCharacterEncodingFilter implements Filter {

	public void destroy() {
	}

	/**
	 * 实现将所有的请求都转换为utf-8以解决乱码问题
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		chain.doFilter(request,response);
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}
