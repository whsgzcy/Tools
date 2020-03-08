package com.migu.sf.handles.manager;

import java.util.ArrayList;
import java.util.List;

import com.migu.sf.util.StringUtil;

public class CheckResultManager {
	

//	--->*10.109.1.1* will start check
//
//	#check_df: 100 session
//	/system                991.9M   830.6M   161.3M   4096
//
//	#over_df:100 session
//
//	#check_df: 101 session
//	/dev                     1.9G    28.0K     1.9G   4096
//
//	#over_df:101 session
//
//	#check_df: 102 session
//	/dev/graphics/fb0        1.9G    36.0K     1.9G   4096
//
//	#over_df:102 session
//
//	#check_df: 103 session
//	/data                   27.2G     9.5G    17.7G   4096
//
//	#over_df:103 session
//
//	#check_df: 104 session
//	/                        1.9G     2.8M     1.9G   4096
//
//	#over_df:104 session
//
//	#check_df: 105 session
//	/sys/fs/cgroup           1.9G     0.0K     1.9G   4096
//
//	#over_df:105 session
//
//	#check_df: 106 session
//	/mnt                     1.9G     0.0K     1.9G   4096
//
//	#over_df:106 session
//
//	#check_df: 107 session
//	/subin                   1.9G   160.0K     1.9G   4096
//
//	#over_df:107 session
//
//	#check_df: 108 session
//	/storage                 1.9G     0.0K     1.9G   4096
//
//	#over_df:108 session
//
//	#check_df: 109 session
//	/mnt/runtime/default/emulated    27.2G     9.5G    17.7G   4096
//
//	#over_df:109 session
//
//	#check_df: 110 session
//	/storage/emulated       27.2G     9.5G    17.7G   4096
//
//	#over_df:110 session
//
//	#check_df: 111 session
//	/mnt/runtime/read/emulated    27.2G     9.5G    17.7G   4096
//
//	#over_df:111 session
//
//	#check_df: 112 session
//	/mnt/runtime/write/emulated    27.2G     9.5G    17.7G   4096
//
//	#over_df:112 session
//
//	#check_df: 113 session
//	/data/nfs             1426.6G    21.8G  1404.8G   1048576
//
//	#over_df:113 session
	
//	
//	#check_battery: 2 session
//	Current Battery Service state:
//	  AC powered: true
//	  USB powered: true
//	  Wireless powered: false
//	  Max charging current: 0
//	  status: 3
//	  health: 2
//	  present: true
//	  level: 100
//	  scale: 100
//	  voltage: 3
//	  temperature: 26
//	  technology: Li-ion
//
//	#over_battery:2 session
//	
//	#check_cpu_mem: 5 session
//	Mem: 2404916K used, 1536860K free, 6184K shrd, 144000K buff, 1583128K cached
//	CPU:  0.0% usr  1.6% sys  0.0% nic 98.3% idle  0.0% io  0.0% irq  0.0% sirq
//	Load average: 1.03 1.01 1.00 1/825 7497
//	  PID  PPID USER     STAT   VSZ %VSZ CPU %CPU COMMAND
//	  558   210 system   S <  2350m 61.0   4  0.0 system_server
//	19513   210 system   S    2059m 53.5   5  0.0 {migu.controller} com.migu.controller
//	  210     1 root     S    2035m 52.8   4  0.0 {main} zygote64
//	  900   210 u0_a8    S    1777m 46.1   0  0.0 {ndroid.launcher} com.android.launcher
//	  676   210 u0_a17   S    1737m 45.1   4  0.0 {ndroid.systemui} com.android.systemui
//	 1927   211 u0_a3002 S    1567m 40.7   3  0.0 {wser:PushClient} com.qihoo.browser:PushClient
//	 1088   210 system   S    1552m 40.3   1  0.0 com.migu.agent
//	  892   210 radio    S    1552m 40.3   5  0.0 {m.android.phone} com.android.phone
//	 1531   210 u0_a27   S    1545m 40.1   5  0.0 {droid.deskclock} com.android.deskclock
//	 1746   211 u0_a3002 S    1545m 40.1   5  0.0 {m.qihoo.browser} com.qihoo.browser
//	 5893   211 u0_a3002 S    1539m 39.9   2  0.0 {ser:pushbrowser} com.qihoo.browser:pushbrowser
//	 1015   210 u0_a48   S    1528m 39.7   4  0.0 {android.smspush} com.android.smspush
//	  211     1 root     S    1486m 38.6   5  0.0 {main} zygote
//	  862   211 u0_a15   S    1194m 31.0   3  0.0 {method.sogouoem} com.sohu.inputmethod.sogouoem
//	  703   211 u0_a2901 S    1041m 27.0   4  0.0 {e:xg_service_v4} com.ilongyuan.autochess.ly_pre:xg_service_v4
//	31897   211 u0_a2901 S    1031m 26.7   4  0.0 {utochess.ly_pre} com.ilongyuan.autochess.ly_pre
//	  975   211 u0_a51   S    1024m 26.6   4  0.0 {m.tencent.KiHan} com.tencent.KiHan
//	 4507   211 u0_a15   S    1022m 26.5   4  0.0 {em:push_service} com.sohu.inputmethod.sogouoem:push_service
//	 7246   211 u0_a51   S    1021m 26.5   3  0.0 {n:xg_service_v3} com.tencent.KiHan:xg_service_v3
//	  192     1 system   S <   297m  7.7   4  0.0 /system/bin/surfaceflinger
//	  204     1 media    S    56668  1.4   5  0.0 /system/bin/mediaserver
//	  199     1 root     S    19572  0.5   2  0.0 /system/bin/netd
//	  179     1 logd     S N  17280  0.4   5  0.0 /system/bin/logd


