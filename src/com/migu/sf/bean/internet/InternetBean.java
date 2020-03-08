package com.migu.sf.bean.internet;

import java.util.ArrayList;
import java.util.List;

public class InternetBean {

//	#check_internet: 4 session
//	realm_name:yes
//	online:yes
//
//	#over_internet:4 session

	/**
	 * 存储 df 标题
	 */
	static List<String> mTitlesName = new ArrayList<String>() {
		{
			add("IP");
			add("Realm Name");
			add("IsOnline");
		}
	};

	public static List<String> geiTitles() {
		return mTitlesName;
	}

	public static String i_realm_name = "realm_name";
	public static String i_online = "online";

	List<Internet> internet = new ArrayList<>();

	public List<Internet> getInternet() {
		return internet;
	}

	public void setInternet(List<Internet> internet) {
		this.internet = internet;
	}

	public static class Internet {

		String ip;
		String realm_name;
		String online;
		public String getIp() {
			return ip;
		}
		public void setIp(String ip) {
			this.ip = ip;
		}
		public String getRealm_name() {
			return realm_name;
		}
		public void setRealm_name(String realm_name) {
			this.realm_name = realm_name;
		}
		public String getOnline() {
			return online;
		}
		public void setOnline(String online) {
			this.online = online;
		}
	}

}