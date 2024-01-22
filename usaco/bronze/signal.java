// http://www.usaco.org/index.php?page=viewproblem2&cpid=855
// Source: https://usaco.guide/general/io

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
		InputReader r  = new InputReader("cowsignal.in");
		PrintWriter pw = new PrintWriter("cowsignal.out");

		int m = r.nextInt();
		int n = r.nextInt();
		int k = r.nextInt();

		String signal = "";
		for (int i = 0; i < m; ++i) {
			String original = r.next();
			String copy = "";

			for (int j = 0; j < n; ++j) {

				String result = "";
				for (int l = 0; l < k; ++l)
					result += original.charAt(j);

				copy += result;
			}

			for (int j = 0; j < k; ++j)
				signal += copy + "\n";
		}
		
		pw.println(signal.strip());
		pw.close();
	}
}
