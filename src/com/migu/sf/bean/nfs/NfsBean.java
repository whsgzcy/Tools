package com.migu.sf.bean.nfs;

import java.util.ArrayList;
import java.util.List;

public class NfsBean {

//	#check_nfs: 6 session
//	yes
//
//	#over_nfs:6 session

	/**
	 * 存储 df 标题
	 */
	static List<String> mTitlesName = new ArrayList<String>() {
		{
			add("IP");
			add("nfs");
		}
	};

	public static List<String> geiTitles() {
		return mTitlesName;
	}

	public static String n_yes = "yes";
	public static String n_no = "no";

	List<Nfs> nfs = new ArrayList<>();

	public List<Nfs> getNfs() {
		return nfs;
	}

	public void setNfs(List<Nfs> nfs) {
		this.nfs = nfs;
	}

	public static class Nfs {

		String ip;
		
		String nfs;

		public String getIp() {
			return ip;
		}

		public void setIp(String ip) {
			this.ip = ip;
		}

		public String getNfs() {
			return nfs;
		}

		public void setNfs(String nfs) {
			this.nfs = nfs;
		}
		
		

	}

}