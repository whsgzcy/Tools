package com.migu.sf.handles;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

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

public class Write2ExcelManagerService {

	// #check_df: 100 session
	// #check_df: 101 session
	// #check_df: 102 session
	// #check_df: 103 session
	// #check_df: 104 session
	// #check_df: 105 session
	// #check_df: 106 session
	// #check_df: 107 session
	// #check_df: 108 session
	// #check_df: 109 session
	// #check_df: 110 session
	// #check_df: 111 session
	// #check_df: 112 session
	// #check_df: 113 session

	// #check_battery: 2 session

	// #check_cpu: 3 session

	// #check_internet: 4 session

	// #check_cpu_mem: 5 session

	// #check_nfs: 6 session

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

	// #check_cpu: 3 session
	List<Cpu> cpus = new ArrayList<>();

	// #check_internet: 4 session
	List<Internet> internets = new ArrayList<>();

	// #check_cpu_mem: 5 session
	List<CpuMem> cms = new ArrayList<>();

	// #check_nfs: 6 session
	List<Nfs> nfses = new ArrayList<>();

	private volatile static Write2ExcelManagerService mInstance = null;

	public static Write2ExcelManagerService getInstance() {

		if (mInstance == null) {
			synchronized (Write2ExcelManagerService.class) {
				mInstance = new Write2ExcelManagerService();
			}
		}
		return mInstance;
	}

