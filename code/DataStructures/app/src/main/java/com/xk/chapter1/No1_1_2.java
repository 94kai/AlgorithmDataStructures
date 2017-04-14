package com.xk.chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个二维数组，每个元素为字母。给定一组单词，在数组中找到横、竖、斜组成的存在与单词组中的词。
 * 
 * @author X.Sation
 *
 */
public class No1_1_2 {
	static List<String> words = new ArrayList<String>();
	static char[][] form = { { 't', 'h', 'i', 's' }, { 'w', 'a', 't', 's' }, { 'o', 'a', 'h', 'g' },
			{ 'f', 'g', 'd', 't' } };
	static String s;

	public static void main(String[] args) {
		words.add("this");
		words.add("that");
		words.add("fat");
		words.add("one1");
		words.add("on4e");
		words.add("on4e");
		words.add("on34563e");
		words.add("on3456345e");
		words.add("on4564353e");
		words.add("on465e");
		words.add("456one");
		words.add("0one");
		words.add("8one");
		words.add("7one");
		words.add("6one");
		words.add("5one");
		words.add("4one");
		words.add("3one");
		words.add("2one");
		words.add("1one");
		words.add("one12");
		words.add("on34e");
		words.add("on3e");
		words.add("on2e");
		words.add("one3");
		words.add("on2e");
		words.add("one");
		words.add("one");
		words.add("one");
		words.add("one");
		words.add("one");
		words.add("one");
		words.add("one");
		words.add("one");
		words.add("one");
		words.add("one");
		words.add("one");
		words.add("one");
		words.add("one");
		words.add("one");
		words.add("one");
		words.add("one");
		words.add("two");
		words.add("three");
		words.add("four");
		 method1();
		method2();

	}

	/**
	 * 方法一，检查每一个有效三元组（行，列，方向）是否有单词存在
	 * 
	 */
	public static void method1() {
		long start = System.currentTimeMillis();

		// 行 有0 1 2 3
		int row = 3;
		// 列 有0 1 2 3
		int column = 3;
		// 方向 有0 1 2 3 4 5 6 7
		int direction = 7;

		for (int i = 0; i <= row; i++) {
			for (int j = 0; j <= column; j++) {
				for (int k = 0; k <= direction; k++) {
					queryWord(i, j, k);
				}
			}
		}
		System.out.println("method1:" + (System.currentTimeMillis() - start));
	}

	/**
	 * 通过三元组，求出所有该三元组的字母组合
	 * 
	 * @param i
	 * @param j
	 * @param k
	 */
	private static void queryWord(int i, int j, int k) {

		StringBuffer sb = new StringBuffer();
		switch (k) {
		case 0:
			for (int l = i; l >= 0; l--) {
				sb.append(form[l][j]);
				s = sb.toString();
				if (words.contains(s)) {
					System.out.println(sb);
				}
			}
			break;
		case 1:
			for (int l = i, l2 = j; l >= 0 && l2 < form[0].length; l--, l2++) {
				sb.append(form[l][l2]);
				s = sb.toString();
				if (words.contains(s)) {
					System.out.println(sb);
				}
			}
			break;
		case 2:
			for (int l = j; l < form[0].length; l++) {
				sb.append(form[i][l]);
				s = sb.toString();
				if (words.contains(s)) {
					System.out.println(sb);
				}
			}
			break;
		case 3:
			for (int l = i, l2 = j; l < form.length && l2 < form[0].length; l++, l2++) {
				sb.append(form[l][l2]);
				s = sb.toString();
				if (words.contains(s)) {
					System.out.println(sb);
				}
			}
			break;
		case 4:
			for (int l = i; l < form.length; l++) {
				sb.append(form[l][j]);
				s = sb.toString();
				if (words.contains(s)) {
					System.out.println(sb);
				}
			}
			break;
		case 5:
			for (int l = i, l2 = j; l < form.length && l2 >= 0; l++, l2--) {
				sb.append(form[l][l2]);
				s = sb.toString();
				if (words.contains(s)) {
					System.out.println(sb);
				}
			}
			break;
		case 6:
			for (int l = j; l >= 0; l--) {
				sb.append(form[i][l]);
				s = sb.toString();
				if (words.contains(s)) {
					System.out.println(sb);
				}
			}
			break;
		case 7:
			for (int l = i, l2 = j; l >= 0 && l2 >= 0; l--, l2--) {
				sb.append(form[l][l2]);
				String s = sb.toString();
				if (words.contains(s)) {
					System.out.println(sb);
				}
			}
			break;
		}
	}

