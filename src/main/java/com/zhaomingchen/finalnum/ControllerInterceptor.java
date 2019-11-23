package com.zhaomingchen.finalnum;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @ClassName: ControllerInterceptor 
 * @Description: 定义加强类
 * @author:李英华
 * @date: 2019年11月21日 下午3:23:56
 */
@ControllerAdvice

public class ControllerInterceptor {

	

	@ExceptionHandler(CmsException.class)

	@ResponseBody

	public MsgResult  interceptorException(CmsException excetion) {

		System.out.println(" 错误是 "  + excetion);

		return new MsgResult(100,excetion.getMessage(),null);

	}	

	

	@ExceptionHandler(CmcExceptionHtml.class)

	public ModelAndView  interceptorExceptionHtml(CmcExceptionHtml excetion) {

		

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("error");// 跳转到jsp

		modelAndView.addObject("errorInfo", excetion.getMessage());

		return modelAndView;

		

		

	}	

	

	

}
