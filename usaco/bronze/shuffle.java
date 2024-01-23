// http://www.usaco.org/index.php?page=viewproblem2&cpid=760
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
		InputReader r  = new InputReader("shuffle.in");
		PrintWriter pw = new PrintWriter("shuffle.out");

		int n = r.nextInt();

		int[] ordering = new int[n];
		for (int i = 0; i < n; ++i) 
			ordering[i] = r.nextInt();

		int[] original = new int[n];
		int[] shuffle = new int[n];
		for (int i = 0; i < n; ++i)
			shuffle[i] = original[i] =  r.nextInt();

		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < n; ++j) {
				int target = ordering[j] - 1;
			}

			for (int j = 0; j < n; ++j) 
				shuffle[j] = original[j];
		}
		for (int k = 0; k < n; ++k)
			pw.println(original[k]);
		
		pw.close();
	}
}
