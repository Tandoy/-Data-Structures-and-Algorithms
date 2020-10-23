package com.tz;

public class Main {
    /*
     * 求第N个斐波那契数
     * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 	   F(0) = 0,   F(1) = 1
	   F(N) = F(N - 1) + F(N - 2), 其中 N > 1.

	 0 1 1 2 3 5 8
	 0 1 2 3 4 5 6
	 输入：n = 4
	 输出：3
     * */
	public static int fib1(int n) {
		// 时间复杂度：O(2^n)
		if(n <= 1) return n;
		return fib1(n - 1) + fib1(n - 2);
	}
	public static int fib2(int n) {
		// 时间复杂度：O(n)
		if(n <= 1) return n;
		int frist = 0;
		int second = 1;
		for (int i = 0; i < n -1 ; i++) {
			int sum = frist + second;
			frist = second;
			second = sum;
		}
		return second;
	}
		public static int fib3(int n) {
			// 时间复杂度：O(n)
			if(n <= 1) return n;
			int frist = 0;
			int second = 1;
			while (n -- > 1){
				 second += frist;
				 frist = second - frist;
			}
			return second;
	}
	public static void main(String[] args) {
		   System.out.println(fib2(12));
		   System.out.println(fib3(12));
 	}
}
