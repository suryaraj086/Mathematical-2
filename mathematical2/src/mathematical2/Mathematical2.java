package mathematical2;

import java.util.*;

public class Mathematical2 {

	public void primeFactors(int n) {
		int count = 0;
		System.out.print(1);
		for (int i = 1;; i++) {
			if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0) {
				System.out.print(i);
				count++;
			}
			if (count == n - 1) {
				break;
			}
		}
	}

	public void maxPrime(long n) {
		String temp = n + "";
		char[] ch = temp.toCharArray();
		Arrays.sort(ch);
		temp = "";
		for (int i = ch.length - 1; i >= 0; i--) {
			temp += ch[i];
		}
		if (Long.parseLong(temp) % 2 != 0) {
			System.out.println(temp);
		}
	}

	public String removeDigits(int n) {
		StringBuilder str = new StringBuilder(n + "");
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			str = str.replace(i, i + 1, "");
			if (Integer.parseInt(str.toString()) % 8 == 0) {
				return str.toString();
			}
			str.replace(i, i, ch + "");
		}
		return "No";
	}

	public int largestDigit(long n, int d) {
		String inp = n + "";
		int index = inp.indexOf(d + "");
		inp = inp.substring(index);
		int count = 0;
		for (int i = 0; i < inp.length(); i++) {
			int temp = Integer.parseInt(inp.charAt(i) + "");
			if (count < temp) {
				count = temp;
			}
		}
		return count;
	}

	static int x[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int y[] = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static int temp1 = 0;
	static int temp = 0;

	public int queenPath(int N, int x, int y, int[] kx1, int kx2[]) {
		int[][] grid = new int[N][N];
		for (int i = 0; i < kx1.length; i++) {
			grid[kx1[i]][kx2[i]] = 1;
		}
		grid[x][y] = 2;
		ArrayList<Integer> list = new ArrayList<>();

		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				search(grid, row, col, 2);
			}
		}
		return temp;
	}

	static boolean search(int[][] grid, int row, int col, int num) {

		if (grid[row][col] != num) {
			return false;
		}

		for (int dir = 0; dir < 8; dir++) {
			int k, rd = row + x[dir], cd = col + y[dir];
			int wordLen = grid.length;
			for (k = 0; k < wordLen; k++) {
				if (rd >= grid.length || rd < 0 || cd >= grid[0].length || cd < 0) {
					break;
				}

				if (grid[rd][cd] != 0) {

					break;
				}
				rd += x[dir];
				cd += y[dir];
				temp1++;
			}
			temp += temp1;
			temp1 = 0;
		}
		return false;
	}

	public String hexaToBinary(String inp) {
		Map<Character, String> map = new HashMap<Character, String>();
		map.put('A', "1010");
		map.put('B', "1011");
		map.put('C', "1100");
		map.put('D', "1101");
		map.put('E', "1110");
		map.put('F', "1111");
		String out = "";
		for (int i = 0; i < inp.length(); i++) {
			char temp = inp.charAt(i);
			if (temp > '0' && temp < '9') {
				out += binary(Integer.parseInt(temp + ""));
			} else {
				out += map.get(temp);
			}
		}
		return out;
	}

	public String binary(int n) {
		String temp = "";
		while (n > 0) {
			temp = n % 2 + temp;
			n = n / 2;
		}
		while (temp.length() < 4) {
			temp = "0" + temp;
		}
		return temp;
	}

//	public String hexa(String inp) {
//		String temp = "";
//		while (n > 0) {
//			temp = n % 2 + temp;
//			n = n / 2;
//		}
//		while (temp.length() < 4) {
//			temp = "0" + temp;
//		}
//		return temp;
//	}

//	public String binaryToHexa(String inp) {
//
//		return inp;
//	}

	public int palindrome(int n) {
		int count = 0;
		int val = 10;
		return isPalindrome(n, count, val);
	}

	public int isPalindrome(int n, int count, int val) {
		StringBuilder inp = new StringBuilder(val + "");
		String temp = inp.toString();
		if (count == n) {
			return --val;
		}
		if (temp.equals(inp.reverse().toString())) {
			return isPalindrome(n, ++count, ++val);
		}
		return isPalindrome(n, count, ++val);
	}

	public static void main(String[] args) {
		Mathematical2 mObj = new Mathematical2();
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		switch (choice) {
		case 1:
			mObj.primeFactors(11);
			break;
		case 2:
			mObj.removeDigits(3454);
			break;
		case 3:
			mObj.maxPrime(43196);
			break;
		case 4:
			System.out.print(mObj.largestDigit(14586254, 4));
			break;
		case 5:
			int[] kx1 = {};
			int[] kx2 = {};
			System.out.print(mObj.queenPath(8, 4, 4, kx1, kx2));
			break;
		case 6:
			System.out.print(mObj.hexaToBinary("1AC5"));
			break;
		case 7:
			System.out.print(mObj.palindrome(11));
			break;

		default:
			break;
		}
	}
}
