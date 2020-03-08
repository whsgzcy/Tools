package com.migu.sf.bean.df;

import java.util.ArrayList;
import java.util.List;

public class DFBean {

	// Filesystem Size Used Free Blksize
	// / 1.9G 2.8M 1.9G 4096
	// /dev 1.9G 28.0K 1.9G 4096
	// /dev/graphics/fb0 1.9G 36.0K 1.9G 4096
	// /data 27.2G 9.6G 17.6G 4096
	// /system 991.9M 830.6M 161.3M 4096
	// /sys/fs/cgroup 1.9G 0.0K 1.9G 4096
	// /mnt 1.9G 0.0K 1.9G 4096
	// /subin 1.9G 160.0K 1.9G 4096
	// /storage 1.9G 0.0K 1.9G 4096
	// /mnt/runtime/default/emulated 27.2G 9.6G 17.6G 4096
	// /storage/emulated 27.2G 9.6G 17.6G 4096
	// /mnt/runtime/read/emulated 27.2G 9.6G 17.6G 4096
	// /mnt/runtime/write/emulated 27.2G 9.6G 17.6G 4096
	// /data/nfs 1426.6G 21.8G 1404.8G 1048576

	/**
	 * 存储 df 标题
	 */
	public static List<String> mTitlesName = new ArrayList<String>() {
		{
			add("IP");
			add("Filesystem");
			add("Size");
			add("Used");
			add("Free");
			add("Blksize");
		}
	};
	
	public static List<String> geiTitles(){
		return mTitlesName;
	}

	public static String f_ = "/";
	public static String f_dev = "/dev";
	public static String f_dev_graphics_fb0 = "/dev/graphics/fb0";
	public static String f_data = "/data";
	public static String f_system = "/system";
	public static String f_sys_fs_cgroup = "/sys/fs/cgroup";
	public static String f_mnt = "/mnt";
	public static String f_subin = "/subin";
	public static String f_storage = "/storage";
	public static String f_mnt_runtime_default_emulated = "/mnt/runtime/default/emulated";
	public static String f_storage_emulated = "/storage/emulated";
	public static String f_mnt_runtime_read_emulated = "/mnt/runtime/read/emulated";
	public static String f_mnt_runtime_write_emulated = "/mnt/runtime/write/emulated";
	public static String f_data_nfs = "/data/nfs";

	// <"/dev",List<Object>>
	// ["10.109.1.1","/","1.9G","2.8M","1.9G","4096"],["10.109.1.2","/","1.9G","2.8M","1.9G","4096"]

	List<DF> df_ = new ArrayList<>();

	List<DF> df_dev = new ArrayList<>();

	List<DF> df_dev_graphics_fb0 = new ArrayList<>();

	List<DF> df_data = new ArrayList<>();

	List<DF> df_system = new ArrayList<>();

	List<DF> df_sys_fs_cgroup = new ArrayList<>();

	List<DF> df_mnt = new ArrayList<>();

	List<DF> df_subin = new ArrayList<>();

	List<DF> df_storage = new ArrayList<>();

	List<DF> df_mnt_runtime_default_emulated = new ArrayList<>();

	List<DF> df_storage_emulated = new ArrayList<>();

	List<DF> df_mnt_runtime_read_emulated = new ArrayList<>();

	List<DF> df_mnt_runtime_write_emulated = new ArrayList<>();

	List<DF> df_data_nfs = new ArrayList<>();

	public List<DF> getDf_() {
		return df_;
	}

	public void setDf_(List<DF> df_) {
		this.df_ = df_;
	}

	public List<DF> getDf_dev() {
		return df_dev;
	}

	public void setDf_dev(List<DF> df_dev) {
		this.df_dev = df_dev;
	}

	public List<DF> getDf_dev_graphics_fb0() {
		return df_dev_graphics_fb0;
	}

	public void setDf_dev_graphics_fb0(List<DF> df_dev_graphics_fb0) {
		this.df_dev_graphics_fb0 = df_dev_graphics_fb0;
	}

	public List<DF> getDf_data() {
		return df_data;
	}

	public void setDf_data(List<DF> df_data) {
		this.df_data = df_data;
	}

	public List<DF> getDf_system() {
		return df_system;
	}

	public void setDf_system(List<DF> df_system) {
		this.df_system = df_system;
	}

	public List<DF> getDf_sys_fs_cgroup() {
		return df_sys_fs_cgroup;
	}

	public void setDf_sys_fs_cgroup(List<DF> df_sys_fs_cgroup) {
		this.df_sys_fs_cgroup = df_sys_fs_cgroup;
	}

	public List<DF> getDf_mnt() {
		return df_mnt;
	}

	public void setDf_mnt(List<DF> df_mnt) {
		this.df_mnt = df_mnt;
	}

	public List<DF> getDf_subin() {
		return df_subin;
	}

	public void setDf_subin(List<DF> df_subin) {
		this.df_subin = df_subin;
	}

	public List<DF> getDf_storage() {
		return df_storage;
	}

	public void setDf_storage(List<DF> df_storage) {
		this.df_storage = df_storage;
	}

	public List<DF> getDf_mnt_runtime_default_emulated() {
		return df_mnt_runtime_default_emulated;
	}

	public void setDf_mnt_runtime_default_emulated(List<DF> df_mnt_runtime_default_emulated) {
		this.df_mnt_runtime_default_emulated = df_mnt_runtime_default_emulated;
	}

	public List<DF> getDf_storage_emulated() {
		return df_storage_emulated;
	}

	public void setDf_storage_emulated(List<DF> df_storage_emulated) {
		this.df_storage_emulated = df_storage_emulated;
	}

	public List<DF> getDf_mnt_runtime_read_emulated() {
		return df_mnt_runtime_read_emulated;
	}

	public void setDf_mnt_runtime_read_emulated(List<DF> df_mnt_runtime_read_emulated) {
		this.df_mnt_runtime_read_emulated = df_mnt_runtime_read_emulated;
	}

	public List<DF> getDf_mnt_runtime_write_emulated() {
		return df_mnt_runtime_write_emulated;
	}

	public void setDf_mnt_runtime_write_emulated(List<DF> df_mnt_runtime_write_emulated) {
		this.df_mnt_runtime_write_emulated = df_mnt_runtime_write_emulated;
	}

	public List<DF> getDf_data_nfs() {
		return df_data_nfs;
	}

	public void setDf_data_nfs(List<DF> df_data_nfs) {
		this.df_data_nfs = df_data_nfs;
	}

	public static class DF {

		String ip;
		String filesystem;
		String size;
		String used;
		String free;
		String blksize;

		public String getIp() {
			return ip;
		}

		public void setIp(String ip) {
			this.ip = ip;
		}

		public String getFilesystem() {
			return filesystem;
		}

		public void setFilesystem(String filesystem) {
			this.filesystem = filesystem;
		}

		public String getSize() {
			return size;
		}

		public void setSize(String size) {
			this.size = size;
		}

		public String getUsed() {
			return used;
		}

		public void setUsed(String used) {
			this.used = used;
		}

		public String getFree() {
			return free;
		}

		public void setFree(String free) {
			this.free = free;
		}

		public String getBlksize() {
			return blksize;
		}

		public void setBlksize(String blksize) {
			this.blksize = blksize;
		}
	}
}