	// --->*10.109.1.1* will start check
	public static String getIP(String str) {

		if (StringUtil.isNullOrEmpty(str))
			return null;

		// 逻辑 稍微宽泛
		if (str.contains("--->") && str.contains("will start check")) {

			str = str.replace("--->", "");
			str = str.replace("will start check", "");
			str = str.replace("*", "");

			return str.trim();
		}

		return null;
	}

	// #check_df: num session
	public static int handleSession(String str) {

		if (StringUtil.isNullOrEmpty(str))
			return 0;
		
//		#check_df: 1 session  #磁盘大小
//		#check_battery: 2 session  #电量
//		#check_cpu: 3 session  #cpu
//		#check_realm_name: 4 session  #域名解析
//		#check_cpu_mem: 5 session  #cpu mem 使用率
//		#check_cpu_tmp: 6 session  #cpu 温度
//		#check_nfs: 7 session  #nfs检测
//		#check_internet: 8 session  #是否通外网
		
		// 逻辑 稍微宽泛
		if (str.contains("#check_") && str.contains("session")) {

			str = str.replace("#check_df:", "");
			str = str.replace("#check_battery:", "");
			str = str.replace("#check_cpu:", "");
			str = str.replace("#check_realm_name:", "");
			str = str.replace("#check_cpu_mem:", "");
			str = str.replace("#check_cpu_tmp:", "");
			str = str.replace("#check_nfs:", "");
			str = str.replace("#check_internet:", "");

			str = str.replace("session", "");

			return Integer.parseInt(str.trim());
		}

		return 0;

	}

	// #over_df:1 session
	public static int isCheckOver(String str){
		
		if (StringUtil.isNullOrEmpty(str))
			return 0;

		// 逻辑 稍微宽泛
		if (str.contains("#over_") && str.contains("session")) {

			//#over_df:1 session
			//#over_battery:2 session
			//#over_cpu:3 session
			//#over_realm_name:4 session
			//#over_cpu_mem:5 session
			//#over_cpu_tmp:6 session
			//#over_nfs:7 session
			//#over_internet:8 session
			str = str.replace("#over_df:", "");
			str = str.replace("#over_battery:", "");
			str = str.replace("#over_cpu:", "");
			str = str.replace("#over_realm_name:", "");
			str = str.replace("#over_cpu_mem:", "");
			str = str.replace("#over_cpu_tmp:", "");
			str = str.replace("#over_nfs:", "");
			str = str.replace("#over_internet:", "");
			str = str.replace("session", "");

			return Integer.parseInt(str.trim());
		}

		return 0;
	}
	
