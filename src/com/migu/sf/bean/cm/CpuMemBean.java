package com.migu.sf.bean.cm;

import java.util.ArrayList;
import java.util.List;

public class CpuMemBean {

	// Mem: 2695624K used, 1246152K free, 6180K shrd, 144604K buff, 1709424K
	// cached
	// CPU: 0.0% usr 0.0% sys 0.0% nic 100% idle 0.0% io 0.0% irq 0.0% sirq
	// Load average: 1.00 1.00 1.00 1/685 15405
	// PID PPID USER STAT VSZ %VSZ CPU %CPU COMMAND
	// 17985 17841 system S < 2341m 60.8 4 0.0 system_server
	// 18610 17841 system S 2061m 53.5 4 0.0 {migu.controller}
	// com.migu.controller
	// 18971 17841 u0_a32 S 2050m 53.2 5 0.0 {droid.gallery3d}
	// com.android.gallery3d
	// 17841 1 root S 2035m 52.8 4 0.0 {main} zygote64
	// 18456 17841 u0_a8 S 1771m 46.0 4 0.0 {ndroid.launcher}
	// com.android.launcher
	// 18234 17841 u0_a17 S 1738m 45.1 5 0.0 {ndroid.systemui}
	// com.android.systemui

	/**
	 * 存储 df 标题
	 */
	static List<String> mTitlesName = new ArrayList<String>() {
		{
			add("IP");
			add("Mem used");
			add("Mem free");
			add("Mem shrd");
			add("Mem buff");
			add("Mem cached");

			add("CPU usr");
			add("CPU sys");
			add("CPU nic");
			add("CPU idle");
			add("CPU io");
			add("CPU irq");
			add("CPU sirq");
		}
	};

	public static List<String> geiTitles() {
		return mTitlesName;
	}

	public static String cm_mem = "Mem";
	public static String cm_cpu = "CPU";

	List<CpuMem> cm = new ArrayList<>();
	
	public List<CpuMem> getCm() {
		return cm;
	}

	public void setCm(List<CpuMem> cm) {
		this.cm = cm;
	}
	
	public static class CpuMem {

		String ip;

		String mem_used;
		String mem_free;
		String mem_shrd;
		String mem_buff;
		String mem_cached;

		String cpu_usr;
		String cpu_sys;
		String cpu_nic;
		String cpu_idle;
		String cpu_io;
		String cpu_irq;
		String cpu_sirq;

		public String getIp() {
			return ip;
		}

		public void setIp(String ip) {
			this.ip = ip;
		}

		public String getMem_used() {
			return mem_used;
		}

		public void setMem_used(String mem_used) {
			this.mem_used = mem_used;
		}

		public String getMem_free() {
			return mem_free;
		}

		public void setMem_free(String mem_free) {
			this.mem_free = mem_free;
		}

		public String getMem_shrd() {
			return mem_shrd;
		}

		public void setMem_shrd(String mem_shrd) {
			this.mem_shrd = mem_shrd;
		}

		public String getMem_buff() {
			return mem_buff;
		}

		public void setMem_buff(String mem_buff) {
			this.mem_buff = mem_buff;
		}

		public String getMem_cached() {
			return mem_cached;
		}

		public void setMem_cached(String mem_cached) {
			this.mem_cached = mem_cached;
		}

		public String getCpu_usr() {
			return cpu_usr;
		}

		public void setCpu_usr(String cpu_usr) {
			this.cpu_usr = cpu_usr;
		}

		public String getCpu_sys() {
			return cpu_sys;
		}

		public void setCpu_sys(String cpu_sys) {
			this.cpu_sys = cpu_sys;
		}

		public String getCpu_nic() {
			return cpu_nic;
		}

		public void setCpu_nic(String cpu_nic) {
			this.cpu_nic = cpu_nic;
		}

		public String getCpu_idle() {
			return cpu_idle;
		}

		public void setCpu_idle(String cpu_idle) {
			this.cpu_idle = cpu_idle;
		}

		public String getCpu_io() {
			return cpu_io;
		}

		public void setCpu_io(String cpu_io) {
			this.cpu_io = cpu_io;
		}

		public String getCpu_irq() {
			return cpu_irq;
		}

		public void setCpu_irq(String cpu_irq) {
			this.cpu_irq = cpu_irq;
		}

		public String getCpu_sirq() {
			return cpu_sirq;
		}

		public void setCpu_sirq(String cpu_sirq) {
			this.cpu_sirq = cpu_sirq;
		}

	}

}