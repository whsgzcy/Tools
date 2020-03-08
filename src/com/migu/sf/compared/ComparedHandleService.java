package com.migu.sf.compared;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ComparedHandleService {

	public static String PATH_A = "/Users/super_yu/Desktop/migu/compared/A.txt";
	public static String PATH_B = "/Users/super_yu/Desktop/migu/compared/B.txt";
	
	public static String A1 = "A1.txt";
	
	public static String PATH = "/Users/super_yu/Desktop/migu/compared/";


	// step 1 检查 文件中是否有重复的数据 并打印

	public List<String> checkIsHasRepeatingData(String path) {

		List<String> lists = FileUtils.read(path);

		if (lists == null || lists.isEmpty()) {
			System.out.println(path + " is null or empty");
			return null;
		}
		System.out.println(path + " counts = " + lists.size());

		boolean isRepeatingData = false;
		for (int i = 0; i < lists.size() - 1; i++) {

			String a = lists.get(i).trim();

			if (a == null || a.isEmpty()) {
				System.out.println(path + " has a blank space");
				return null;
			}

			for (int j = i + 1; j < lists.size(); j++) {

				String b = lists.get(j).trim();

				if (a.equals(b)) {
					isRepeatingData = true;
					System.out.println(path + " repeatingdata is " + a);
				}

			}
		}

		if (isRepeatingData) {
			System.out.println(path + " has repeating data");
			return null;
		}

		return lists;
	}

	// step 2比较两个数组 A 与 B 与之对应
	// 1、处理 将A中B部分删除 写入新的A1文件
	// 2、处理 打印 A 与 B共有文件的log 并打印个数
	// 3、处理 打印 A 与 B差异文件 即A中删除的对应行内容 并输出个数

	public void handleCompared(List<String> listA, List<String> listB) {

		if (listA == null || listA.isEmpty() || listB == null || listB.isEmpty())
			return;

		// 记录相同的部分 A 与 B 重合的部分
		List<String> list_a = new ArrayList<String>();
		List<String> listA1 = new ArrayList<String>();
		// 重合部分与B的差异 差异部分打印出来
		List<String> listB1 = new ArrayList<String>();

		for (int i = 0; i < listB.size(); i++) {

			for (int j = 0; j < listA.size(); j++) {

				if (listB.get(i).equals(listA.get(j))) {
					list_a.add(listB.get(i));
				}
			}
		}

		System.out.println("the same data counts = " + list_a.size());

		if (list_a.isEmpty()) {
			System.out.println("no same data");
			return;
		}

		listA1 = listA;

		for (Iterator<String> itA1 = listA1.iterator(); itA1.hasNext();) {
			String temp = itA1.next();
			for (int i = 0; i < list_a.size(); i++) {
				if (temp.equals(list_a.get(i)))
				{
					itA1.remove();
				}
			}
		}
		
		System.out.println("handled new A1 counts  = " + listA1.size());
		
		// A 与 B共有数据中 重合数据中 与 B的差异 输出
		if(list_a.size() != listB.size()){
			System.out.println("共有部分数据 并未完全重合与A");
			listB1 = listB;
			
			for (Iterator<String> itB1 = listB1.iterator(); itB1.hasNext();) {
				String temp = itB1.next();
				for (int i = 0; i < list_a.size(); i++) {
					if (temp.equals(list_a.get(i)))
					{
						itB1.remove();
					}
				}
			}		
			
			System.out.println("共有部分数据 并未完全重合与A counts = " + listB1.size());
			System.out.println("共有部分数据 并未完全重合与A ");
			
			for(int i = 0; i < listB1.size(); i++){
				System.out.println(listB1.get(i));
			}
		}
		
		FileUtils.write(A1, PATH, listA1, "");
	}

	public static void main(String[] args) {

		List<String> listsA = new ComparedHandleService().checkIsHasRepeatingData(PATH_A);
		List<String> listsB = new ComparedHandleService().checkIsHasRepeatingData(PATH_B);

		if (listsA == null || listsB == null)
			return;

		new ComparedHandleService().handleCompared(listsA, listsB);

	}

}