	//Filesystem###############Size#####Used#####Free###Blksize
	//Filesystem#Size#Used#Free#Blksize
	public static List<String> getStr4List(String str){
		if (StringUtil.isNullOrEmpty(str))
			return null;
		
		List<String> lists = new ArrayList<>();
		
		StringBuffer sb = new StringBuffer();
		
		char[] str_ = str.toCharArray();
		
		for(int i = 0; i < str.length(); i++){
			
			if(!(str_[i] + "").equals("#")){
				sb.append(str_[i]);
				continue;
			}
			
			if((str_[i] + "").equals("#")){
				if(i + 1 < str.length()){
					if(!(str_[i + 1] + "").equals("#")){
						sb.append("#");
					}
				}
			}
		}
				
	    String[] sbs = sb.toString().split("#");
	    
	    for(int i = 0; i < sbs.length; i++){
	    	
	    	if(!StringUtil.isNullOrEmpty(sbs[i].toString())){
	    		lists.add(sbs[i].trim());
	    	}
	    }
		
		return lists;
	}
	
	/**
	 * session 1 磁盘信息 细致处理
	 */
	
	// Filesystem               Size     Used     Free   Blksize
	public static List<String> getDfTitle(String str){
		if (StringUtil.isNullOrEmpty(str))
			return null;
				
		str = str.replace(" ", "#");
						
		return getStr4List(str);
	}
	
	/**
	 * session 2 电池信息 细致处理
	 */
	public static List<String> getBatteryInfo(String str){
		
		if (StringUtil.isNullOrEmpty(str))
			return null;
		
		if(str.contains(":")){
			
			List<String> lists = new ArrayList<>();
			String[] str_ = str.split(":");
			for(int i = 0; i < str_.length; i++){
				lists.add(str_[i]);
			}
			return lists;
		}
		
		return null;
	}
	
//	Mem: 2404916K used, 1536860K free, 6184K shrd, 144000K buff, 1583128K cached
	public static List<String> getMemInfo(String str){
		if (StringUtil.isNullOrEmpty(str))
			return null;
		
		str = str.replace("Mem:", "");
		str = str.replace("used", "");
		str = str.replace("free", "");
		str = str.replace("shrd", "");
		str = str.replace("buff", "");
		str = str.replace("cached", "");
		str = str.trim();
		
		String[] str_ = str.split(",");
		
	    List<String> lists = new ArrayList<>();
	    
	    for(int i = 0; i < str_.length; i++){
	    	
	    	lists.add(str_[i]);
	    }
		
		return lists;
	}
	
	//CPU:  0.0% usr  1.6% sys  0.0% nic 98.3% idle  0.0% io  0.0% irq  0.0% sirq
	public static List<String> getCPUInfo(String str){
		if (StringUtil.isNullOrEmpty(str))
			return null;
		
		str = str.replace("CPU:", "");
		str = str.replace("usr", "");
		str = str.replace("sys", "");
		str = str.replace("nic", "");
		str = str.replace("idle", "");
		str = str.replace("io", "");
		str = str.replace("sirq", "");
		str = str.replace("irq", "");
		str = str.trim();
		
		String[] str_ = str.split("%");
		
	    List<String> lists = new ArrayList<>();
	    
	    for(int i = 0; i < str_.length; i++){
	    	
	    	lists.add(str_[i] + "%");
	    }
		
		return lists;
	}
	
//	public static void main(String[] args) {
//
//		System.out.println(new CheckResultManager().getIP("--->*10.109.1.1* will start check"));
//		System.out.println(new CheckResultManager().handleDF("#check_df: 1 session"));
//		System.out.println(new CheckResultManager().isCheckOver("#over_df:1 session"));
//		System.out.println(new CheckResultManager().getDfTitle("#Filesystem               Size     Used     Free   Blksize#"));
//		System.out.println(new CheckResultManager().getDfTitle("/                        1.9G     2.8M     1.9G   4096"));
//		System.out.println(new CheckResultManager().getBatteryInfo("AC powered: true"));
//		System.out.println(new CheckResultManager().getMemInfo("Mem: 2404916K used, 1536860K free, 6184K shrd, 144000K buff, 1583128K cached"));
//		System.out.println(new CheckResultManager().getCPUInfo("CPU:  0.0% usr  1.6% sys  0.0% nic 98.3% idle  0.0% io  0.0% irq  0.0% sirq"));
//
//	}
}