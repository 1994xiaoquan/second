package cn.e3mall.fastdfs;

import java.io.IOException;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import cn.e3mall.utils.FastDFSClient;

/*
 * 测试文件上传
 */
public class MyFastDfs {
	@Test
	public void uploadImage(){
		//配置文件地址需要指定
		String  clentconf= "F:\\项目二\\secondgithub\\e3-manager-web\\src\\main\\resources\\client.conf";
		//上传图片需要指定
		String pic = "C:\\Users\\99568\\Pictures\\lovewallpaper\\Taylor_Swift_-_Red.mp4";
		
		
		try {
			//加载客户端配置文件链接远程图片服务器
			ClientGlobal.init(clentconf);
			//创建调度服务器客户端的对象
			TrackerClient tClient = new TrackerClient();
			//从服务器客户端对象获取tracker服务调度对象
			TrackerServer trackerServer = tClient.getConnection();
			
			//创建存储stotage客户端对象
			StorageClient sClient = new StorageClient(trackerServer, null);
			
			//上传图片
			String[] url = sClient.upload_file(pic, "mp4",null);
			for (String string : url) {
				System.out.println(string);
			}
		} catch (IOException | MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void uploadImage2(){
		//配置文件地址需要指定
		String  clentconf= "F:\\项目二\\secondgithub\\e3-manager-web\\src\\main\\resources\\client.conf";
		//上传图片需要指定
		String pic = "C:\\Users\\99568\\Pictures\\lovewallpaper\\354489-106.jpg";
		try {
			FastDFSClient fs =new FastDFSClient(clentconf);
			String file = fs.uploadFile(pic, "jpg");
			System.out.println(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
