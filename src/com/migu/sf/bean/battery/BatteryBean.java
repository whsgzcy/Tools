package com.migu.sf.bean.battery;

import java.util.ArrayList;
import java.util.List;

public class BatteryBean {

	// #check_battery: 2 session
	// Current Battery Service state:
	// AC powered: true
	// USB powered: true
	// Wireless powered: false
	// Max charging current: 0
	// status: 3
	// health: 2
	// present: true
	// level: 100
	// scale: 100
	// voltage: 3
	// temperature: 26
	// technology: Li-ion

	/**
	 * 存储 df 标题
	 */
	static List<String> mTitlesName = new ArrayList<String>() {
		{
			add("IP");
			add("AC powered");
			add("USB powered");
			add("Wireless powered");
			add("Max charging current");
			add("status");
			add("health");
			add("present");
			add("level");
			add("scale");
			add("voltage");
			add("temperature");
			add("technology");
		}
	};

	public static List<String> geiTitles() {
		return mTitlesName;
	}
	
	public static String b_ = "Current Battery Service state";

	public static String b_ac_powered = "AC powered";
	public static String b_usb_powered = "USB powered";
	public static String b_wireless_powered = "Wireless powered";
	public static String b_max_charging_current = "Max charging current";
	public static String b_status = "status";
	public static String b_health = "health";
	public static String b_present = "present";
	public static String b_level = "level";
	public static String b_scale = "scale";
	public static String b_voltage = "voltage";
	public static String b_temperature = "temperature";
	public static String b_technology = "technology";

	List<Battery> battery = new ArrayList<>();

	public List<Battery> getBattery() {
		return battery;
	}

	public void setBattery(List<Battery> battery) {
		this.battery = battery;
	}

	public static class Battery {

		String ip;
		String ac_powered;
		String usb_powered;
		String wireless_powered;
		String max_charging_current;
		String status;
		String health;
		String present;
		String level;
		String scale;
		String voltage;
		String temperature;
		String technology;
		public String getIp() {
			return ip;
		}
		public void setIp(String ip) {
			this.ip = ip;
		}
		public String getAc_powered() {
			return ac_powered;
		}
		public void setAc_powered(String ac_powered) {
			this.ac_powered = ac_powered;
		}
		public String getUsb_powered() {
			return usb_powered;
		}
		public void setUsb_powered(String usb_powered) {
			this.usb_powered = usb_powered;
		}
		public String getWireless_powered() {
			return wireless_powered;
		}
		public void setWireless_powered(String wireless_powered) {
			this.wireless_powered = wireless_powered;
		}
		public String getMax_charging_current() {
			return max_charging_current;
		}
		public void setMax_charging_current(String max_charging_current) {
			this.max_charging_current = max_charging_current;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getHealth() {
			return health;
		}
		public void setHealth(String health) {
			this.health = health;
		}
		public String getPresent() {
			return present;
		}
		public void setPresent(String present) {
			this.present = present;
		}
		public String getLevel() {
			return level;
		}
		public void setLevel(String level) {
			this.level = level;
		}
		public String getScale() {
			return scale;
		}
		public void setScale(String scale) {
			this.scale = scale;
		}
		public String getVoltage() {
			return voltage;
		}
		public void setVoltage(String voltage) {
			this.voltage = voltage;
		}
		public String getTemperature() {
			return temperature;
		}
		public void setTemperature(String temperature) {
			this.temperature = temperature;
		}
		public String getTechnology() {
			return technology;
		}
		public void setTechnology(String technology) {
			this.technology = technology;
		}
		
	}

}