package com.migu.sf.bean.cpu;

import java.util.ArrayList;
import java.util.List;

public class CpuBean {
	
//	#check_cpu: 3 session
//	attribute:1416000
//	temperatue:32222
//
//	#over_cpu:3 session

		/**
		 * 存储 df 标题
		 */
		static List<String> mTitlesName = new ArrayList<String>() {
			{
				add("IP");
				add("Attr");
				add("Temperatue");
			}
		};

		public static List<String> geiTitles() {
			return mTitlesName;
		}
		
		public static String c_attr = "attribute";
		public static String c_temperatue = "temperatue";

		List<Cpu> cpu = new ArrayList<>();

		public List<Cpu> getCpu() {
			return cpu;
		}

		public void setCpu(List<Cpu> cpu) {
			this.cpu = cpu;
		}

		public static class Cpu {

			String ip;
			String attr;
			String temperatue;
			
			public String getIp() {
				return ip;
			}
			public void setIp(String ip) {
				this.ip = ip;
			}
			public String getAttr() {
				return attr;
			}
			public void setAttr(String attr) {
				this.attr = attr;
			}
			public String getTemperatue() {
				return temperatue;
			}
			public void setTemperatue(String temperatue) {
				this.temperatue = temperatue;
			}
		}
}