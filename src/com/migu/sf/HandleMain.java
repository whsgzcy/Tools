package com.migu.sf;

import com.migu.sf.constant.Constants;
import com.migu.sf.handles.HandleCheckResultManagerService;
import com.migu.sf.handles.Write2ExcelManagerService;

public class HandleMain {
	
	public static void main(String[] args){
		
//		// 遍历 检查 未安装 脚本 文件
//		new HandleIsInstallService().start_();
		
		Write2ExcelManagerService.getInstance();
		
		HandleCheckResultManagerService.handleCheckResult(Constants.FILE_PATH);
		
		Write2ExcelManagerService.getInstance().write();
		
	}

}