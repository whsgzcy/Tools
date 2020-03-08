package com.migu.sf.handles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.migu.sf.bean.battery.BatteryBean;
import com.migu.sf.bean.battery.BatteryBean.Battery;
import com.migu.sf.bean.cm.CpuMemBean;
import com.migu.sf.bean.cm.CpuMemBean.CpuMem;
import com.migu.sf.bean.cpu.CpuBean;
import com.migu.sf.bean.cpu.CpuBean.Cpu;
import com.migu.sf.bean.df.DFBean;
import com.migu.sf.bean.df.DFBean.DF;
import com.migu.sf.bean.internet.InternetBean;
import com.migu.sf.bean.internet.InternetBean.Internet;
import com.migu.sf.bean.nfs.NfsBean;
import com.migu.sf.bean.nfs.NfsBean.Nfs;
import com.migu.sf.constant.Constants;
import com.migu.sf.handles.manager.CheckResultManager;
import com.migu.sf.util.StringUtil;

public class HandleCheckResultManagerService {

	/**
	 * 读取
	 * 
	 * @param filePath_
	 *            文件路径
	 * @return
	 */
	public static void handleCheckResult(String filePath_) {

		if (filePath_ == null) {
			System.out.println("filePath_ is null");
			return;
		}

		/**
		 * 读取方法
		 */
		// 定义文件对象,
		// 可以指定路径,这里用的时相对路径
		File file = new File(filePath_);

		if (!file.exists()) {
			System.out.println(filePath_ + " is not exit, please check check it,");
			return;
		}

		// 判断文件是否存在
		System.err.println(filePath_);

		try {
			// 1 创建文件输入流(字节流)
			FileInputStream fis = new FileInputStream(file);
			// 2 读取输入流(字符流)
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			// 3 缓冲读取InputStreamReader字节流
			BufferedReader br = new BufferedReader(isr);
			// 临时存放读取到的一行数据
			String line;
			// 开始读取
			// line等于读取到的一行数据,如果line读到的值不是空,说明还没有读完

			// 记录 当前处理的session
			int session = 0;
			String ip_ = null;

			// df session 100 ~ 113
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

			// battery session = 2
			List<Battery> batterys = new ArrayList<>();
			BatteryBean.Battery battery = new BatteryBean.Battery();
			
			//#check_cpu: 3 session
			List<Cpu> cpus = new ArrayList<>();
			CpuBean.Cpu cpu = new CpuBean.Cpu();
			
			//#check_internet: 4 session
			List<Internet> internets = new ArrayList<>();
			InternetBean.Internet internet = new InternetBean.Internet();
			
			//#check_cpu_mem: 5 session
			List<CpuMem> cms = new ArrayList<>();
			CpuMemBean.CpuMem cm = new CpuMemBean.CpuMem();
			
			//#check_nfs: 6 session
			List<Nfs> nfses = new ArrayList<>();
			NfsBean.Nfs nfs = new NfsBean.Nfs();

			while ((line = br.readLine()) != null) {

				String ip = CheckResultManager.getIP(line);

				if (ip != null) {
					System.out.println("handle ---> " + ip);
					// 指针下移两行
					// line = br.readLine();
					// line = br.readLine();
					ip_ = ip;
				}

				// session 100 ~ 113
				switch (CheckResultManager.handleSession(line)) {
				case 100:
					session = 100;
					break;
				case 101:
					session = 101;
					break;
				case 102:
					session = 102;
					break;
				case 103:
					session = 103;
					break;
				case 104:
					session = 104;
					break;
				case 105:
					session = 105;
					break;
				case 106:
					session = 106;
					break;
				case 107:
					session = 107;
					break;
				case 108:
					session = 108;
					break;
				case 109:
					session = 109;
					break;
				case 110:
					session = 110;
					break;
				case 111:
					session = 111;
					break;
				case 112:
					session = 112;
					break;
				case 113:
					session = 113;
					break;
				case 2:
					session = 2;
					break;
				case 3:
					session = 3;
					break;
				case 4:
					session = 4;
					break;
				case 5:
					session = 5;
					break;
				case 6:
					session = 6;
					break;
				}

				// 处理df部分
				if (session >= 100) {

					// 取正文
					if (!line.contains("session") && !StringUtil.isNullOrEmpty(line)) {

						List<String> lists = CheckResultManager.getDfTitle(line);

						if (lists != null && lists.size() == 5) {

							DFBean.DF df = new DFBean.DF();
							df.setIp(ip_);
							df.setSize(lists.get(1));
							df.setUsed(lists.get(2));
							df.setFree(lists.get(3));
							df.setBlksize(lists.get(4));

							switch (lists.get(0)) {
							case "/":
								df.setFilesystem(DFBean.f_);
								df_.add(df);
								break;
							case "/dev":
								df.setFilesystem(DFBean.f_dev);
								df_dev.add(df);
								break;
							case "/dev/graphics/fb0":
								df.setFilesystem(DFBean.f_dev_graphics_fb0);
								df_dev_graphics_fb0.add(df);
								break;
							case "/data":
								df.setFilesystem(DFBean.f_data);
								df_data.add(df);
								break;
							case "/system":
								df.setFilesystem(DFBean.f_system);
								df_system.add(df);
								break;
							case "/sys/fs/cgroup":
								df.setFilesystem(DFBean.f_sys_fs_cgroup);
								df_sys_fs_cgroup.add(df);
								break;
							case "/mnt":
								df.setFilesystem(DFBean.f_mnt);
								df_mnt.add(df);
								break;
							case "/subin":
								df.setFilesystem(DFBean.f_subin);
								df_subin.add(df);
								break;
							case "/storage":
								df.setFilesystem(DFBean.f_storage);
								df_storage.add(df);
								break;
							case "/mnt/runtime/default/emulated":
								df.setFilesystem(DFBean.f_mnt_runtime_default_emulated);
								df_mnt_runtime_default_emulated.add(df);
								break;
							case "/storage/emulated":
								df.setFilesystem(DFBean.f_storage_emulated);
								df_storage_emulated.add(df);
								break;
							case "/mnt/runtime/read/emulated":
								df.setFilesystem(DFBean.f_mnt_runtime_read_emulated);
								df_mnt_runtime_read_emulated.add(df);
								break;
							case "/mnt/runtime/write/emulated":
								df.setFilesystem(DFBean.f_mnt_runtime_write_emulated);
								df_mnt_runtime_write_emulated.add(df);
								break;
							case "/data/nfs":
								df.setFilesystem(DFBean.f_data_nfs);
								df_data_nfs.add(df);
								break;
							}

						}

					}
				}

				// 处理 #check_battery: 2 session
				if (session == 2) {

					// 取正文
					if (!line.contains(BatteryBean.b_) && !StringUtil.isNullOrEmpty(line)) {

						List<String> lists = CheckResultManager.getBatteryInfo(line);

						if (lists != null && lists.size() == 2) {

							String strSuffer = lists.get(0);

							if (strSuffer.contains(BatteryBean.b_ac_powered)) {
								battery = new BatteryBean.Battery();
								battery.setIp(ip_);
								battery.setAc_powered(lists.get(1));
							} else if (strSuffer.contains(BatteryBean.b_usb_powered)) {
								battery.setUsb_powered(lists.get(1));
							} else if (strSuffer.contains(BatteryBean.b_wireless_powered)) {
								battery.setWireless_powered(lists.get(1));
							} else if (strSuffer.contains(BatteryBean.b_max_charging_current)) {
								battery.setMax_charging_current(lists.get(1));
							} else if (strSuffer.contains(BatteryBean.b_status)) {
								battery.setStatus(lists.get(1));
							} else if (strSuffer.contains(BatteryBean.b_health)) {
								battery.setHealth(lists.get(1));
							} else if (strSuffer.contains(BatteryBean.b_present)) {
								battery.setPresent(lists.get(1));
							} else if (strSuffer.contains(BatteryBean.b_level)) {
								battery.setLevel(lists.get(1));
							} else if (strSuffer.contains(BatteryBean.b_scale)) {
								battery.setScale(lists.get(1));
							} else if (strSuffer.contains(BatteryBean.b_voltage)) {
								battery.setVoltage(lists.get(1));
							} else if (strSuffer.contains(BatteryBean.b_temperature)) {
								battery.setTemperature(lists.get(1));
							} else if (strSuffer.contains(BatteryBean.b_technology)) {
								battery.setTechnology(lists.get(1));
								batterys.add(battery);
							}

						}

					}
				}

				// 处理 #check_cpu: 3 session
				if (session == 3) {
					// 取正文
					if (line.contains("e:") && !StringUtil.isNullOrEmpty(line)) {

						List<String> lists = CheckResultManager.getBatteryInfo(line);

						if (lists != null && lists.size() == 2) {

							String strSuffer = lists.get(0);
							
							if(strSuffer.contains(CpuBean.c_attr)){
								cpu = new CpuBean.Cpu();
								cpu.setIp(ip_);
								cpu.setAttr(lists.get(1));
							}else if(strSuffer.contains(CpuBean.c_temperatue)){
								cpu.setTemperatue(lists.get(1));
								cpus.add(cpu);
							}
						}
					}
				}
				
				// 处理 #check_internet: 4 session
				if (session == 4) {
					// 取正文
					if (!line.contains("check") && line.contains(":") && !StringUtil.isNullOrEmpty(line)) {

						List<String> lists = CheckResultManager.getBatteryInfo(line);

						if (lists != null && lists.size() == 2) {

							String strSuffer = lists.get(0);
							
							if(strSuffer.contains(InternetBean.i_realm_name)){
								internet = new InternetBean.Internet();
								internet.setIp(ip_);
								internet.setRealm_name(lists.get(1));
							}else if(strSuffer.contains(InternetBean.i_online)){
								internet.setOnline(lists.get(1));
								internets.add(internet);
							}
						}
					}
				}
				
				// 处理 #check_cpu_mem: 5 session
				if (session == 5) {
					// 取正文
					if (!line.contains("check") && line.contains(":") && !StringUtil.isNullOrEmpty(line)) {
						
						if(line.contains(CpuMemBean.cm_mem)){
							cm = new CpuMemBean.CpuMem();
							cm.setIp(ip_);
							
							List<String> lists = CheckResultManager.getMemInfo(line);
							// Mem: 2695624K used, 1246152K free, 6180K shrd, 144604K buff, 1709424K cached
							if(lists != null && lists.size() == 5){
								cm.setMem_used(lists.get(0));
								cm.setMem_free(lists.get(1));
								cm.setMem_shrd(lists.get(2));
								cm.setMem_buff(lists.get(3));
								cm.setMem_cached(lists.get(4));
							}
							
							
						}else if(line.contains(CpuMemBean.cm_cpu)){
							List<String> lists = CheckResultManager.getCPUInfo(line);
							// CPU:  0.0% usr  0.0% sys  0.0% nic  100% idle  0.0% io  0.0% irq  0.0% sirq
							if(lists != null && lists.size() == 7){
								cm.setCpu_usr(lists.get(0));
								cm.setCpu_sys(lists.get(1));
								cm.setCpu_nic(lists.get(2));
								cm.setCpu_idle(lists.get(3));
								cm.setCpu_io(lists.get(4));
								cm.setCpu_irq(lists.get(5));
								cm.setCpu_sirq(lists.get(6));
								
								cms.add(cm);
							}
						}

					}
				}
				
				// 处理 #check_nfs: 6 session
				if(session == 6){
					// 取正文
					if (!line.contains("check") && !StringUtil.isNullOrEmpty(line)) {
						
						if(line.contains(NfsBean.n_yes) || line.contains(NfsBean.n_no)){
							nfs = new NfsBean.Nfs();
							nfs.setIp(ip_);
							nfs.setNfs(line);
							nfses.add(nfs);
						}
						
					}
					
				}
			}

			System.out.println("over");
			
			Write2ExcelManagerService.getInstance().setDf_(df_);
			Write2ExcelManagerService.getInstance().setDf_dev(df_dev);
			Write2ExcelManagerService.getInstance().setDf_dev_graphics_fb0(df_dev_graphics_fb0);
			Write2ExcelManagerService.getInstance().setDf_data(df_data);
			Write2ExcelManagerService.getInstance().setDf_system(df_system);
			Write2ExcelManagerService.getInstance().setDf_sys_fs_cgroup(df_sys_fs_cgroup);
			Write2ExcelManagerService.getInstance().setDf_mnt(df_mnt);
			Write2ExcelManagerService.getInstance().setDf_subin(df_subin);
			Write2ExcelManagerService.getInstance().setDf_storage(df_storage);
			Write2ExcelManagerService.getInstance().setDf_mnt_runtime_default_emulated(df_mnt_runtime_default_emulated);
			Write2ExcelManagerService.getInstance().setDf_storage_emulated(df_storage_emulated);
			Write2ExcelManagerService.getInstance().setDf_mnt_runtime_read_emulated(df_mnt_runtime_read_emulated);
			Write2ExcelManagerService.getInstance().setDf_mnt_runtime_write_emulated(df_mnt_runtime_write_emulated);
			Write2ExcelManagerService.getInstance().setDf_data_nfs(df_data_nfs);

			Write2ExcelManagerService.getInstance().setBatterys(batterys);
			
			Write2ExcelManagerService.getInstance().setCpus(cpus);
			
			Write2ExcelManagerService.getInstance().setInternets(internets);
			
			Write2ExcelManagerService.getInstance().setCms(cms);
			
			Write2ExcelManagerService.getInstance().setNfses(nfses);

			// 关闭流,先打开流后关闭
			br.close();
			isr.close();
			fis.close();
			
			
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void handelDf(String str) {

	}

	void readLines(BufferedReader br) {

	}

//	public static void main(String[] args) {
//		handleCheckResult(Constants.FILE_PATH);
//	}

}