	public void write() {

		System.out.println("will wirte to excel");

		HSSFWorkbook workbook = new HSSFWorkbook();

		/**
		 * 处理 df
		 */
		writeDf(workbook, df_, "df1表");
		writeDf(workbook, df_dev, "df2表");
		writeDf(workbook, df_dev_graphics_fb0, "df3表");
		writeDf(workbook, df_data, "df4表");
		writeDf(workbook, df_system, "df5表");
		writeDf(workbook, df_sys_fs_cgroup, "df6表");
		writeDf(workbook, df_mnt, "df7表");
		writeDf(workbook, df_subin, "df8表");
		writeDf(workbook, df_storage, "df9表");
		writeDf(workbook, df_storage_emulated, "df10表");
		writeDf(workbook, df_mnt_runtime_read_emulated, "df11表");
		writeDf(workbook, df_mnt_runtime_write_emulated, "df12表");
		writeDf(workbook, df_data_nfs, "df13表");
		
		/**
		 * #check_battery: 2 session
		 */
		HSSFSheet battery_sheet = workbook.createSheet("电池信息表");
		HSSFRow battery_row = battery_sheet.createRow(0);

		for (int i = 0; i < BatteryBean.geiTitles().size(); i++) {
			HSSFCell cell = battery_row.createCell(i);
			cell.setCellValue(BatteryBean.geiTitles().get(i));
		}

		for (int i = 0; i < batterys.size(); i++) {
			HSSFRow row1 = battery_sheet.createRow(i + 1);
			BatteryBean.Battery bb = batterys.get(i);
			// 创建单元格设值
			row1.createCell(0).setCellValue(bb.getIp());
			row1.createCell(1).setCellValue(bb.getAc_powered());
			row1.createCell(2).setCellValue(bb.getUsb_powered());
			row1.createCell(3).setCellValue(bb.getWireless_powered());
			row1.createCell(4).setCellValue(bb.getMax_charging_current());
			row1.createCell(5).setCellValue(bb.getStatus());
			row1.createCell(6).setCellValue(bb.getHealth());
			row1.createCell(7).setCellValue(bb.getPresent());
			row1.createCell(8).setCellValue(bb.getLevel());
			row1.createCell(9).setCellValue(bb.getScale());
			row1.createCell(10).setCellValue(bb.getVoltage());
			row1.createCell(11).setCellValue(bb.getTemperature());
			row1.createCell(12).setCellValue(bb.getTechnology());
			
		}
		System.out.println("write " + "电池信息表" + " finished");
		
		/**
		 * #check_cpu: 3 session
		 */
		HSSFSheet cpu_sheet = workbook.createSheet("cpu信息表");
		HSSFRow cpu_row = cpu_sheet.createRow(0);

		for (int i = 0; i < CpuBean.geiTitles().size(); i++) {
			HSSFCell cell = cpu_row.createCell(i);
			cell.setCellValue(CpuBean.geiTitles().get(i));
		}

		for (int i = 0; i < cpus.size(); i++) {
			HSSFRow row1 = cpu_sheet.createRow(i + 1);
			CpuBean.Cpu cc = cpus.get(i);
			// 创建单元格设值
			row1.createCell(0).setCellValue(cc.getIp());
			row1.createCell(1).setCellValue(cc.getAttr());
			row1.createCell(2).setCellValue(cc.getTemperatue());
			
		}
		System.out.println("write " + "cpu信息表" + " finished");
		
		/**
		 * #check_internet: 4 session
		 */
		HSSFSheet i_sheet = workbook.createSheet("网络表");
		HSSFRow i_row = i_sheet.createRow(0);

		for (int i = 0; i < InternetBean.geiTitles().size(); i++) {
			HSSFCell cell = i_row.createCell(i);
			cell.setCellValue(InternetBean.geiTitles().get(i));
		}

		for (int i = 0; i < internets.size(); i++) {
			HSSFRow row1 = i_sheet.createRow(i + 1);
			InternetBean.Internet ii = internets.get(i);
			// 创建单元格设值
			row1.createCell(0).setCellValue(ii.getIp());
			row1.createCell(1).setCellValue(ii.getRealm_name());
			row1.createCell(2).setCellValue(ii.getOnline());
			
		}
		System.out.println("write " + "网络表" + " finished");
		
		/**
		 * #check_cpu_mem: 5 session
		 */
		HSSFSheet cm_sheet = workbook.createSheet("内存 cpu 占用表");
		HSSFRow cm_row = cm_sheet.createRow(0);

		for (int i = 0; i < CpuMemBean.geiTitles().size(); i++) {
			HSSFCell cell = cm_row.createCell(i);
			cell.setCellValue(CpuMemBean.geiTitles().get(i));
		}

		for (int i = 0; i < cms.size(); i++) {
			HSSFRow row1 = cm_sheet.createRow(i + 1);
			CpuMemBean.CpuMem cm = cms.get(i);
			// 创建单元格设值
			row1.createCell(0).setCellValue(cm.getIp());
			row1.createCell(1).setCellValue(cm.getMem_used());
			row1.createCell(2).setCellValue(cm.getMem_free());
			row1.createCell(3).setCellValue(cm.getMem_shrd());
			row1.createCell(4).setCellValue(cm.getMem_buff());
			row1.createCell(5).setCellValue(cm.getMem_cached());
			row1.createCell(6).setCellValue(cm.getCpu_usr());
			row1.createCell(7).setCellValue(cm.getCpu_sys());
			row1.createCell(8).setCellValue(cm.getCpu_nic());
			row1.createCell(9).setCellValue(cm.getCpu_idle());
			row1.createCell(10).setCellValue(cm.getCpu_io());
			row1.createCell(11).setCellValue(cm.getCpu_irq());
			row1.createCell(12).setCellValue(cm.getCpu_sirq());
		}
		System.out.println("write " + "内存 cpu 占用表" + " finished");
		
		/**
		 * #check_nfs: 6 session
		 */
		HSSFSheet n_sheet = workbook.createSheet("nfs表");
		HSSFRow n_row = n_sheet.createRow(0);

		for (int i = 0; i < NfsBean.geiTitles().size(); i++) {
			HSSFCell cell = n_row.createCell(i);
			cell.setCellValue(NfsBean.geiTitles().get(i));
		}

		for (int i = 0; i < nfses.size(); i++) {
			HSSFRow row1 = n_sheet.createRow(i + 1);
			NfsBean.Nfs nf = nfses.get(i);
			// 创建单元格设值
			row1.createCell(0).setCellValue(nf.getIp());
			row1.createCell(1).setCellValue(nf.getNfs());
		}
		System.out.println("write " + "nfs表" + " finished");


		try {
			FileOutputStream fos = new FileOutputStream("/Users/super_yu/Desktop/migu/check/20201008.xls");
			workbook.write(fos);
			System.out.println("写入成功");
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	void writeDf(HSSFWorkbook workbook, List<DF> lists, String dfType) {

		HSSFSheet sheet = workbook.createSheet(dfType);
		DFBean.geiTitles();
		HSSFRow row = sheet.createRow(0);

		for (int i = 0; i < DFBean.geiTitles().size(); i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellValue(DFBean.geiTitles().get(i));
		}

		for (int i = 0; i < lists.size(); i++) {
			HSSFRow row1 = sheet.createRow(i + 1);
			DFBean.DF df = lists.get(i);
			// 创建单元格设值
			row1.createCell(0).setCellValue(df.getIp());
			row1.createCell(1).setCellValue(df.getFilesystem());
			row1.createCell(2).setCellValue(df.getSize());
			row1.createCell(3).setCellValue(df.getUsed());
			row1.createCell(4).setCellValue(df.getFree());
			row1.createCell(5).setCellValue(df.getBlksize());
		}

		System.out.println("write " + dfType + " finished");
	}


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

	public List<Battery> getBatterys() {
		return batterys;
	}

	public void setBatterys(List<Battery> batterys) {
		this.batterys = batterys;
	}

	public List<Cpu> getCpus() {
		return cpus;
	}

	public void setCpus(List<Cpu> cpus) {
		this.cpus = cpus;
	}

	public List<Internet> getInternets() {
		return internets;
	}

	public void setInternets(List<Internet> internets) {
		this.internets = internets;
	}

	public List<CpuMem> getCms() {
		return cms;
	}

	public void setCms(List<CpuMem> cms) {
		this.cms = cms;
	}

	public List<Nfs> getNfses() {
		return nfses;
	}

	public void setNfses(List<Nfs> nfses) {
		this.nfses = nfses;
	}

}