package test1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

class NewRunner {

	public static void main(String[] args) throws IOException {
		String str = "000000";
		System.out.println(Integer.valueOf(str));
		MotorBike yuyu = new MotorBike();

//		
//		final int a=20;
//		//a = 20;
//		System.out.println(a);
//		
//		//Rectangle obj = new Rectangle(2,5);
//		Rectangle obj1 = new Rectangle(2, 8);
//		obj1.getRectangle(2, 3);
//		
//		Rectangle obj2 = new Square();
//		obj2.getRectangle(1, 2);
//		obj2.getSquare();
//		
//		 Runtime.getRuntime().exec("notepad");//will open a new notepad  
		
//		Rectangle obj = Rectangle.test();
//		
//		obj.setBre(5);
//		obj.setLen(8);
//		System.out.println(obj);
//		
//		Rectangle obj2 = Rectangle.test();
//		
//		obj2.setBre(5);
//		obj2.setLen(10);
//		System.out.println(obj2);
		
		
		//Rectangle obj2 = obj;
//		System.out.println(obj2);
//		
//		obj.setBre(0);
//		
//		System.out.println(obj2);
		
//		int n = str.length();
//		Solution permutation = new Solution();
//		Solution pp = new Solution(1,2);
//		Solution oi = new Solution(1f, 1f);
		//System.out.println(permutation.palidrome("Nitin"));
	}
}

// } Driver Code Ends

class Solution {
	
	int variable1, variable2;
	
	public Solution() {
		System.out.println("ata");
	}
	
	public Solution(int a,int b) {
		System.out.println("abc:");
	}
	
	public Solution(float a, float b) {
		System.out.println("uyyyu");
	}

	// a: input array
	// n: size of array
	// Function to find equilibrium point in the array.
	public static int equilibriumPoint(long arr[], int n) {

		if (n == 1) {
			return 1;
		}
		for (int i = 0; i < n; i++) {
			long sumLeft = 0;
			long sumRight = 0;
			for (int j = i - 1; j >= 0; j--) {
				sumLeft = sumLeft + arr[j];
			}

			for (int k = i + 1; k < n; k++) {
				sumRight = sumRight + arr[k];
			}

			if (sumLeft == sumRight) {
				return i + 1;
			}
		}
		return -1;

		// Your code here
	}

	int strstr(String s, String x) {
		int size = x.length();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == x.charAt(0)) {
				Boolean flag = true;

				int m = 1;
				if (i + size <= s.length()) {
					while (m < size) {
						if (s.charAt(i + m) != x.charAt(m)) {
							flag = false;
							break;
						}
						m++;
					}
				}
				if (flag == true) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public static ArrayList<Integer> duplicates(int arr[], int n) {
		ArrayList<Integer> t = new ArrayList<>();
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (hm.containsKey(arr[i])) {
				int value = hm.get(arr[i]);
				hm.put(arr[i], value + 1);

			} else {
				hm.put(arr[i], 1);
			}
		}

		for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
			if (e.getValue() > 1) {
				t.add(e.getKey());
			}
		}

		if (t.isEmpty()) {
			t.add(-1);
		}
		Collections.sort(t);
		return t;
	}

	char nonrepeatingCharacter(String S) {
		char ret = '$';
		// HashMap<Character,Integer> t = new HashMap<>();
		Map<Character, Integer> t = new LinkedHashMap<Character, Integer>();
		for (int i = 0; i < S.length(); i++) {
			if (t.containsKey(S.charAt(i))) {
				int count = t.get(S.charAt(i));
				t.put(S.charAt(i), ++count);
			} else {
				t.put(S.charAt(i), 1);
			}
		}

		for (Map.Entry<Character, Integer> e : t.entrySet()) {

			if (e.getValue() == 1) {
				ret = e.getKey();
				break;
			} else {
				ret = '$';
			}
		}
		return ret;
	}

	int lenOfLongSubarr(int A[], int N, int K) {
		int ans = 0;

		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				int sum = 0;
				for (int l = i; l <= j; l++) {
					sum += A[l];
				}
				if (sum == K) {
					ans = Math.max(ans, j - i + 1);
				}
			}
		}

		return ans;
	}

	public void permute(String str, int l, int r) {
		if (l == r)
			System.out.println(str);
		else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				permute(str, l + 1, r);
				str = swap(str, l, i);
			}
		}
	}

	/**
	 * Swap Characters at position
	 * 
	 * @param a string value
	 * @param i position 1
	 * @param j position 2
	 * @return swapped string
	 */
	public String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

	public static int[] calculateSpan(int price[], int n) {
		// Your code here
		int[] counts = new int[n];
		for (int i = 0; i < n; i++) {
			int count = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (price[i] > price[j]) {
					count++;
				} else {
					break;
				}
			}
			counts[i] = count;
		}
		return counts;
	}

	public static int[] calculateSpanApproach2(int price[], int n) {
		// Your code here
		Stack<Integer> s = new Stack<>();
		int[] ans = new int[n];
		for (int i = 0; i < n; i++) {
			while (s.size() > 0 && price[s.peek()] <= price[i])
				s.pop();
			if (s.size() == 0)
				ans[i] = i + 1;
			else
				ans[i] = i - s.peek();
			s.push(i);
		}
		return ans;
	}

	public Boolean palidrome(String s) {
		s = s.toUpperCase();
		int n = s.length();
		Boolean t = true;
		if (n == 1) {
			t = true;
		}
		for (int i = 0; i < n / 2; i++) {
			if (s.charAt(i) != s.charAt(n - 1 - i)) {
				t = false;
				break;
			}
		}
		return t;
	}
}