	/**
	 * 方法二，检查每一个有效四元组（行，列，方向，字符长度）是否有单词存在
	 * 
	 */
	public static void method2() {
		long start = System.currentTimeMillis();
		// 行 有0 1 2 3
		int row = 3;
		// 列 有0 1 2 3
		int column = 3;
		// 方向 有0 1 2 3 4 5 6 7
		int direction = 7;

		int maxCount = 4;

		for (int i = 0; i <= row; i++) {
			for (int j = 0; j <= column; j++) {
				for (int k = 0; k <= direction; k++) {
					// for (int c = 1; c <= maxCount; c++) {
					// System.out.println(i+""+j+""+k+""+c);
					queryWord(i, j, k, maxCount);
					// }
				}
			}
		}
		System.out.println("method2:" + (System.currentTimeMillis() - start));

	}

	/**
	 * 通过四元组，求出所有该四元组的字母组合，相比于method1，该方法知道了最大的单词长度，对于长于它的单词，就不用比了
	 * 
	 * @param i
	 * @param j
	 * @param k
	 * @param c
	 */
	private static void queryWord(int i, int j, int k, int c) {

		StringBuffer sb = new StringBuffer();
		switch (k) {
		case 0:
			for (int l = i; l >= 0; l--) {
				
				sb.append(form[l][j]);
				s = sb.toString();
				if (words.contains(s)) {
					System.out.println(sb);
				}
				if (sb.length() >= c) {// 长度大于等于最大单词的长度了，直接干掉
					break;
				}
			}
			break;
		case 1:
			for (int l = i, l2 = j; l >= 0 && l2 < form[0].length; l--, l2++) {
				
				sb.append(form[l][l2]);
				s = sb.toString();
				if (words.contains(s)) {
					System.out.println(sb);
				}
				if (sb.length() >= c) {// 长度大于等于最大单词的长度了，直接干掉
					break;
				}
			}
			break;
		case 2:
			for (int l = j; l < form[0].length; l++) {
				
				sb.append(form[i][l]);
				s = sb.toString();
				if (words.contains(s)) {
					System.out.println(sb);
				}if (sb.length() >= c) {// 长度大于等于最大单词的长度了，直接干掉
					break;
				}
			}
			break;
		case 3:
			for (int l = i, l2 = j; l < form.length && l2 < form[0].length; l++, l2++) {
				
				sb.append(form[l][l2]);
				s = sb.toString();
				if (words.contains(s)) {
					System.out.println(sb);
				}if (sb.length() >= c) {// 长度大于等于最大单词的长度了，直接干掉
					break;
				}
			}
			break;
		case 4:
			for (int l = i; l < form.length; l++) {
				
				sb.append(form[l][j]);
				s = sb.toString();
				if (words.contains(s)) {
					System.out.println(sb);
				}if (sb.length() >= c) {// 长度大于等于最大单词的长度了，直接干掉
					break;
				}
			}
			break;
		case 5:
			for (int l = i, l2 = j; l < form.length && l2 >= 0; l++, l2--) {
				
				sb.append(form[l][l2]);
				s = sb.toString();
				if (words.contains(s)) {
					System.out.println(sb);
				}if (sb.length() >= c) {// 长度大于等于最大单词的长度了，直接干掉
					break;
				}
			}
			break;
		case 6:
			for (int l = j; l >= 0; l--) {
				
				sb.append(form[i][l]);
				s = sb.toString();
				if (words.contains(s)) {
					System.out.println(sb);
				}if (sb.length() >= c) {// 长度大于等于最大单词的长度了，直接干掉
					break;
				}
			}
			break;
		case 7:
			for (int l = i, l2 = j; l >= 0 && l2 >= 0; l--, l2--) {
				
				sb.append(form[l][l2]);
				String s = sb.toString();
				if (words.contains(s)) {
					System.out.println(sb);
				}if (sb.length() >= c) {// 长度大于等于最大单词的长度了，直接干掉
					break;
				}
			}
			break;
		}
	}
}
