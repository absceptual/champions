// Source: https://usaco.guide/general/io
// http://www.usaco.org/index.php?page=viewproblem2&cpid=855

import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Solution {
	static class InputReader {
		BufferedReader reader;
		StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public InputReader(String filename) {
			try {
				reader = new BufferedReader(new FileReader(filename));
			}
			catch (IOException e) {
				throw new RuntimeException(e);
			}
			tokenizer = null;
		}

		String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				}
				catch (Exception e) {
					return null;
				}
			}

			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}

	// static InputReader r = new InputReader("word.in");
	// static PrintWriter pw = new PrintWriter("word.out");

	public static void main(String[] args) throws IOException {
		InputReader r  = new InputReader("mixmilk.in");
		PrintWriter pw = new PrintWriter("mixmilk.out");

		List<Integer> capacities = new ArrayList<Integer>(3);
		List<Integer> amounts    = new ArrayList<Integer>(3);

		for (int i = 0; i < 3; ++i) { capacities.add(r.nextInt()); amounts.add(r.nextInt()); }
		
		int TURN_NUMBER = 0;
		for (int i = TURN_NUMBER; i < 100; ++i) {
			int index = i % 3;
			int next = (index + 1) % 3;

			int amount = amounts.get(index);
			int capacity = capacities.get(next);

			if (amount + amounts.get(next) > capacity ) {
				int given = capacity - amounts.get(next);
				given = amount - given;

				amounts.set(index, given);
				amounts.set(next, capacity);
			}
			else {
				amounts.set(index, 0);
				amounts.set(next, amounts.get(next) + amount);
			}
				
		}
 		
		for (int n : amounts) 
			pw.println(n);
		pw.close();
	}
}
