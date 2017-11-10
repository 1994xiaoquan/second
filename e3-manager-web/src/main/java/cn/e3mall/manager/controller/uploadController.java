package cn.e3mall.manager.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.e3mall.utils.FastDFSClient;
import cn.e3mall.utils.JsonUtils;
import cn.e3mall.utils.PictureResult;

/**
 * 上传文件的表现层代码
 * @author 99568
 *
 */
@Controller
public class uploadController {
	//注入
	@Value("${IMAGE_ADDRESS_CONSTANT}")
	private String  IMAGE_ADDRESS_CONSTANT;
	/*
	 * 上传图片的异步请求方法
	 * 注意上传的参数是:MultipartFile类型,可以获得上传的图片的名字和后缀
	 */
	@RequestMapping("/pic/upload")
	@ResponseBody
	public String uploadPicture(MultipartFile uploadFile){
		String name = uploadFile.getOriginalFilename();
		//得到文件类型
		String hname = name.substring(name.lastIndexOf(".")+1);
		//使用工具类上传
		FastDFSClient fs = null;
		try {
			fs = new FastDFSClient("classpath:client.conf");
			String url = fs.uploadFile(uploadFile.getBytes(), hname);
			//拼接完整的路径(在表单提交时需要提交这个路径到数据库中)
			url ="http://"+ IMAGE_ADDRESS_CONSTANT+"/"+url;
			PictureResult result = new PictureResult(0,url);
			//把对象转换成json格式
			String picjson = JsonUtils.objectToJson(result);
			return picjson;
		} catch (Exception e) {
			e.printStackTrace();
			PictureResult result =new PictureResult(1,null);
			result.setMessage("上传失败!");
			String picjson = JsonUtils.objectToJson(result);
			return picjson;
		}		
	}
}
