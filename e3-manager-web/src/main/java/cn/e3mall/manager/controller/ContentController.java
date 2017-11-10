package cn.e3mall.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.content.service.ContentService;
import cn.e3mall.pojo.TbContent;
import cn.e3mall.utils.E3mallResult;
import cn.e3mall.utils.PageBeanResult;

@Controller
public class ContentController {
	@Autowired
	private ContentService contentService;
	/**
	 * 1.请求:/content/query/list
	 * 2.参数: Long categoryId,Integer page,Integer rows
	 * 3.返回值 :PageBean
	 * 4.订阅服务
	 */
	@RequestMapping("/content/query/list")
	@ResponseBody
	public PageBeanResult contentPage( Long categoryId,Integer page,Integer rows){
		return contentService.selectContentPage(categoryId, page, rows);
	}
	/**
	 * 1.请求:/content/save
	 * 2.参数: content
	 * 3.返回值: E3mallResult
	 * 
	 */
	@RequestMapping("/content/save")
	@ResponseBody
	public E3mallResult insertContent(TbContent content){
		return contentService.insertContent(content);
	}
}
