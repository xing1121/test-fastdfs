package com.sf.ibu.fastdfs.test;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

public class TestFastdfs {

	public static void main(String[] args) throws Exception {

		// 第一步:加载配置文件,配置文件中指定Trackerserver的位置.
		ClientGlobal .init("D:/DevSoft/luna-workspace/atguigu-fastdfs/src/main/resources/tracker.conf");
		// 第二步:创建一个TrackerClient对象.
		TrackerClient trackerClient = new TrackerClient();
		// 第三步:从TrackerClient中获得TrackerServer对象.
		TrackerServer trackerServer = trackerClient.getConnection();
		// 第四步:声明一个StorageServer的引用.
		StorageServer storageServer = null;
		// 第五步:创建StorageClient对象,需要两个参数TrackerServer对象,StorageServer
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		// 第六步:调用storageClient对象upload方法上传图片,返回图片的url.
		String[] strings = storageClient.upload_file("C:/Users/2x/Desktop/1.jpg", "jpg", null);
		// 第七步: 获取上传的路径
		String vurl = "";
		for (String string : strings) {
			System.out.println(string);
			vurl += "/"+string;
		}
		System.out.println(vurl);
	}
}