package com.migu.sf.constant;

public class Constants {

	// #check_battery: 2 session #电量
	// #check_cpu: 3 session #cpu
	// #check_internet: 4 session #域名解析
	// #check_cpu_mem: 5 session #cpu mem 使用率
	// #check_nfs: 6 session #nfs检测

	// #check_df: 100 session
	// /system 991.9M 830.6M 161.3M 4096
	// #check_df: 101 session
	// /dev 1.9G 28.0K 1.9G 4096
	// #check_df: 102 session
	// /dev/graphics/fb0 1.9G 36.0K 1.9G 4096
	// #check_df: 103 session
	// /data 27.2G 9.5G 17.7G 4096
	// #check_df: 104 session
	// / 1.9G 2.8M 1.9G 4096
	// #check_df: 105 session
	// /sys/fs/cgroup 1.9G 0.0K 1.9G 4096
	// #check_df: 106 session
	// /mnt 1.9G 0.0K 1.9G 4096
	// #check_df: 107 session
	// /subin 1.9G 160.0K 1.9G 4096
	// #check_df: 108 session
	// /storage 1.9G 0.0K 1.9G 4096
	// #check_df: 109 session
	// /mnt/runtime/default/emulated 27.2G 9.5G 17.7G 4096
	// #check_df: 110 session
	// /storage/emulated 27.2G 9.5G 17.7G 4096
	// #check_df: 111 session
	// /mnt/runtime/read/emulated 27.2G 9.5G 17.7G 4096
	// #check_df: 112 session
	// /mnt/runtime/write/emulated 27.2G 9.5G 17.7G 4096
	// #check_df: 113 session
	// /data/nfs 1426.6G 21.8G 1404.8G 1048576

	/**
	 * 将df进行一次拆分 14个小项
	 */
	public static String CHECK_DF_100 = "#check_df: 100 session";
	public static String CHECK_DF_101 = "#check_df: 101 session";
	public static String CHECK_DF_102 = "#check_df: 102 session";
	public static String CHECK_DF_103 = "#check_df: 103 session";
	public static String CHECK_DF_104 = "#check_df: 104 session";
	public static String CHECK_DF_105 = "#check_df: 105 session";
	public static String CHECK_DF_106 = "#check_df: 106 session";
	public static String CHECK_DF_107 = "#check_df: 107 session";
	public static String CHECK_DF_108 = "#check_df: 108 session";
	public static String CHECK_DF_109 = "#check_df: 109 session";
	public static String CHECK_DF_110 = "#check_df: 110 session";
	public static String CHECK_DF_111 = "#check_df: 111 session";
	public static String CHECK_DF_112 = "#check_df: 112 session";
	public static String CHECK_DF_113 = "#check_df: 113 session";

	public static String CHECK_BATTERY = "#check_battery: 2 session";
	public static String CHECK_CPU = "#check_cpu: 3 session";
	public static String CHECK_REALM_NAME = "#check_internet: 4 session";
	public static String CHECK_CPU_MEM = "#check_cpu_mem: 5 session";
	public static String CHECK_NFS = "#check_nfs: 6 session";

	// --->*10.109.1.1* will start check
	public static String IP_SUFF = "will start check";

	public static String FILE_PATH = "/Users/super_yu/Desktop/migu/check/2020-01-07-log.out";

}