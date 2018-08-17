package com.wmp.common.config.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName: GlobalExceptionHandler
 * @Description: TODO(作为一个控制层的切面处理)
 * @author chenaonan
 * @date 2018年8月17日 下午1:41:38
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	public static final String DEFAULT_ERROR_VIEW = "error";

	@ExceptionHandler(Exception.class) // 所有的异常都是Exception子类
	public Object defaultErrorHandler(HttpServletRequest request, Exception e) {
		class ErrorInfo {
			private Integer code;
			private String message;
			private String url;

			@SuppressWarnings("unused")
			public Integer getCode() {
				return code;
			}

			public void setCode(Integer code) {
				this.code = code;
			}

			@SuppressWarnings("unused")
			public String getMessage() {
				return message;
			}

			public void setMessage(String message) {
				this.message = message;
			}

			@SuppressWarnings("unused")
			public String getUrl() {
				return url;
			}

			public void setUrl(String url) {
				this.url = url;
			}
		}
		ErrorInfo info = new ErrorInfo();
		info.setCode(500); // 标记一个错误信息类型
		info.setMessage(e.getMessage());
		info.setUrl(request.getRequestURL().toString());
		return info;
	}
}