package com.xk.chapter1;

import java.util.Arrays;

/**
 * 有一组N个数，确定第K个最小者
 * 
 * @author X.Sation
 *
 */
public class No1_1_1 {

	public static void main(String[] args) {
		int k = 100000;
		int datas[] = new int[10000000];
		for (int i = 0; i < datas.length; i++) {
			datas[i] = i;
		}

		System.out.println(method1(datas, k));
		System.out.println(method2(datas, k));

	}

	/**
	 * 方法一，对数组进行排序，return第k个数
	 * 
	 * @param datas
	 * @return
	 */
	public static int method1(int[] datas, int k) {
		long start = System.currentTimeMillis();
		Arrays.sort(datas);
		System.out.println("method1:" + (System.currentTimeMillis() - start));
		return datas[k - 1];
	}

	/**
	 * 方法二： 1.将k个数放到数组中进行排序 2.遍历其余的数字，如果大于新数组的最后一个，就舍弃，否则插入，最后return新数组的最后一位
	 * 
	 * @param datas
	 * @return
	 */
	public static int method2(int[] datas, int k) {
		long start = System.currentTimeMillis();
		int newDatas[] = new int[k];
		for (int i = 0; i < newDatas.length; i++) {
			newDatas[i] = datas[i];
		}
		Arrays.sort(newDatas);
		for (int i = newDatas.length; i < datas.length; i++) {
			if (datas[i] < newDatas[newDatas.length - 1])
				// 插入到数组中
				insertToArray(datas[i], newDatas);
		}
		System.out.println("method2:" + (System.currentTimeMillis() - start));
		return newDatas[newDatas.length - 1];
	}

	/**
	 * 将某个数字插入到一个递增数组中
	 */
	public static void insertToArray(int a, int[] datas) {
		for (int i = 0; i < datas.length; i++) {
			if (a < datas[i]) {
				// 开始插
				for (int j = datas.length - 1; j > i; j--) {
					datas[j] = datas[j - 1];
				}
				return;
			}
		}
	}

	public int[] m(){
		return new int[10];
	}
}
