package com.migu.sf.handles;

import java.util.ArrayList;
import java.util.List;

import com.migu.sf.file.FileUtils;

public class HandleIsInstallService {

	// check_is_uninstalled_out.log
	// IP:10.109.1.1:has installed :com.migu.controller
	// IP:10.109.1.1:has not install :com.migu.controller
	// else

	/**
	 * 分三个文件输出 
	 * check_is_uninstalled_out_1.log 符合逻辑
	 * check_is_uninstalled_out_2.log 不符合逻辑 
	 * check_is_uninstalled_out_3.log else
	 */

	public void start_() {

		String path = "/Users/super_yu/Desktop/migu/uninstall/check_is_uninstalled_out.log";

		// 读取配置文件 以 list string 集合输出
		List<String> list = FileUtils.read(path);

		if (list == null || list.size() == 0) {
			System.out.println("please check check your file,");
			return;
		}

		List<String> handle1 = new ArrayList<>();
		List<String> handle2 = new ArrayList<>();
		List<String> handle3 = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {

			String a = list.get(i);

			if (a == null || a.isEmpty() || !a.contains(":")) {
				handle3.add(a);
				continue;
			}

			String[] b = a.split(":");

			if (b == null || b.length != 4) {
				handle3.add(a);
				continue;
			}

			if (a.contains("has installed")) {
				handle2.add(b[1] + " " + b[3]);
				continue;
			}

			if (a.contains("has not install")) {
				handle1.add(b[1] + " not " + b[3]);
				continue;
			}
		}
		
		FileUtils.write("check_is_uninstalled_out_1.log", "/Users/super_yu/Desktop/migu/uninstall", handle1, "正确安装");
		FileUtils.write("check_is_uninstalled_out_2.log", "/Users/super_yu/Desktop/migu/uninstall", handle2, "未安装");
		FileUtils.write("check_is_uninstalled_out_3.log", "/Users/super_yu/Desktop/migu/uninstall", handle3, "其他异常");

	}

}
