package com.dgq.algorithm;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Algorithm {


	public static int[] insertSort(int[] arr) {


		for (int i = 1; i < arr.length; i++) {

			for (int j = i; j > 0; j--) {
				int pre = arr[j-1];
				int aft = arr[j];
				if (aft < pre) {
					arr[j-1] = aft;
					arr[j] = pre;
				}
			}
		}

		return arr;
	}

	/**
	 * 归并排序
	 * 简介:将两个（或两个以上）有序表合并成一个新的有序表 即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列
	 * 时间复杂度为O(nlogn)
	 * 稳定排序方式
	 * @param nums 待排序数组
	 * @return 输出有序数组
	 */
	public static int[] sort(int[] nums, int low, int high) {
		int mid = (low + high) / 2;
		if (low < high) {
			//左边
			sort(nums, low, mid);
			//右边
			sort(nums, mid + 1, high);
			//左右归并
			merge(nums, low, mid, high);
		}
		return nums;
	}
	public static void merge(int[] nums, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];
		int i = low;// 左指针
		int j = mid + 1;// 右指针
		int k = 0;

		//把较小的数先移到新数组中
		while (i <= mid && j <= high) {
			if (nums[i] < nums[j]) {
				temp[k++] = nums[i++];
			} else {
				temp[k++] = nums[j++];
			}
		}

		//把左边剩余的数移入数组
		while (i <= mid) {
			temp[k++] = nums[i++];
		}

		//把右边边剩余的数移入数组
		while (j <= high) {
			temp[k++] = nums[j++];
		}

		//把新数组中的数覆盖nums数组
		for (int k2 = 0; k2 < temp.length; k2++) {
			nums[k2 + low] = temp[k2];
		}
	}

	//基数排序
	public static int[] radixSort(int[] A) {
		int loopNum = 0;
		int n = A.length;
		//首先确定排序的趟数;
		int max=A[0];
		for(int i=1;i<n;i++){
			loopNum++;
			if(A[i]>max){
				max=A[i];
			}
		}
		int time=0;
		//判断位数;
		while(max>0){
			loopNum++;
			max/=10;
			time++;
		}
		int length = n;
		int divisor = 1;// 定义每一轮的除数，1,10,100...
		int[][] bucket = new int[10][length];// 定义了10个桶，以防每一位都一样全部放入一个桶中
		int[] count = new int[10];// 统计每个桶中实际存放的元素个数
		int digit;// 获取元素中对应位上的数字，即装入那个桶
		for (int i = 1; i <= time; i++) {// 经过4次装通操作，排序完成
			loopNum++;
			for (int temp : A) {// 计算入桶
				loopNum++;
				digit = (temp / divisor) % 10;
				bucket[digit][count[digit]++] = temp;
			}
			int k = 0;// 被排序数组的下标
			for (int b = 0; b < 10; b++) {// 从0到9号桶按照顺序取出
				loopNum++;
				if (count[b] == 0)// 如果这个桶中没有元素放入，那么跳过
					continue;
				for (int w = 0; w < count[b]; w++) {
					loopNum++;
					A[k++] = bucket[b][w];
				}
				count[b] = 0;// 桶中的元素已经全部取出，计数器归零
			}
			divisor *= 10;
		}
		System.out.println(loopNum);
		return A;
	}

	public static int[] sort4(int[] arr) {

		int loopNum = 0;
		for (int i = arr.length/2; i > 0; i/=2) {

			loopNum++;
			for (int j = i; j < arr.length; j++) {
				loopNum++;
				int  m = j;
				int temp = arr[m];

				// 后面的比前面的数小
				if (temp < arr[m-i]) {

					//往前遍历查找比当前数小的
					while (m - i >= 0 && temp<arr[m-i]){
						loopNum++;
						//交换位置
						arr[m] = arr[m-i];
						m -= i;
					}

					// 当前数据所在的位置
					arr[m] = temp;
				}
			}
		}

		System.out.println(loopNum);
		return arr;
	}


	/**
	 * 冒泡排序 性能最差
	 * @param arr
	 */
	public static int[] sort(int[] arr) {

		int loopNum = 0;
		for (int i = 0; i < arr.length; i++) {
			loopNum++;
			for (int j = i+1; j < arr.length; j++) {
				loopNum++;
				int pre = arr[i];
				int aft = arr[j];
				if (pre > aft) {
					arr[i] = aft;
					arr[j] = pre;
				}
			}
		}

		System.out.println(loopNum);
		return arr;
	}

	/**
	 * 冒泡排序 性能最优
	 * @param arr
	 * @return
	 */
	public static int[] sort1(int[] arr) {

		int loopNum = 0;
		for (int j = 0; j < arr.length-1; j++){
			loopNum++;
			int pre = arr[j];
			int aft = arr[j+1];
			if (pre > aft) {

				arr[j] = aft;
				arr[j+1] = pre;

				int i = j-1;
				int preN;

				while (i >= 0 && (preN = arr[i]) > aft) {
					loopNum++;
					arr[i] = aft;
					arr[i+1] = preN;
					i--;
				}
			}
		}

		System.out.println(loopNum);
		return arr;
	}

	public static int[] sort2(int[] arr) {
		int loopNum = 0;
		int length = arr.length;
		boolean sorted = true;
		for(int j=0;j<length-1;j++) { //循环次数  每完成一次  沉入底部一个数
			loopNum++;
			sorted = true; //每一次开始  默认已经排好序
			for(int i=0;i<length-1-j;i++) {
				loopNum++;
				if(arr[i] > arr[i+1]) {
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					sorted = false; //还没有排好序
				}
			}
			if(sorted) { //确实已经排好序了
				break; //不再继续循环
			}
		}

		System.out.println(loopNum);
		return arr;
	}

	public static int[] sort5(int[] arr) {

		for (int grap = arr.length/2; grap > 0; grap /= 2){

			for (int i = grap; i < arr.length; i++) {

				int m = i;
				int aft = arr[m];
				if (aft < arr[m-grap]) {
					while ( m - i >= 0 && aft < arr[m-grap]){
						arr[m] = arr[m-grap];
						m -= grap;
					}

					arr[m] = aft;
				}
			}

		}
		return arr;
	}


	static class ListNode{
		public int val;
		public ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}
	/**
	 * 输入两个链表, 为位数逆序存储的数字，要求逆序输出这两个数字的和
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode head=null, tail=null;
		int carry = 0;

		while (l1 != null || l2 != null) {

			int n1 = l1 != null ?l1.val : 0;

			int n2 = l2 != null ?l2.val : 0;

			int sum = n1 + n2 + carry;

			if (head == null) {
				head = tail = new ListNode(sum % 10);
			}else {
				tail = tail.next = new ListNode(sum % 10);
			}

			carry = sum / 10;

			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}

		if (carry > 0) {
			tail.next = new ListNode(carry);
		}

		return head;
	}


	/**
	 * 计算给定字符串中不包含重复字符的子串的最长个数
	 * @param s
	 * @return
	 */
	public static int lengthOfLongestSubstring(String s) {
		Set<Character> characters = new HashSet<>();
		int len= s.length();

		int rp = -1; // 右指针，标识还没开始滑动
		int n = 0; // 记录最长子串的长度
		// i 标识起始指针（左指针）
		for (int i =0; i < len; ++i) {

			// 右指针动取字符，将没有重复的字符记录到set同时结束滑动
			char _s;
			while ((rp+1) < len && !characters.contains(_s = s.charAt(rp + 1))) {
				characters.add(_s); //存储从i开始到rp截止不重复的字符
				++rp;
			}
			n = Math.max(n, rp-i+1);

			// 左边指针向右滑动,删除一个字符
			characters.remove(s.charAt(i));
		}

		return n;
	}

	/**
	 * 寻找正序数组中位数:
	 * 1. 需找到k(i,j), i,j分别代表划分两个数组的位置
	 * 2. 保证k位置前的数组长度与k位置后的数组长度一致且k位置前的最大值小于k位置后的最小值
	 * ps: k = i + j, 所有要满足条件2需要
	 * > i+j = m-i+n-j+1 -> j = (m+n+1)/2 - i
	 * > max(Left) <= min(Right)
	 *
	 *
	 * nums1 = {4, 8, 10}, nums2 = {2, 7, 9}
	 * m = nums1.len, n = nums2.len
	 *
	 * left = 0, right = m;
	 *
	 *  ==>  i=(left+right)/2 = 1, j=(m+n+1)/2 -i = 2
	 *       left: 4, 2, 7
	 *       right: 8, 10, 9
	 *       min(right) = 8 > max(left) = 7 -> left=i+1=2
	 *
	 * left = 2, right = 3
	 * ==> i=(left+right)/2 = 2 j=(m+n+1)/2 - i = 1
	 *      left:  4, 8, 2
	 *      right: 10, 7, 9
	 *      min(right) = 7 < max(left) = 8 -> right=i-1=1
	 *
	 * left = 2, right = 1;
	 * end
	 *
	 *
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

		// 确保nums1.len < nums2.len
		if (nums1.length > nums2.length) {
			return findMedianSortedArrays(nums2, nums1);
		}

		int m = nums1.length, n=nums2.length;

		int left = 0, right = m;
		int maxL = 0, minR = 0; // 前部分最大值和后部分最大值

		while (left <= right) {
			int i = (left + right) / 2;
			int j = (m + n +1)/2 -i;

			int l_nums1_max = i == 0 ? Integer.MIN_VALUE: nums1[i-1];
			int l_nums2_max = j == 0 ? Integer.MIN_VALUE : nums2[j-1];

			int r_nums1_min = i == m ? Integer.MAX_VALUE : nums1[i];
			int r_nums2_min = j == n ? Integer.MAX_VALUE : nums2[j];

			if (l_nums1_max <= r_nums2_min) {
				maxL = Math.max(l_nums2_max, l_nums1_max);
				minR = Math.min(r_nums2_min, r_nums1_min);

				left = i + 1;
			}else {

				right = i - 1;
			}
		}

		return (m+n) % 2 == 0 ? (maxL + minR) /2.0 : maxL;
	}

	/**
	 * 动态规划
	 * 最长回文子串
	 *
	 * 1, 2, 3, 4, 6, 7, 8,
	 * @param s
	 * @return
	 */
	public static String longestPalindrome(String s) {

		/**
		 * s.len > 2
		 * subMaxLen=1
		 * P(i,j) 表示字符串S的第i到j个字母组成的串是否为回文串:
		 * true: 表示 Si...Sj是回文串
		 * false: 其他情况（不是回文串或i>j）
		 *
		 * P(i,j) = P(i+1, j-1) & (Si == Sj)
		 * 方程的含义：
		 *  Si...Sj是回文的必要条件
		 *  1. Si+1...Sj-1是回文
		 *  2. Si == Sj
		 * 也就是S[i+1:j-1]是回文串且S的第i和j个字母相同时，S[i,j]才是回文串P(i,j)才为true
		 *
		 * 最终答案：P(i,j)=true中 j - i + 1的最大值.
		 *
		 */

		final int len = s.length();
		if (len < 2) {
			return s;
		}

		final char[] charArray = s.toCharArray();

		boolean[][] dp = new boolean[len][len];
		// 初始化所有单字符都是回文串
		for (int i = 0; i < len; i++) {
			dp[i][i] = true;
		}

		//先遍历子串 L子串的长度
		int maxL = 1;
		int be = 0;
		for(int L = 2; L <= len; L++) {
			for (int i = 0; i < len; i++) {

				int j = L + i - 1;

				if (j >= len) {
					break;
				}

				if (charArray[i] != charArray[j]) {
					dp[i][j] = false;
				}else {

					if (j - i < 3) {

						dp[i][j] = true;
					}else {
						dp[i][j] = dp[i+1][j-1];
					}
				}

				if (dp[i][j] && j-i+1 > maxL) {
					maxL = j-i+1;
					be = i;
				}
			}
		}
		return s.substring(be, be+maxL);
	}

	/**
	 * 最小回文扩展
	 * 最小回文子串长度1或2
	 * @param s
	 * @return
	 */
	public static String longestPalindrome2(String s) {

		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {

			int len = expandAroundCenter(s, i, i); // 从回文长度为1开始
			int len1 = expandAroundCenter(s, i, i+1); // 从回文长度为2开始

			final int maxL = Math.max(len1, len);
			if (maxL > end - start) {
				start = i - (len - 1)/2;
				end = i + len/2;
			}
		}

		return s.substring(start, end+1);
	}
	public static int expandAroundCenter(String s, int left, int right) {

		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			--left;
			++right;
		}

		return right - left - 1;
	}


	public static void main(String[] args) {

//		int[] arr = {2, 1, 5, 8, 3, 9, 4, 0};
		int[] arr = {9,8,7,6,5,4,3,2,1};
		System.out.println(sort(arr));

		int[] arr1 = {9,8,7,6,5,4,3,2,1};
		System.out.println(sort1(arr1));

		int[] arr2 = {9,8,7,6,5,4,3,2,1};
		System.out.println(sort2(arr2));

		int[] arr3 = {9,8,7,6,5,4,3,2,1};
		System.out.println(sort4(arr3));

		int[] arr4 = {9,8,7,6,5,4,3,2,1};
		System.out.println(radixSort(arr4));

		int[] arr5 = {9,8,7,6,5,4,3,2,1};
		System.out.println(sort(arr5, 0, arr5.length-1));

		int[] arr6 = {9,8,7,6,5,4,3,2,1};
		System.out.println(sort5(arr6));

		int[] arr7 = {9,8,7,6,5,4,3,2,1};
		System.out.println(insertSort(arr7));
	}
}
