package com.migu.sf.compared;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

	/**
	 * 读取
	 * @param filePath_ 文件路径
	 * @return
	 */
	public static List<String> read(String filePath_) {

		if (filePath_ == null) {
			System.out.println("filePath_ is null");
			return null;
		}

		List<String> lists = new ArrayList<>();

		/**
		 * 读取方法
		 */
		// 定义文件对象,
		// 可以指定路径,这里用的时相对路径
		File file = new File(filePath_);

		if (!file.exists()) {
			System.out.println(filePath_ + " is not exit, please check check it,");
			return null;
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
			while ((line = br.readLine()) != null) {
				// 输出一行数据
//				System.out.println(line);
				lists.add(line);
			}

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

		return lists;
	}

	/**
	 * 写入
	 * @param fileName 文件名称
	 * @param filePath 文件路径
	 * @param contents 传入写入lists
	 * @param msg 描述
	 */
	public static void write(String fileName, String filePath, List<String> contents, String msg) {
		/**
		 * 写入方法
		 */
		try {
			// 文件输出流
			// 新建文件对象
			// arg:新文件名,
			File newfile = new File(filePath + File.separator + fileName);
//			if (newfile.exists()) {
//				newfile.delete();
//			}
//
//			newfile.mkdirs()

			// 文件输出流,如果文件不存在,会自动创建这个文件(字节流),如果文件存在会被完全覆盖,
			// FileOutputStream(arg1:字符串或者文件名, arg2:true追加写入,false覆盖写入)
			FileOutputStream fos = new FileOutputStream(newfile, true);
			// 写入流(字符流)
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			// 缓冲写入
			BufferedWriter bw = new BufferedWriter(osw);

			if (contents == null || contents.size() == 0) {
				bw.write(msg + "\n");
				// 任务完成关闭流,先创建的后关闭
				bw.close();
				osw.close();
				fos.close();
				System.out.println("写入完成");
				return;
			}

			bw.write(msg + "\n");
			bw.write("total " + contents.size() + "\n");
			for (int i = 0; i < contents.size(); i++) {
				// 开始一行一行写入
				bw.write(contents.get(i) + "\n");
			}
			
			bw.close();
			osw.close();
			fos.close();
			System.out.println("写入完成");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
